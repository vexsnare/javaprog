package algorithms.dp;

import java.util.Arrays;

/**
 * @author vinay.saini
 * @created 10/09/2020 - 1:46 PM
 * https://leetcode.com/problems/coin-change/description/
 */
/*
https://www.youtube.com/watch?v=1mtvm2ubHCY&t=789s&ab_channel=Errichto
 */
public class CoinChange {
    public int findMinCoins(int sum, int[] ar) {
        int[] dp = new int[sum+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i <= sum; i++) {
            for (int j = 0; j < ar.length; j++) {
                if(i+ar[j] <= sum)
                    dp[i+ar[j]] = Math.min(dp[i+ar[j]], 1 + dp[i]);
            }
        }
        return dp[sum];
    }


    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.findMinCoins(10, new int[]{1, 2,10}));
    }
}
