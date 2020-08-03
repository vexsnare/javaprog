package commons;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by vinaysaini on 6/7/16.
 */
public class _001_im {

    /**
     * 4 direction
     */
    int[] d4x = {0, -1, 0, 1};
    int[] d4y = {1, 0, -1, 0};

    /**
     * 8 Directions
     */

    int[] d8x = {0, 0, 0, 1, 1, 1, -1, -1, -1};
    int[] d8y = {0, 1, -1, 0, 1, -1, 0, 1, -1};
    /**
     *  (x^(-1))%mod = x^(mod-2)%mod
     *  Where mod is a Prime (commonly given as 1e7+9)
     */
    static long inverseEuler(int n, int mod) {
        return pow(n, mod-2, mod);
    }

    /**
     * Calculate power exponentially
     */
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

    /**
     * Calculate FCD for given two numbers
     */
    static long gcd(long x, long y) {
        if(x == 0) return y;
        return gcd(y%x, x);
    }

    /**
     * Log base 2 value
     */
    static int log2floor(int x) {
        return 31 - Integer.numberOfLeadingZeros(x);
    }

    /**
     * Collection array or list to int[]
     */
    Set<Integer> list =  new HashSet<>(Arrays.asList(2,3,4));
    int[] ar = list.stream().mapToInt(Integer::intValue).toArray();
    Integer[] ar2 = list.toArray(new Integer[0]);
    /**
     *
     * */
     int[] ar1 = {1,2,2,1};
     List<Integer> arrayTolist = Arrays.stream(ar1).boxed().collect(Collectors.toList());
     /**
     * ################### Fast I/O
     **/

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
