package gfg;

import java.util.Scanner;

/**
 * Created by vinaysaini on 5/1/16.
 */
public class Gcd {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();

        System.out.println(gcd(x,y));
    }

    static int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x%y);
    }
}

