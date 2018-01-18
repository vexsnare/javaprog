package cc;

import java.util.Scanner;

/**
 * Created by vinaysaini on 5/7/16.
 */
class MayLong16B_ChefAndBall {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(1);
        System.out.println("4 1 3 4 4");
        System.out.println("4 2 3 5 5");
        int w = in.nextInt();
        int ans;
        switch (w) {
            case -1: ans = 2;
                break;
            case 1: ans = 1;
                break;
            case -2: ans = 5;
                break;
            case 2: ans = 4;
                break;
            default: ans = 3;
                break;
        }
        System.out.println("2\n"+ans);
        in.close();
    }
}
