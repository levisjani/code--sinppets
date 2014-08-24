#include<stdio.h>
#include<conio.h>

int main(void){
    int n;
    int f;
    
    printf("give an int: ");
    scanf("%d",&n);
    
    if(n<=2){
    f=1;
    printf("%d",f); 
    }
    
    else{
         f = (n-1)+(n-2);
         }
    printf("%d",f); 
    getch();    
    }
