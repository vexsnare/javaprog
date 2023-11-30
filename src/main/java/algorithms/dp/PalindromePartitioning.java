package algorithms.dp;

import java.util.Arrays;

/**
 * @author vinay.saini
 * @created 17/08/2020 - 10:47 PM
 */
public class PalindromePartitioning {
    public int minCut(String A) {
        int n = A.length();
        boolean P[][] = new boolean[n][n];
        int C[][] = new int[n][n];

        for(int i = 0; i < n; i++) P[i][i] = true;
        for(int l = 1; l < n; l++) {
            for(int i = 0; i+l < n; i++) {
                int j = i + l;
                P[i][j] = A.charAt(i) == A.charAt(j);
                if(l > 1) P[i][j] &= P[i+1][j-1];
            }
        }
        for(int i = 0; i < n; i++) Arrays.fill(C[i], Integer.MAX_VALUE);
        for(int i = 0; i < n; i++) C[i][i] = 0;
        for(int l = 1; l < n; l++) {
            for(int i = 0; i+l < n; i++) {
                int j = i + l;
                if(P[i][j]) C[i][j] = 0;
                else
                    for(int k = i; k < j; k++) {
                        C[i][j] = Math.min(C[i][j], 1 + C[i][k] + C[k+1][j]);
                    }
            }
        }
        return C[0][n-1];
    }

    //Driver
    public static void main(String[] args) {
        PalindromePartitioning pp = new PalindromePartitioning();
        System.out.println(pp.minCut("aab"));
    }
}
