package algorithms;

/**
 * Created by vinaysaini on 5/31/16.
 */


import java.util.Scanner;

/***
 *  DP
 *  Given a wild card pattern p = a*?b & a string s find whether they match or not
 *  Complexity : l1 x l2 assuming l1 = length(p) & l2 = length(s)
 */

public class WildCardMatchingDP {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String pattern = in.nextLine();

        for (int i = 0; i < 10; i++) {
            String str = in.nextLine();

            System.out.println(match(pattern, str) ? "Matched" : "Not Matched");
        }

    }

    static boolean match(String p, String s) {
        int l1 = p.length();
        int l2 = s.length();
        boolean[][] dp = new boolean[l1][l2];
        for (int i = 0; i < l2; i++) {
            if(p.charAt(0) == '?' || p.charAt(0) == s.charAt(i)) dp[0][i] = i == 0? true: false;
            else if(p.charAt(0) == '*') dp[0][i] = true;
            else {
                dp[0][i] = false;
            }
        }
        for (int i = 1; i < l1; i++) {
            if(i == 1) {
                if (p.charAt(0) == '*') dp[i][0] = p.charAt(i) == s.charAt(0);
                else if (p.charAt(i) == '*' && p.charAt(0) == s.charAt(0)) dp[i][0] = true;
            }
        }
        for (int i = 1; i < l1; i++) {
            for (int j = 1; j < l2; j++) {
                if (p.charAt(i) == '?' || p.charAt(i) == s.charAt(j)) dp[i][j] = dp[i-1][j-1];
                else if(p.charAt(i) == '*') dp[i][j] = dp[i-1][j] | dp[i][j-1];
                else dp[i][j] = false;
            }
        }
        return dp[l1-1][l2-1];
    }
}
