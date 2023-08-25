package interviewbit.math;

import utils.Sieve;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author vinay.saini
 * @created 13/05/2020 - 12:54 AM
 * https://www.interviewbit.com/problems/prime-sum/
 */
public class PrimeSum {

    public ArrayList<Integer> primesum(int A) {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> primes = Sieve.generateAllPrimes(A);
        Set<Integer> lookupSet = new HashSet<>(primes);
        for (Integer p: primes) {
            if(lookupSet.contains(A-p)) {
                result.add(p);
                result.add(A-p);
                break;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(new PrimeSum().primesum(90));
    }
}

