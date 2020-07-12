package leetcode;

import java.util.Scanner;

/**
 * Created by vinaysaini on 10/5/16.
 */
public class ValidPerfectSquare {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(isPerfectSquare(n));

    }
    public static boolean isPerfectSquare(int n) {
        int l = 0;
        int r = n;
        while (l < r) {
            int m = (l + r)/2;
            int sqr = m*m;
            if(sqr < n) {
                l = m+1;
            } else {
                r = m;
            }
        }
        return l*l == n;
    }
}
