package adhoc;

/**
 * @author vinay.saini
 * @created 19/08/2020 - 8:14 PM
 */
public class TwoSum {

    static int[] ar = {1, 2, 3, 4, 5,6,7,8};

    private static int solve(int t, int j) {
        if(t == 0) {
            return 1;
        }
        if(j < 0) {
            return -1;
        }
        int ans = 0;
        int count = solve(t, j-1);
        if(count != -1) {
            ans += count;
        }
        count = solve(t - ar[j], j-1);;
        if(count != -1) {
            ans += count;
        }
        return ans;
    }

    public static void main(String[] args) {

        int target = 20;

        int n = ar.length;
//        int[][] dp = new int[target][ar.length];
//        dp[1][0] = 1;
//        for (int i = 0; i < target; i++) {
//
//        }
//
//        k -> (0, j)
//        f(i, j) = Sigma f(i - ar[k], k-1)
        int result = solve(7, ar.length - 1);
        System.out.println(result);
    }
}
