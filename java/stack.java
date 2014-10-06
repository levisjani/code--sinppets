//Perform various operations on stack.

import java.util.Scanner;

class StackArray
{
   int max=100;
   int stk[] = new int[max];
   int top;
   StackArray()
   {
     top = -1;
   }
   
   void push (int item)
   {
     if (top==max)
       System.out.println("Stack overflow");
     else
       stk[++top] = item;
   }
   
   boolean isEmpty()
   {
     if (top < 0)
       return true;
     else
       return false;
   }
   
   int pop()
   {
     if (isEmpty())
     {
       System.out.println("Stack underflow");
       return 0;
     }
     else
     {
       return (stk[top--]);
     }
   }
     
   void stacktop()
   {
     if (isEmpty())
       System.out.println("Stack underflow ");
     else
       System.out.println("Stack top is " + (stk[top]));
   }
   
   void display()
   {
     System.out.print("Stack--> ");
     if (top==-1)
       System.out.println("Empty");
     else
     for (int i=0; i<=top; i++)
       System.out.print(stk[i] + "  ");
     
     System.out.println("\n");
   }
}

class Stack
{
   public static void main(String args[])
   {
     StackArray s = new StackArray();
     
     Scanner in = new Scanner(System.in);
     
     while (true) {
       System.out.println("Choose operation: ");
       System.out.println("1. Push");
       System.out.println("2. Pop");
       System.out.println("3. Exit");
       int choice = in.nextInt();
       
       switch (choice) {
       case 1: {
         System.out.print("Enter value to push: ");
         int p = in.nextInt();
         s.push(p);
         s.display();
         break;
         }
       case 2:
         s.pop();
         s.display();
         break;
       
       case 3:
         return;
       default:
         continue;
       }
     }

   }
}
