#include<stdio.h>
 
int main() {
    int number, row, col;
 
    printf("\nEnter Number of Rows to be display : \n");
    scanf("%d", &number);
 
    for (row = 1; row <= number; row++) {
        for (col = 1; col <= number; col++) {
            if (row == 1 || row == number) {
                printf("1\t");
            } else if (col == 1 || col == number) {
                printf("1\t");
            } else {
                printf("0\t");
            }
        }
        printf("\n");
    }
 
    return 0;
}
