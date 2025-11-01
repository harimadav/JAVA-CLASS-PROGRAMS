package array;
import java.util.*;

public class addtion_2D_Array {
		public static void main(String[] args) {
			int a[][]=new int[3][3];
			Scanner sc = new Scanner(System.in);
			for (int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					System.out.print("Enter a["+i+"]["+j+"]:");
					a[i][j]=sc.nextInt();
				}
			}
			int b[][]=new int[3][3];
			for (int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					System.out.print("Enter b["+i+"]["+j+"]:");
					b[i][j]=sc.nextInt();
				}
			}
			int r[][]=new int[3][3];
			for (int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					
					r[i][j] = a[i][j]+b[i][j];
				}
			}
			for (int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					System.out.println(r[i][j]);
				}
			}
			sc.close();

		}
}	
