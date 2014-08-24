#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>

int main () {

	char c;
	for (;;){
		printf("Type y to continue: ");
		printf("Type q to quit: ");
		scanf("%s", &c);
		getchar();
		c = tolower(c);
		if(c=='q'){
			printf("Exit at user request: ");
			return(0);
			}
		}
}
