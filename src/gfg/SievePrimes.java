package gfg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by vinaysaini on 5/3/16.
 */
public class SievePrimes {
    static List<Integer> primes;
    public static final int MAX = (int)1e6;
    public static void main(String[] args) {
        primes = generatePrimes(MAX);
        for ( int p: primes ) {
            System.out.println(p);
        }
        System.out.println("Total primes = " + primes.size());

    }
    static ArrayList<Integer> generatePrimes(int max) {
        boolean[] ar = new boolean[max];
        Arrays.fill(ar, true);
        ar[0] = ar[1] = false;
        for(int i = 0; i <= Math.sqrt(max); i++) {
            if(ar[i] == true) {
                for (int j = i * i; j < max; j += i) {
                    ar[j] = false;
                }
            }
        }
        ArrayList<Integer> primes = new ArrayList<Integer>();
        for (int i = 0; i < max; i++) {
            if(ar[i]) primes.add(i);
        }
        return primes;
    }

}
