package algorithms.errichto;

import helpers.Printer;

import java.util.Arrays;

/**
 * @author vinay.saini
 * @created 10/09/2020 - 6:12 PM
 * https://www.youtube.com/watch?v=pwpOC1dph6U&t=20s&ab_channel=Errichto
 */
public class WineSellPerYear {

    /*
     * Dp[i][j] = Max profit in range [i,j]
     */
    private int maxProfit1(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][n];
        for(int i = n-1; i >=0 ; i--) {
            for (int j = i; j < n; j++) {
                if(j == i) dp[i][j] = n*prices[i];
                else {
                    int year = n - (j-i);
                    dp[i][j] = Math.max(year*prices[i] + dp[i+1][j], year*prices[j] + dp[i][j-1]);
                }
            }
        }
        return dp[0][n-1];
    }

    /*
     * dp[i][j] - contains max profit before we reach [i,j]
     */
    private int maxProfit2(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[0][n-1] = 0;
        for(int i = 0; i < n; i++) {
            for (int j = n-1; j > i; j--) {
                int y = n - (j-i);
                dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j]+ y*prices[i]);
                dp[i][j-1] = Math.max(dp[i][j-1], dp[i][j]+ y*prices[j]);
            }
        }
        int ans = -1;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i][i] + n*prices[i]);
        }
        return ans;
    }

    /*
     * Assuming there are nothing other than i,j range. f(i,j) - Stores answer from year 1
     * f(i,j) = Max(1*p[i] + f(i+1, j), 1*p[i] + f(i+1, j))
     */
    private int maxProfit3(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n][n];

        int prefix[] = new int[n];
        prefix[0] = prices[0];
        for (int i = 1; i < n; i++) prefix[i] = prefix[i-1] + prices[i];

        for (int i = 0; i < n; i++) dp[i][i] = prices[i];
        for (int i = n-1; i >= 0; i--) {
            for (int j = i+1; j < n; j++) {
                //dp[i][j] = Math.max(dp[i+1][j] + prefix[j]-prefix[i-1], dp[i][j-1] + prefix[j]-prefix[i-1]);
                dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]) + (i-1>= 0 ? prefix[j]-prefix[i-1]: prefix[j]);
            }
        }
        return dp[0][n-1];
    }

    public static void main(String[] args) {
        WineSellPerYear ws = new WineSellPerYear();
        System.out.println(ws.maxProfit1(new int[]{2,4,6,2,5}));
        System.out.println(ws.maxProfit2(new int[]{2,4,6,2,5}));
        System.out.println(ws.maxProfit3(new int[]{2,4,6,2,5}));
    }
}
