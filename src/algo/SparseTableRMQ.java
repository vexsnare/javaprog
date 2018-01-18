package algo;

import java.util.Scanner;

/**
 * Created by vinaysaini on 6/9/16.
 */
public class SparseTableRMQ {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = in.nextInt();
        }
        
        // creating sparse table
        int m = log2floor(n) + 1;
        int[][] T = new int[n][m];
        for (int j = 0; j < m; j++) {
            for (int i = 0; i + (1<<j) <= n; i++) {
                if(j == 0) T[i][j] = i;
                else {
                    int li = T[i][j-1];
                    int ri = T[i+ (1<<(j-1))][j-1];
                    if(ar[li] < ar[ri]) {
                        T[i][j] = li;
                    } else T[i][j] = ri;
                }
            }
        }
        
        int Q = in.nextInt();
        for (int q = 0; q < Q; q++) {
            int i = in.nextInt() - 1;
            int j = in.nextInt() - 1;
            int l = j-i+1;
            int k = log2floor(l);
            int ans = ar[T[i][k]];
            if((1<<k) < l) {
                ans = Math.min(ans, ar[T[i+l - (1<<k)][k]]);
            }
            System.out.println(ans);
        }
        
    }
    static int log2floor(int x) {
        return 31 - Integer.numberOfLeadingZeros(x);
    }
}
