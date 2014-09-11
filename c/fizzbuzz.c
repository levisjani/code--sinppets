#include<stdio.h>
#include<conio.h>

int main(void){
    
    int i;
    printf("Numbers from 1-100: \n");
    for(i=1; i<=100; i++){
        
        if(i%3==0){
           printf("Fizz");
        }
        
        if(i%5==0){
           printf("Buzz");
                }
        
        printf(" %d \n",i);
        
        }
    getch();    
             
    }
