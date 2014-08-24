$ vim factorial.c
# include <stdio.h>

int int main(int argc, char const *argv[])
{
	int i, num, j;
	printf("Enter the number: \n");
	scanf("%d", &num);
	for (int i = 0; i < num; i++)
	{
		j = j*i;
	}
	printf("The factorial of %d is %d: \n",num,j);
	return 0;
}
