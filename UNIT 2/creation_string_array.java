package array;

import java.util.*;
public class creation_string_array {
	public static void main(String[] args) {
		String a[]= new String[5];
		Scanner sc  = new Scanner(System.in);
		for(int i=0; i<5; i++) {
			System.out.print("a["+i+"]:");
			a[i]=sc.next();
			
		}
		for (int i=0;i<5;i++) {
			System.out.print(a[i]+ " ");
		}
		System.out.println("\nRIT"+5); // BY DEFAULT IT WILL TAKE IT AS STRING SO THAT IT COMBINES BOTH OF THEM.
		sc.close();
	}
}

// empty space inn string array is stored as '\0'

