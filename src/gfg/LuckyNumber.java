package gfg; /**
 * Created by vinaysaini on 7/8/16.
 */

import java.util.Scanner;

/**
 * http://www.geeksforgeeks.org/lucky-numbers/
 */
public class LuckyNumber {
    static int d = 2;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(isLucky(n) ? "Yes": "No");
    }
    static boolean isLucky(int n) {
        int currentPosition = n;
        if(d > currentPosition) return true;
        else if(currentPosition%d == 0) return false;
        else {
            currentPosition = currentPosition - currentPosition/d;
            d++;
            return  isLucky(currentPosition);
        }
    }
}
