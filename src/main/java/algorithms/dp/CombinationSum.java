package algorithms.dp;
import java.util.Arrays;

/**
 * @author vinay.saini
 * @created 10/09/2020 - 11:46 AM
 * Errichto
 * https://www.youtube.com/watch?v=1mtvm2ubHCY&t=789s&ab_channel=Errichto
 */

public class CombinationSum {
    /*
     * 1 2 1 & 1 1 2 are separate (combination) order does matter
     */
    private int findWays(int sum, int[] ar) {
        // sum & number of ways
        int dp[] = new int[sum+1];
        dp[0] = 1;
        for (int i = 1; i <= sum; i++) {
            for(int j = 0; j < ar.length; j++) {
                if(ar[j] <= i) {
                    dp[i] += dp[i - ar[j]];
                    //dp[i+ar[j]] += dp[i];
                }
            }
        }
        return dp[sum];
    }

    /*
     * 1 2 1 & 1 1 2 are same (permutation) order doesn't matter
     * O(sum*n*n) -> O(sum*n) below code for optimization
     */
    private int findUniqueWays(int sum, int[] ar) {
        // sum & last number in seq: value- number of way
        int dp[][] = new int[sum+1][ar.length];
        for (int i = 0; i <= sum; i++) {
            for(int j = 0; j < ar.length; j++) {
                if(i < ar[j]) continue;
                if(i == ar[j]) {
                    dp[i][j] = 1;
                    continue;
                }
                for (int k = 0; k < ar.length; k++) {
                    if(ar[k] < ar[j] || (ar[k]==ar[j] && k >= j)) {
                        dp[i][j] += dp[i-ar[j]][k];
                    }
                }
            }
        }
        int ans = Arrays.stream(dp[sum]).reduce(0, (x,y) -> x + y);
        return ans;
    }

    /*
     * 1 2 1 & 1 1 2 are same (permutation) order doesn't matter
     * Optimization on state
     * O(sum*n)
     */
    private int findUniqueWays2(int sum, int[] ar) {
        // [sum][upto first n number] | value: number of ways
        int dp[][] = new int[sum+1][ar.length];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i <= sum; i++) {
           for(int j = 0; j < ar.length; j++) {
               if(j - 1 >= 0) dp[i][j] += dp[i][j-1];
               if(ar[j] <= i) dp[i][j] += dp[i-ar[j]][j];
            }
        }
        return dp[sum][ar.length-1];
    }

    // Push DP
    private int findUniqueWays3(int sum, int[] ar) {
        // [sum][upto first n number] | value: number of ways
        int dp[][] = new int[sum+1][ar.length];
        //Arrays.fill(dp[0], 1);
        dp[0][0] = 1;
        for (int i = 0; i <= sum; i++) {
            for(int j = 0; j < ar.length; j++) {
                if(j + 1 < ar.length) dp[i][j+1] += dp[i][j];
                if(ar[j]+i <= sum) dp[i+ar[j]][j] += dp[i][j];
            }
        }
        return dp[sum][ar.length-1];
    }




    public static void main(String[] args) {
        CombinationSum combinationSum  = new CombinationSum();
        System.out.println(combinationSum.findWays(10, new int[]{1,2,3}));
        System.out.println(combinationSum.findUniqueWays(100, new int[]{2,1,3,3,4,5}));
        System.out.println(combinationSum.findUniqueWays2(100, new int[]{2,1,3,3,4,5}));
        System.out.println(combinationSum.findUniqueWays3(100, new int[]{2,1,3,3,4,5}));
    }
}
