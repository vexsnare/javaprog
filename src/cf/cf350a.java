package cf;

import java.util.Scanner;

/**
 * Created by vinaysaini on 5/5/16.
 */
public class cf350a {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int min = (n/7)*2;
        int max = min;
        int rem = n%7;
        if(rem > 0) {
            max += rem == 1 ? 1 : 2;
            min += rem == 6 ? 1 : 0;
        }
        System.out.println(min + " " + max);

    }
}
