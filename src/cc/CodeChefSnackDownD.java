package cc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

/**
 * Created by vinaysaini on 5/31/16.
 */
class CodeChefSnackDownD {
    private static HashMap<Long, Integer> map = new LinkedHashMap<Long, Integer>();
    public static void main(String[] args)  {
        int T = in.nextInt();
        prep();
        System.out.println();
        for (int t = 0; t < T; t++) {
            int n = in.nextInt();
            long xor = 0;
            for (int i = 0; i < n; i++) {
                long x = in.nextLong();
            //    System.out.println("x = " + findGr(x));
                xor ^= findGr(x);
            }
            if (xor == 0) {
                System.out.println("Derek");
            } else {
                System.out.println("Henry");
            }
        }
    }


    static int findGr(long n) {
        int[] t = {0,1,2,2,3,3,0};
        if(n < 6) return t[(int)n];
        for(long x: map.keySet()) {
            if(n < x) return map.get(x);
            else if(n == x) return (map.get(x)+1)%4;
        }
        return 0;
    }

    static void prep() {
        int gr = 0;
        long k = 6;
        while (k < 1e18) {

            if(gr == 0 || gr == 1 || gr == 2) {
                k = k*2;
                map.put(k, gr);
            }
            else if(gr == 3) {
                k = k + k/2;
                map.put(k, gr);
            }
            gr++;
            gr = gr%4;
        }
    }

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
