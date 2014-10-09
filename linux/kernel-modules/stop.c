/*
 *  stop.c - Multi filled modules
 */
 
#include <linux/kernel.h>
#include <linux/module.h>

void cleanup_module()
{
  
  printk(KERN_INFO "Test kernel module");
  
}
