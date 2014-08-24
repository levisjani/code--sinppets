#include <stdio.h>
#include <ncurses.h>

int main (void){

	int i=0;

	while(1 < 15){
	printf("%d\n",rand());
	i++;
	}

	getch();
	return 0;
}
