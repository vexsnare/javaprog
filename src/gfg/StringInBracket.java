package gfg;

import java.util.Scanner;

/**
 * Created by vinaysaini on 7/14/16.
 */

/**
 * http://www.geeksforgeeks.org/print-ways-break-string-bracket-form/
 * Time Complexity: O(2^(n-1))
 */
public class StringInBracket {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        solve("", s, 0);
    }
    static void solve(String res, String s, int cur_index) {
        if(cur_index == s.length()) {
            System.out.println(res);
            return;
        }
        for (int i = cur_index; i < s.length(); i++) {
            String newRes = res + "(" + s.substring(cur_index, i+1) + ")";
            solve(newRes, s, i+1);
        }
    }
}
