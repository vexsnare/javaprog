package cc;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by vinaysaini on 6/3/16.
 */
class JuneLong16_ADEVARRAY {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N, Q;
        N = in.nextInt();
        Q = in.nextInt();
        int[] ar = new int[N];
        for (int i = 0; i < N; i++) {
            ar[i] = in.nextInt();
        }
        Arrays.sort(ar);
        for (int q = 0; q < Q; q++) {
            int t = in.nextInt();
            System.out.println( ar[0] <= t && t <= ar[N-1] ? "Yes": "No");
        }
    }
}
