package array;

import java.util.*;
public class creation_array {
	public static void main(String[] args) {
		int a[]=new int[5];
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<5; i++) {
			a[i]=sc.nextInt();
		}
		//display
		for (int i=0;i<5;i++) {
			System.out.print(a[i]+ " ");// print gves the output in same line
		}
		sc.close();		
	}
}
