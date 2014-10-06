// Shell Sort Program

public class ShellSort {
   
   public static void main(String args[]) {
     
     int[] x =
     {547, 23, 523, 2378, 243, 7854, 14, 23, 310};
     
     System.out.println("Unsorted list: ");
     display(x);
     
     int inc[] = {5,3,1};
     int numinc = inc.length;
     
     shell(x, inc, numinc);
     System.out.println("Sorted list: ");
     display(x);
   }
   
   private static void shell
     (int x[], int inc[], int numinc) {
     
     int i, span, y, j, k;
     int n = x.length;
     
     for (i=0; i<numinc; i++) {
       
       span = inc[i];
       for(j=span; j<n; j++) {
         y = x[j];
         for (k=j-span; k>=0 && y<x[k]; k-=span)
           x[k+span] = x[k];
         
         x[k+span]=y;
       }
     }
   }
   
   
   private static void display(int x[]) {
     for (int i=0; i<x.length; i++)
       System.out.print(x[i] + " ");
     System.out.println("\n");
   }
}
