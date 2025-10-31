package array;


import java.util.*;

public class multipication_2D_array {
		public static void main(String[] args) {
			
			//Input for a
			int a[][]=new int[3][3];
			Scanner sc = new Scanner(System.in);
			for (int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					System.out.print("Enter a["+i+"]["+j+"]:");
					a[i][j]=sc.nextInt();
				}
			}
			
			// display of a
			System.out.println("Matrix a ");
			for (int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					System.out.print(a[i][j]+"\t");
				}
				System.out.println();
			}
			
			// input of b
			int b[][]=new int[3][3];
			for (int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					System.out.print("Enter b["+i+"]["+j+"]:");
					b[i][j]=sc.nextInt();
				}
			}
		
			
			
			// display of b
			System.out.println("Matrix b ");
			for (int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					System.out.print(b[i][j]+"\t");
				}
				System.out.println();
			}
			
			
			
			
			// Multiplication logic
			int r[][]=new int[3][3];
			for (int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					
					r[i][j] = a[i][j]*b[i][j];
				}
			}
			
			
			// display of multiplied matrix
			System.out.println("Multiplied matrix ");
			for (int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					System.out.print(r[i][j]+"\t");
				}
				System.out.println();
			}
			sc.close();

		}
}	
