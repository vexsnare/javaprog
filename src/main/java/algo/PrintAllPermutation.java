package algo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by vinaysaini on 5/1/16.
 */

public class PrintAllPermutation {
    private static int count = 1;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        permute(new StringBuilder(s), 0);
    }

    /*
        Based on swapping - dfs
     */
    private static void permute(StringBuilder sb, int index) {
        if (index == sb.length() - 1) {
            for (int i = 0; i < sb.length(); i++) {
                System.out.println(sb.toString());
            }
        }
        for (int i = index; i < sb.length(); i++) {
            swap(sb, index, i);
            permute(sb, index + 1);
            swap(sb, index, i);
        }
    }

    private static void swap(StringBuilder sb, int i, int j) {
        char temp = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, temp);
    }
}
