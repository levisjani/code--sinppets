#include <linux/init.h>
#include <linux/module.h>

static void hello_init(void){

	printk(KERN_ALERT "TEST: Hello kernel");
	return 0;

}

static void hello_exit(void){

	printk(KERN_ALERT "TEST: Exit test");

}

module_init(hello_init);
module_exit(hello_exit);
