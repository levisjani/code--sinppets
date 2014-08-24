
void swap(int a, int b);

int main(void){

	int x = 1;
	int y = 3;
	
	printf("x is %d\n", x);
	printf("y is %d\n", y);
	printf("Swapping...\n");
	
	swap(x,y);	//call function
	
	printf("Swapped!\n");
	printf("x is %d\n", x);
	printf("y is %d\n", y);
}

void swap(int *a, int *b){

	int tmp;
	
	tmp = *a;
	*a = *b;
	*b = tmp;
}
