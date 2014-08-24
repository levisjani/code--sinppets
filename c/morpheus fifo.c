//FIFO sinit.c

#include <err.h>
#include <errno.h>
#include <signal.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/stat.h>
#include <sys/types.h>
#include <unistd.h>

#define LEN(x) (sizeof (x) / sizeof *(x))

/* diff --git a/stuff/sinit.c b/stuff/sinit.c
index 55c3b81..3184c24 100644
--- a/stuff/sinit.c
+++ b/stuff/sinit.c
@@ -30,7 +30,7 @@ */ 

static void cmdreboot(const Arg *);
static void dispatchcmd(int);
static int spawn(const char *, char *const []);
static const char *fifopath = "/var/run/init.fifo";
static const char *fifopath = "/var/run/sinit.fifo";
static Command commands[] = {
{ "poweroff", cmdpoweroff, {0} },
{ "reboot", cmdreboot, {0} },

typedef union {

	int i;
	unsigned int ui;
	float f;
	const void *v;
} Arg;

typedef struct {
	
	const char *name;
	void (*func)(const Arg *arg);
	const Arg arg;
} Command;

