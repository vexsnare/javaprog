package utils;

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
    int[] dx = {0, -1, 0, 1};
    int[] dy = {1, 0, -1, 0};

    /**
     * 8 Directions
     */

    int[] d8x = {0, 0, 0, 1, 1, 1, -1, -1, -1};
    int[] d8y = {0, 1, -1, 0, 1, -1, 0, 1, -1};
    /**
     * Euler's theorem
     * (1/x)%MOD = ((1/x)^(phi of mod) - 2)%mod
     * phi is number of co-primes with mod from [1, mod)
     * if mod is prime (1/x)%mod = ((1/x)^mod-2)%mod
     */
    static int divide (int a, int b, int mod) {
        return (int)((a%mod) * (long)(Math.pow(b, mod - 2)))%mod;
    }
    /**
     * Implement LRU using LinkedHashMap which maintains order or element
     */
    int capacity = 100;
    LinkedHashMap<String, String> lm = new LinkedHashMap<String, String>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry eldest)
            {
                return size() > capacity;
            }
        };
    /**
     * Initialize Map of List
     */
    static void initialize() {
        Map<Integer, List<Integer>> m = new HashMap<>();
        m.computeIfAbsent(1, x -> new ArrayList<>()).add(3);
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
        return x == 0 ? y : gcd(y%x, x);
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
    double[] ar3 = list.stream().mapToDouble(Integer::doubleValue).toArray();
    Integer[] ar2 = list.toArray(new Integer[0]);
    /**
     *
     * */
     int[] ar1 = {1,2,2,1};
     List<Integer> arrayTolist = Arrays.stream(ar1).boxed().collect(Collectors.toList());
     String[] arS = {"Abc", "bcd"};
     List<String> stringList = Arrays.stream(arS).collect(Collectors.toList());
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
