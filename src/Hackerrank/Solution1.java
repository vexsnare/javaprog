package Hackerrank;

import java.util.Scanner;

/*
https://www.hackerrank.com/challenges/bear-and-steady-gene
 */
public class Solution1 {
    static String str = "GTCA";
    static int[] count = new int[4];
    static int N;

    static int getIndex(char c) {
        for(int i = 0; i < str.length(); i++) {
            if(c == str.charAt(i)) return i;
        }
        return -1;
    }

    static boolean isOk() {
        for(int i = 0; i < 4; i++) {
            if(count[i] > N/4) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        N = n;
        String s = in.nextLine();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count[getIndex(c)]++;
        }
        int j = 0;
        int ans = s.length();
        for(int i = 0; i < n; i++) {
            while(j < n && !isOk()) {
                count[getIndex(s.charAt(j++))]--;
            }
            if(isOk()) {
                ans = Math.min(ans, j - i);
            }
            count[getIndex(s.charAt(i))]++;
        }
        System.out.println(ans);
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}