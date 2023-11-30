package algorithms.recursion;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by vinaysaini on 5/1/16.
 * Edited on 15-july-2020
 */

public class PrintAllPermutation {
    /*
        Based on swapping - dfs
     */
    public void permute(StringBuilder sb, int index) {
        if (index == sb.length() - 1) {
            System.out.println(sb.toString());
        }
        for (int i = index; i < sb.length(); i++) {
            swap(sb, index, i);
            permute(sb, index + 1);
            swap(sb, index, i);
        }
    }

    private void swap(StringBuilder sb, int i, int j) {
        char temp = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, temp);
    }
}
