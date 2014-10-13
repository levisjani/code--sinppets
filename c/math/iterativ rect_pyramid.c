#include<stdio.h>
 
int main() {
    int number, row, col;
    int displayNum;
 
    printf("\nEnter Number of Rows to be display : \n");
    scanf("%d", &number);
 
    for (row = 1; row <= number; row++) {
        displayNum = 1;
        for (col = 1; col <= number; col++) {
            printf("%d\t", displayNum++);
        }
        printf("\n");
    }
 
    return 0;
}
