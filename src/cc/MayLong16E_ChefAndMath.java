package cc;

import java.io.PrintWriter;
import java.io.*;
import java.util.*;

/**
 * Created by vinaysaini on 5/7/16.
 */
class MayLong16E_ChefAndMath {

    private static final int MAX = 43;
    private static final int MOD = (int) 1e9 + 7;
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    public static FastScanner in = new FastScanner();
    static int[] fib = new int[MAX];

    public static void main(String[] args) {
        int Q = in.nextInt();
        fib[0] = 1;
        fib[1] = 2;
        for (int i = 2; i < MAX; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        for (int q = 0; q < Q; q++) {
            int n = in.nextInt();
            int k = in.nextInt();
            int ind;
            for (ind = 0; ind < MAX; ind++) {
                if (fib[ind] > n) break;
            }
            System.out.println(solve(n, k, ind-1));
        }
    }

    static long solve(int n, int k, int i) {
        if (k == 0 && n == 0) {
            return 1;
        }
        if (k == 0) return 0;
        if (n == 0) return 0;
        if (i < 0) return 0;
        long ans = solve(n, k, i - 1);
        if(n >= fib[i] && n <= (long)k*fib[i])
            ans += solve(n - fib[i], k - 1, i);
        ans = ans % MOD;
        return ans;
    }

    public static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

}
