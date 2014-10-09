/*
 *  start.c - Multi filled modules
 */
 
#include <linux/kernel.h>
#include <linux/module.h>

include init_module(void)
{
  
  printk(KERN_INFO "Kernel reply - kernel loopback test\n);
  return 0;
  
}
