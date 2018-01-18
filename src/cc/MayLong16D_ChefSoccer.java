package cc;

import java.util.Scanner;

/**
 * Created by vinaysaini on 5/7/16.
 * Problem code: CHEFSOC2
 */
class MayLong16D_ChefSoccer {

    static int[] dogs;
    static int[] strengths;
    static int[] ans;
    static int s;
    static int max = 1001;
    static int memo[][] = new int[max][max];
    private static final int MOD = (int)1e9+7;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            int N = in.nextInt();
            int M = in.nextInt();
            s = in.nextInt();
            dogs = new int[N];
            strengths = new int[M];
            for (int i = 0; i < M; i++) {
                strengths[i] = in.nextInt();
            }
            for (int i = 0; i < max; i++) {
                for (int j = 0; j < max; j++) {
                    memo[i][j] = -1;
                }
            }
            ans = new int[N];
            for (int i = 0; i < N; i++) {
                ans[i] = kick(i, M - 1);
            }
            for (int i = 0; i < N; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
    static int kick(int i, int cur_strengh) {
        if(!inRange(i)) return 0;
        if(cur_strengh == -1 && i == s-1) {
            return 1;
        }
        if(cur_strengh == -1) return 0;
        if(memo[i][cur_strengh] != -1) return memo[i][cur_strengh];
        int x = strengths[cur_strengh];
        long ans = kick(i-x, cur_strengh-1);
        ans += kick(i+x, cur_strengh-1);
        ans %= MOD;
        return memo[i][cur_strengh] = (int)ans;
    }
    static boolean inRange(int i) {
        return i >= 0 && i < dogs.length;
    }
}