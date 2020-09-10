package leetcode;

/**
 * @author vinay.saini
 * @created 30/08/2020 - 5:44 PM
 */
public class RestoreArray {
    int mod = 1000000000 + 7;

    int solve(String s, int k) {
        int n = s.length();
        if(n <= 0) return 0;
        int[] dp = new int[n];
        dp[0] = 1;
        //1234
        for (int i = 1; i < n; i++) {
            if(s.charAt(i) != '0') dp[i] = dp[i-1];
            long multi = 1;
            long num = s.charAt(i)-'0';
            for (int j = i-1; j >= 0; j--) {
                multi *= 10;
                if(s.charAt(j) == '0') continue;
                num += (s.charAt(j)-'0')*multi;
                if(num > k) break;
                if(j == 0) dp[i] += 1;
                else dp[i] = (int) (((long)dp[j - 1] + dp[i]) % mod);
            }
        }
        return dp[n-1];
    }
    public static void main(String[] args) {
        RestoreArray numberOfArrays = new RestoreArray();
        System.out.println(numberOfArrays.solve("600342244431311113256628376226052681059918526204",703));
    }
}
