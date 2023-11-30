package algorithms.recursion;

import java.util.Scanner;

/**
 * http://www.geeksforgeeks.org/lexicographically-previous-permutation-in-c/
 * Created by vinay saini on 7/14/16.
 */
public class NextLexSmallPermutation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(find(s));
    }
    static String find(String s) {
        char[] ar = s.toCharArray();
        int i = s.length()-1;
        while (i > 0  && (ar[i-1] <= ar[i])) i--;
        if(i > 0) {
            int j = s.length()-1;
            while (ar[i-1] <= ar[j]) j--;
            swap(ar, i-1, j);
            reverse(ar, i, s.length()-1);
            return String.valueOf(ar);
        } else return "No number exist";
    }
    static void reverse(char[] ar, int i, int j) {
        while (i < j) {
            swap(ar, i, j);
            i++;
            j--;
        }
    }
    static void swap(char[] ar, int i, int j) {
        char c = ar[i];
        ar[i] = ar[j];
        ar[j] = c;
    }
}
