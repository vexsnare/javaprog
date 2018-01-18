package algo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by vinaysaini on 7/8/16.
 */

/**
 * Minimum insertion needed to make a given string Palindrome
 */
public class MinInsertionForPalin {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        for (int i = 0; i < max; i++) {
            Arrays.fill(memo[i], -1);
        }
        System.out.println(solve(s.toCharArray(), 0, s.length()-1));
    }
    static final int max = 1001;
    static int[][] memo = new int[max][max];
    static int solve(char[] ar, int lo, int hi) {
        if(lo > hi) return Integer.MAX_VALUE;
        if(lo == hi) return 0;
        if(hi - lo == 1) return ar[lo] == ar[hi] ? 0 : 1;
        if(memo[lo][hi] != -1) return memo[lo][hi];
        int ans = 0;
        if(ar[lo] == ar[hi]) ans = solve(ar, lo+1, hi-1);
        else {
            ans = Math.min(solve(ar, lo+1, hi), solve(ar, lo, hi-1)) + 1;
        }
        memo[lo][hi] = ans;
        return ans;
    }
}
