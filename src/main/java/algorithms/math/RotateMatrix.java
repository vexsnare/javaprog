package algorithms.math; /**
 * Created by vinaysaini on 7/5/16.
 */

import java.util.Scanner;

/**
 * http://www.geeksforgeeks.org/inplace-rotate-square-matrix-by-90-degrees/
 * Rotate Matrix 90 degree anti clock wise in place
 */
public class RotateMatrix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int [][] ar = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ar[i][j] = in.nextInt();
            }
        }
        solve(ar,n,m);
        display(ar);
    }
    static void solve(int [][]ar , int n, int m) {
        for (int k = 0; k < n/2; k++) {
            for (int i = k; i < n-k-1; i++) {
                int temp = ar[k][i];
                ar[k][i] = ar[i][n-k-1];
                ar[i][n-k-1] = ar[n-k-1][n-i-1];
                ar[n-k-1][n-i-1] = ar[n-i-1][k];
                ar[n-i-1][k] = temp;
            }
        }
    }
    static void display(int[][] ar) {
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar[i].length; j++) {
                System.out.print(ar[i][j] + " ");
            }
            System.out.println();
        }
    }
}
