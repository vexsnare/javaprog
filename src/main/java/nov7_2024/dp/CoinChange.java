package nov7_2024.dp;

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
    public int findMinCoins(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if(i - coins[j] >= 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.findMinCoins(10, new int[]{1, 2,10}));
    }
}
