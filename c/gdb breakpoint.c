#include <stdio.h>
int power(int, int);

int main()
{
	int i;
	printf("program to calculate the power\n");
	for (i = 0; i < 10; ++i)
	{
		printf("%d %d \n", i, power(2,i) );
	}
	return 0;
}

//function power

int power(int base, int n)
{
	int i,p;
	p = 1;
	for (i = 0; i <= n; ++i)
	{
		p = p*base;
	}
	return p;
}
