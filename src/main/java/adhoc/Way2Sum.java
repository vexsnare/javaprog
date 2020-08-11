package adhoc;

import helpers.Printer;

/**
 * @author vinay.saini
 * @created 05/08/2020 - 10:59 PM
 */
public class Way2Sum {

    static int memo[][] = new int[100][100];

    public static int solve(int total, int k) {
        int ans = 0;
        if(total < 0) return 0;
        if(total == 0) return 1;
        if(memo[total][k] > 0) return memo[total][k];
        for (int i = 1; i <= k; i++) {
            ans += solve(total - i, i);
        }
        memo[total][k] = ans;
        return memo[total][k];
    }

    public static int ways(int total, int K) {
        int[] dp = new int[total + 1];
        dp[0] = 1;

        for(int i = 1; i <= K; i++) {
            for(int j = i; j <= total; j++) {
                    dp[j] += dp[j-i];
            }
        }
        Printer.print(dp);
        return dp[total];
    }

    public static void main(String[] args) {

        System.out.println(ways(15, 3));
        System.out.println(solve(15, 3));

    }
}