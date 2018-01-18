package algo;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by vinaysaini on 6/7/16.
 */
public class _001_im {
    public static void main(String[] args) {

            String s = Integer.toString(1213);
            System.out.println(s.charAt(0) > s.charAt(1));


    }


    int[] dx = {0, -1, 0, 1};
    int[] dy = {1, 0, -1, 0};
    /**
     *  (x^(-1))%mod = x^(mod-2)%mod
     *  Where mod is a Prime (commonly given as 1e7+9)
     */
    static long inverseEuler(int n, int mod) {
        return pow(n, mod-2, mod);
    }
    static long pow(int a,int b, int mod) {
        if (b == 0) return 1;
        else {
            long x = pow(a, b/2, mod);
            x = (x * x)%mod;
            if(b % 2 != 0) {
                x = (x * a)%mod;
            }
            return x;
        }
    }
    static long gcd(long x, long y) {
        if(x == 0) return y;
        return gcd(y%x, x);
    }
    static int log2floor(int x) {
        return 31 - Integer.numberOfLeadingZeros(x);
    }

    static class Pair {
        int x;
        int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static ArrayList<Integer> generatePrimes(int max) {
        boolean[] ar = new boolean[max];
        Arrays.fill(ar, true);
        ar[0] = ar[1] = false;
        for(int i = 0; i <= Math.sqrt(max); i++) {
            if(ar[i] == true) {
                for (int j = i * i; j < max; j += i) {
                    ar[j] = false;
                }
            }
        }
        ArrayList<Integer> primes = new ArrayList<Integer>();
        for (int i = 0; i < max; i++) {
            if(ar[i]) primes.add(i);
        }
        return primes;
    }





    /**
     * ################### Fast I/O
     */

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
