package array;

import java.util.*;

public class determinant {
    public static void main(String[] args) {
        int[][] a = new int[3][3];
        Scanner sc = new Scanner(System.in);

        // Input
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print("Enter a[" + row + "][" + col + "]: ");
                a[row][col] = sc.nextInt();
            }
        }

        // Display
        System.out.println("\nMatrix:");
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(a[row][col] + "\t");
            }
            System.out.println();
        }

        // Assign variables (matching formula)
        int b11 = a[0][0], b12 = a[0][1], b13 = a[0][2];
        int b21 = a[1][0], b22 = a[1][1], b23 = a[1][2];
        int b31 = a[2][0], b32 = a[2][1], b33 = a[2][2];

        // Determinant calculation
        int det = b11 * (b22 * b33 - b23 * b32)
                - b12 * (b21 * b33 - b23 * b31)
                + b13 * (b21 * b32 - b22 * b31);

        System.out.println("\nDeterminant of A is: " + det);
        sc.close();
    }
}

	


