package cc;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by vinaysaini on 6/4/16.
 */
class JuneLong16_CHCOINSG {
//    static int max = (int)1000;
    public static void main(String[] args) {
        int T = in.nextInt();
//        ArrayList<Integer> p = generatePrimes(max);
//        System.out.println(p.get(p.size()-1));
//
//        boolean[] win = new boolean[max];
//        for (int i = 1; i < max; i++) {
//            win[i] |= win[i-1] == false;
//            for (int j = 0; j < p.size(); j++) {
//                int x = p.get(j);
//                while(x <= i) {
//                    win[i] |= win[i-x] == false;
//                    x *= x;
//                }
//            }
//        }
//        for (int i = 0; i < max; i++) {
//            if (win[i] == false) System.out.println(i);
//        }

        for (int t = 0; t < T; t++) {
            int n = in.nextInt();
            if(n%6 == 0) out.println("Misha");
            else out.println("Chef");
        }
        out.close();
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
