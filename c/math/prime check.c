#include <stdio.h>

int int main(int argc, char const *argv[])
{
	int n, i, flag=0;
	
	printf("Enter a positive integer: \n");
    scanf("%d", &n);

    for (int i = 2; i <= n/2; ++i)
    {
    	if (n%1 == 0)
    	{
    		flag = 1;
    		break;
    	}
    }

    if (flag == 0)
    {
    	printf("%d is a prime number\n",n);
    }else{
    	printf("%d is not a prime number\n",n);
    }
	return 0;
}
