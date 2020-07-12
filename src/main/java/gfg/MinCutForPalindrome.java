package gfg; /**
 * Created by vinaysaini on 5/4/16.
 */

import java.util.*;

/**
 *
 * => Dynamic Programing
 *
 * Given a String find minimum number of cut needed to make all the partitions palindrome
 * Ex. dabac : ans = 3  [ 'd', 'aba', 'c' ]
 *
 * Time complexity: O(n^3 & n^2)
 * Space complexity: O(n^2)
 */
public class MinCutForPalindrome {

    static boolean[][] P;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        processPalin(s);
        int cut = solve_n3(s);
        System.out.println("cut O(n3) = " + cut);
        cut = solve_n2(s);
        System.out.println("cut O(n2)= " + cut);
    }
    static void processPalin(String s) {
        int n = s.length();
        P = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            P[i][i] = true;
        }
        for (int l = 2; l <= n; l++) {
            for (int i = 0; i+l <= n ; i++) {
                int j = i + l - 1;
                if(l == 2) P[i][j] = s.charAt(i) == s.charAt(j);
                else {
                    P[i][j] = s.charAt(i) == s.charAt(j) && P[i+1][j-1];
                }
            }
        }
    }

    static int solve_n3(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int[] ar: dp) Arrays.fill(ar, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j+i <= n; j++) {
                int s_i = j;
                int e_i = j+i-1;
                if(P[s_i][e_i]) dp[s_i][e_i] = 0;
                else {
                    for (int k = s_i; k < e_i; k++) {
                        dp[s_i][e_i] = Math.min(dp[s_i][e_i], 1 + dp[s_i][k] + dp[k + 1][e_i]);
                    }
                }
            }
        }
        return dp[0][n-1];
    }
    static int solve_n2(String s) {
        int n = s.length();
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
            if (P[0][i]) {
                dp[i] = 0;
            } else {
                for (int j = 0; j < i; j++) {
                    if (P[j + 1][i] && 1 + dp[j] < dp[i]) {
                        dp[i] = dp[j] + 1;
                    }
                }
            }
        }
        return dp[n-1];
    }
}
