package cc;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by vinaysaini on 5/7/16.
 */
class MayLong16C_ForestGathering {
    private static Pair[] trees;
    private static long l;
    private static long w;

    public static void main(String[] args) {
        int n = in.nextInt();
        w = in.nextLong();
        l = in.nextLong();
        trees = new Pair[n];
        for (int i = 0; i < n; i++) {
            trees[i] = new Pair(in.nextInt(), in.nextInt());
        }
        Arrays.sort(trees);
        long lo = 0;
        long hi = (long)Double.MAX_VALUE;
        while (lo <= hi) {
            long mid = (lo + hi) / 2;
            long food = getFood(mid);
            if (food < w) lo = mid + 1;
            else hi = mid - 1;
        }
        out.println(lo);
        out.close();
    }

    static long getFood(long month) {
        long food = 0;
        for (int i = 0; i < trees.length; i++) {
            int height = trees[i].x;
            long rate = (long)trees[i].y;
            long cur_length = height + rate * month;
            food += cur_length >= l ? cur_length : 0;
            if(food > w) break;
        }
        return food;
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

    static class Pair implements Comparable<Pair>{
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Pair o) {
            return  this.x - o.x;
        }
        public String toString() {
            return "{"+this.x+","+this.y+"}";
        }
    }
}
