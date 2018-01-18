package cc;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by vinaysaini on 6/3/16.
 */
class JuneLong16_CHEFARK {
    private static int mod = 1000000007;
    public static void main(String[] args) {
       int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            int N = in.nextInt();
            int K = in.nextInt();
            int zeros = 0;
            for (int i = 0; i < N; i++) {
                int x = in.nextInt();
                if(x == 0) zeros++;
            }
            int ans = getCount(N-zeros,K, zeros > 0);
            out.println(ans);
        }
        out.close();
    }
    static int getCount(int N, int K, boolean areThereZeros) {
        int[] nCr = new int[K+1];
        nCr[0] = 1;
        for (int i = 1; i < K+1; i++) {
            long x = nCr[i-1];
            x = ((x*(N-i+1))%mod)*(inverseEuler(i));
            nCr[i] = (int)(x%mod);
        }
//        for (int i = 0; i < K+1; i++) {
//            System.out.print(nCr[i]+ " ");
//        }
//        System.out.println();
        long ans = 0;
        if(areThereZeros) {
            for (int i = 0; i <= K && i <= N ; i++) {
                ans += nCr[i];
                ans %= mod;
            }
        } else {
            if (K % 2 == 0) {
                for (int i = 0; i <= K && i <= N; i += 2) {
                    ans += nCr[i];
                    ans %= mod;
                }
            } else {
                for (int i = 1; i <= K && i <= N; i += 2) {
                    ans += nCr[i];
                    ans %= mod;
                }
            }
        }
        return (int)ans;
    }
    public static long gcd(long x, long y) {
        if(x == 0) return y;
        return gcd(y%x, x);
    }
    static long inverseEuler(int n) {
        return pow(n, mod-2);
    }
    static long pow(int a,int b) {
        if (b == 0) return 1;
        else {
            long x = pow(a, b/2);
            x = (x * x)%mod;
            if(b % 2 != 0) {
                x = (x * a)%mod;
            }
            return x;
        }
    }
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    public static FastScanner in = new FastScanner();

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
