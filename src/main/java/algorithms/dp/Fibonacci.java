package algorithms.dp;

import java.util.Arrays;

/**
 * @author vinay.saini
 * Errichto
 * @created 10/09/2020 - 9:36 AM
 */
public class Fibonacci {
    final int max = (int)10e6;
    public int[] dp = new int[max];

    // Memorization
    private int fibo(int n) {
        if(n <= 1) return n;
        if(dp[n] != -1) return dp[n];
        dp[n] = fibo(n-1) + fibo(n-2);
        return dp[n];
    }

    // pull based DP
    private int dp1(int n) {
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n+1; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    // Push based DP
    private int dp2(int n) {
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 0; i < n; i++) {
            if(i+1 < n+1) dp[i+1] += dp[i];
            if(i+2 < n+1) dp[i+2] += dp[i];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        long t1 = System.currentTimeMillis();
        Arrays.fill(fibonacci.dp, -1);
        System.out.println(fibonacci.fibo(25));
        long t2 = System.currentTimeMillis();
        System.out.println("T1: " + (t2-t1));

        Arrays.fill(fibonacci.dp, 0);
        t2 = System.currentTimeMillis();
        System.out.println(fibonacci.dp1(25));
        long t3 = System.currentTimeMillis();
        System.out.println("T2: " + (t3-t2));

        Arrays.fill(fibonacci.dp, 0);
        t3 = System.currentTimeMillis();
        System.out.println(fibonacci.dp2(25));
        long t4 = System.currentTimeMillis();
        System.out.println("T3: " + (t4-t3));
    }
}
