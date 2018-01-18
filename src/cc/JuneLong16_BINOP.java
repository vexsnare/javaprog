package cc;

import java.util.Scanner;

/**
 * Created by vinaysaini on 6/4/16.
 */
class JuneLong16_BINOP {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            String A = in.next();
            String B = in.next();
            solve(A, B);
        }
    }
    static void solve(String A, String B) {
        if (A.length() != B.length()) {
            System.out.println("Unlucky Chef");
        } else {
            int diffZeros = getDiffCountByChar(A, B, '0');
            int diffOnes = getDiffCountByChar(A, B, '1');
            if (getCountByChar(A, '1') == A.length() && diffOnes > 0 || getCountByChar(A, '0') == A.length() && diffZeros > 0) {
                System.out.println("Unlucky Chef");
            } else {
                System.out.println("Lucky Chef");
                int max = Math.max(diffOnes, diffZeros);
//                int min = Math.min(diffOnes, diffZeros);
//                int steps = max - min + min;
                System.out.println(max);
            }
        }
        
    }
    static int getDiffCountByChar(String A, String B, char c) {
        int diff = 0;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i) && A.charAt(i) == c) diff++;
        }
        return diff;
    }
    static int getCountByChar(String A, char c) {
        int diff = 0;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == c) diff++;
        }
        return diff;
    }
}
