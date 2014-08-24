// /pub/linux/kernel/v3.x/testing/patch-3.14-rc5.xz

a/drivers/ata/sata_mv.c
b/drivers/ata/sata_mv.c
@@ -60,6 +60,7 @@
#include <linux/dma-mapping.h>
#include <linux/device.h>
#include <linux/clk.h>
#include <linux/phy/phy.h>
#include <linux/platform_device.h>
#include <linux/ata_platform.h>
#include <linux/mbus.h>
@@ -304,6 +305,7 @@ enum {
MV5_LTMODE = 0x30,
MV5_PHY_CTL = 0x0C,
SATA_IFCFG = 0x050,
LP_PHY_CTL = 0x058,
MV_M2_PREAMP_MASK = 0x7e0,
@@ -431,6 +433,7 @@ enum {
MV_HP_CUT_THROUGH = (1 << 10), /* can use EDMA cut-through */
MV_HP_FLAG_SOC = (1 << 11), /* SystemOnChip, no PCI */
MV_HP_QUIRK_LED_BLINK_EN = (1 << 12), /* is led blinking enabled? */
MV_HP_FIX_LP_PHY_CTL = (1 << 13), /* fix speed in LP_PHY_CTL ? */
/* Port private flags (pp_flags) */
MV_PP_FLAG_EDMA_EN = (1 << 0), /* is EDMA engine enabled? */
@@ -563,6 +566,12 @@ struct mv_host_priv {
struct clk *clk;
struct clk **port_clks;
/*
 * Some devices have a SATA PHY which can be enabled/disabled
 * in order to save power. These are optional: if the platform
 * devices does not have any phy, they won't be used.
 */
 struct phy **port_phys;
 /*
* These consistent DMA memory pools give us guaranteed
* alignment for hardware-accessed data structures,
* and less memory waste in accomplishing the alignment.
@@ -1358,6 +1367,7 @@ static int mv_scr_write(struct ata_link *link, unsigned int sc_reg_in, u32 val)
if (ofs != 0xffffffffU) {
void __iomem *addr = mv_ap_base(link->ap) + ofs;
struct mv_host_priv *hpriv = link->ap->host->private_data;
if (sc_reg_in == SCR_CONTROL) {
/*
* Workaround for 88SX60x1 FEr SATA#26:
@@ -1374,6 +1384,18 @@ static int mv_scr_write(struct ata_link *link, unsigned int sc_reg_in, u32 val)
*/
if ((val & 0xf) == 1 || (readl(addr) & 0xf) == 1)
val |= 0xf000;

if (hpriv->hp_flags & MV_HP_FIX_LP_PHY_CTL) {
 void __iomem *lp_phy_addr =
 mv_ap_base(link->ap) + LP_PHY_CTL;
 /*
 * Set PHY speed according to SControl speed.
 */
if ((val & 0xf0) == 0x10)
 writelfl(0x7, lp_phy_addr);
 else
 writelfl(0x227, lp_phy_addr);
 }
}
writelfl(val, addr);
return 0;
@@ -4076,8 +4098,12 @@ static int mv_platform_probe(struct platform_device *pdev)
GFP_KERNEL);
if (!hpriv->port_clks)
return -ENOMEM;
 hpriv->port_phys = devm_kzalloc(&pdev->dev,
 sizeof(struct phy *) * n_ports,
 GFP_KERNEL);
 if (!hpriv->port_phys)
 return -ENOMEM;
host->private_data = hpriv;
 hpriv->n_ports = n_ports;
hpriv->board_idx = chip_soc;
host->iomap = NULL;
@@ -4097,8 +4123,26 @@ static int mv_platform_probe(struct platform_device *pdev)
hpriv->port_clks[port] = clk_get(&pdev->dev, port_number);
if (!IS_ERR(hpriv->port_clks[port]))
clk_prepare_enable(hpriv->port_clks[port]);

 sprintf(port_number, "port%d", port);
 hpriv->port_phys[port] = devm_phy_optional_get(&pdev->dev,
 port_number);
 if (IS_ERR(hpriv->port_phys[port])) {
 rc = PTR_ERR(hpriv->port_phys[port]);
 hpriv->port_phys[port] = NULL;
 if (rc != -EPROBE_DEFER)
 dev_warn(&pdev->dev, "error getting phy %d", rc);

 /* Cleanup only the initialized ports */
 hpriv->n_ports = port;
 goto err;
 } else
 phy_power_on(hpriv->port_phys[port]);
}
 /* All the ports have been initialized */
 hpriv->n_ports = n_ports;

/*
* (Re-)program MBUS remapping windows if we are asked to.
*/
@@ -4110,6 +4154,15 @@ static int mv_platform_probe(struct platform_device *pdev)
if (rc)
goto err;
 /*
 * To allow disk hotplug on Armada 370/XP SoCs, the PHY speed must be
 * updated in the LP_PHY_CTL register.
 */
 if (pdev->dev.of_node &&
 of_device_is_compatible(pdev->dev.of_node,
 "marvell,armada-370-sata"))
 hpriv->hp_flags |= MV_HP_FIX_LP_PHY_CTL;

/* initialize adapter */
rc = mv_init_host(host);
if (rc)
@@ -4127,11 +4180,13 @@ err:
clk_disable_unprepare(hpriv->clk);
clk_put(hpriv->clk);
}
 for (port = 0; port < n_ports; port++) {
 for (port = 0; port < hpriv->n_ports; port++) {
if (!IS_ERR(hpriv->port_clks[port])) {
clk_disable_unprepare(hpriv->port_clks[port]);
clk_put(hpriv->port_clks[port]);
}
 if (hpriv->port_phys[port])
 phy_power_off(hpriv->port_phys[port]);
}
return rc;
@@ -4161,6 +4216,8 @@ static int mv_platform_remove(struct platform_device *pdev)
clk_disable_unprepare(hpriv->port_clks[port]);
clk_put(hpriv->port_clks[port]);
}
 if (hpriv->port_phys[port])
 phy_power_off(hpriv->port_phys[port]);
}
return 0;
}
@@ -4209,6 +4266,7 @@ static int mv_platform_resume(struct platform_device *pdev)
#ifdef CONFIG_OF
static struct of_device_id mv_sata_dt_ids[] = {
 { .compatible = "marvell,armada-370-sata", },
{ .compatible = "marvell,orion-sata", },
{},
}; 
