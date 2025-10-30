package array;

import java.util.*;
public class creation_2D_Array {
	public static void main(String[] args) {
		int a[][]=new int[3][3];
		Scanner sc = new Scanner(System.in);
		for (int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				System.out.print("Enter a["+i+"]["+j+"]:");
				a[i][j]=sc.nextInt();
			}
		}
		//display
		for (int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				System.out.print(a[i][j]+ "\t");
				
			}
			System.out.println();
		}
		sc.close();
	}
}
		

	
