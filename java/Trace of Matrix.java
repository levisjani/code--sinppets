//Program to calculate the trace of a matrix

import java.util.Scanner;

public class TraceOfMatrix{

	public static void main (String args[]){

		Scanner in;
		in = new Scanner(System.in);

		//Get size of matrix
		System.out.print("Size of square matrix? ");
		int s = in.nextInt();

		int mat[][] = new int[s][s];

		//Get matrix elements
		for (int i=0; i<s ;i++ ) {
			
			System.out.print("Enter elements of row"+(i+1)+ ": ");

			for (int j=0; j<s; j++)
				mat[i][j] = in.nextInt();
		}

		//Calculate trace
		int trace = 0;
		for(int i=0; i<s; i++)
			trace += mat[i][i];

		//Print result
		System.out.println("Trace of matrix = " +trace);
	}
}
