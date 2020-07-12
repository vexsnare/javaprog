package commons;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author vinay.saini
 * @created 13/05/2020 - 1:10 AM
 */
public class Sieve {

    // n log (log (n) )
    public static ArrayList<Integer> generateAllPrimes(int n) {
        ArrayList<Integer> primes = new ArrayList<>();
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 0; i*i < n; i++) {
            if(isPrime[i]) {
                for(int j = i*i; j < n; j+=i) {
                  isPrime[j] = false;
                }
            }
        }
        for(int i = 0; i < n; i++) {
            if(isPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }
}
