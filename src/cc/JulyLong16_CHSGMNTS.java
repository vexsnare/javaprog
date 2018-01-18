package cc;

import java.io.*;
import java.util.*;

/**
 * Created by vinaysaini on 7/2/16.
 */
class JulyLong16_CHSGMNTS {
    public static void main(String[] args) {
        int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            int n = in.nextInt();
            int[] ar = new int[n];
            for (int i = 0; i < n; i++) {
                ar[i] = in.nextInt();
            }
            int[][] R = new int[n][n];
            for (int i = 0; i < n; i++) {
                int rep = 0;
                for (int j = n-1; j > i; j--) {
                    if(ar[j] == ar[i]) rep++;
                    R[i][j] = rep;
                }
            }
            long ans = 0;
            for (int i = 0; i < n; i++) {
                Set<Integer> set = new HashSet<Integer>();
                for (int j = i; j < n; j++) {
                    int k = j+1;
                    long count = 0;
                    while (k < n) {
                        if(set.contains(ar[k])) {
                            ans += (count*(count+1))/2;
                            count = 0;
                        } else {
                            count++;
                        }
                        k++;
                    }
                    ans += (count*(count+1))/2;
                }
                set.clear();
            }
            out.println(ans);
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
    static int log2floor(int x) {
        return 31 - Integer.numberOfLeadingZeros(x);
    }
}
