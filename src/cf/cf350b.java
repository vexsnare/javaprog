package cf;

import java.util.Scanner;

/**
 * Created by vinaysaini on 5/5/16.
 */
public class cf350b {

    static  int count = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = in.nextInt();
        }
        int i;
        for (i = 1; i < 1000000; i++) {
            long sum = ((long) i* (i+1))/2;
            if(sum > k) break;
        }
        System.out.println(ar[i-2]);

    }
//    static int search(int i, int j, int k) {
//        int m = (i+j)/2;
//        long sum = ((long)m * (m+1)) / 2;
//        count++;
//        if(count > 100) {
//            return i;
//        }
//        if(sum > k) {
//            return search(i, m-1, k);
//        } else {
//            return search(m, j, k);
//        }
//    }
}
