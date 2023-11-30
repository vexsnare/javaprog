package algorithms.recursion;

import java.util.Scanner;

/**
 * Created by vinaysaini on 7/14/16.
 */

/**
 * http://www.geeksforgeeks.org/find-strings-formed-characters-mapped-digits-number/
 * Current solution is recursive
 */
public class StringFromDigits {
    static char map[] = new char[9];
    static char ar[][] = {{'A', 'B', 'C'}
            , {'D', 'E', 'F'}
            , {'G', 'H', 'I'}
            , {'J', 'K', 'L'}
            , {'M', 'N', 'O'}
            , {'P', 'Q', 'R'}
            , {'S', 'T', 'U'}
            , {'V', 'W', 'X'}
            , {'Y', 'Z'}};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        StringBuilder sb = new StringBuilder();
        solve(s, 0, sb);
    }

    static void solve(String s, int current_index, StringBuilder str) {
        if(current_index == s.length()) {
            System.out.println(str.toString());
            return;
        }
        if(map[s.charAt(current_index)-'0'] != '\u0000') {
            solve(s, current_index+1, str.append(map[s.charAt(current_index)-'0']));
            str.setLength(str.length()-1);
        } else {
            for (int i = 0; i < ar[s.charAt(current_index)-'0'].length; i++) {
                map[s.charAt(current_index)-'0'] = ar[s.charAt(current_index)-'0'][i];
                solve(s, current_index+1, str.append(ar[s.charAt(current_index)-'0'][i]));
                str.setLength(str.length()-1);
                map[s.charAt(current_index)-'0'] = '\u0000';
            }
        }
    }
}
