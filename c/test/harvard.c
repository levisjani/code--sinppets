#include <stdio.h>

//prototype
chorus ();

int main (void)
{
int n;
printf("How many bottles will there be ??\n");
printf("Give number of bottles:%d ",n);
scanf("%d", &n);
chorus(n);
return 0;

}

void chorus(int bottles)
{
	int i;

	for (i = bottles; i >= 1; 1--)
	{
	     char s = (i == 1) ? "bottle" : "bottles"; //turnery operator
	     printf("%d $s of beers on the wall\n",i,s);
	     printf("%d $s of beers on the wall\n",i,s);
	     printf("Take one down, pass it around.\n");
	     printf("%d of beers on the wall.\n",i-1);
	}
}
