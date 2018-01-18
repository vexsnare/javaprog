package cc;

import java.util.Scanner;

/**
 * Created by vinaysaini on 5/31/16.
 */
class CodeChefSnackDownB {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            int n = in.nextInt();
            int[] ar = new int[n];
            for (int i = 0; i < n; i++) {
                ar[i] = in.nextInt();
            }
            long [] L = new long[n];
            long [] R = new long[n];
            long current_sum = 0;
            for (int i = 0; i < n; i++) {
                current_sum += ar[i];
                L[i] = current_sum;
                if(current_sum < 0) {
                    current_sum = 0;
                }

            }
            current_sum = 0;
            for (int i = 0; i < n; i++) {
                current_sum += ar[n-i-1];
                R[n-i-1] = current_sum;
                if(current_sum < 0) {
                    current_sum = 0;
                }

            }
            long ans = Long.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                long sum = 0;
                if(i-1 >= 0) sum += L[i-1];
                if(i+1 < n) sum += R[i+1];
                if(sum > ans) ans = sum;
                ans = Math.max(ans, L[i]+ (i+1<n ? R[i+1]: 0));
            }
            for (int i = 0; i < n; i++) {
                ans = Math.max(ans, ar[i]);
            }
            System.out.println(ans);
        }
    }
}
