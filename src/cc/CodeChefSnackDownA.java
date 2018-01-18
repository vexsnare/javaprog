package cc;

import java.util.Scanner;

/**
 * Created by vinaysaini on 5/30/16.
 */
class CodeChefSnackDownA {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            int n = in.nextInt();
            int[] A = new int[n];
            int[] B = new int[n];
            for (int i = 0; i < n; i++) {
                A[i] = in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                B[i] = in.nextInt();
            }

            int count = 0;
            int start_t = 0;
            for (int i = 0; i < n; i++) {
                int av_time = A[i]- start_t;
                if(av_time >= B[i]) count++;
                start_t = A[i];
            }
            System.out.println(count);
        }
    }
}
