package cc;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by vinaysaini on 6/4/16.
 */
class JuneLong16_CHEARMY {
            ;
    public static void main(String[] args) {
        int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            long k = in.nextLong() - 1;
            String numberInBase5 = Long.toString(k, 5);
            char[] digitsArray = numberInBase5.toCharArray();
            for (int i = 0; i < digitsArray.length; i++) {
                out.print((char)((digitsArray[i]-'0')*2 + '0'));
            }
            out.println();
        }
        out.close();
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
