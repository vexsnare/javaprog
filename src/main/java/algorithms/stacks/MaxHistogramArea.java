package algorithms.stacks;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by vinaysaini on 6/7/16.
 */

/**
 * Given an array of integers representing height of a histogram
 * Width is same as 1 unit - Find max Area
 * Complexity O(n)
 */
public class MaxHistogramArea {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = in.nextInt();
        }
        System.out.println(findMaxArea(ar));
    }

    static int findMaxArea(int[] ar) {
        Stack<Integer> stk = new Stack<>();
        int n = ar.length;
        int area = 0;
        for(int i = 0; i < n; i++) {
            if(stk.isEmpty()) stk.push(i);
            else {
                while(!stk.isEmpty() && ar[i] < ar[stk.peek()]) {
                    int idx = stk.pop();
                    int d = stk.isEmpty() ? i : i - stk.peek() - 1;
                    area = Math.max(area, ar[idx]*d);
                }
                stk.push(i);
            }
        }
        while(!stk.isEmpty()) {
            int idx = stk.pop();
            int d = stk.isEmpty() ? n : n - stk.peek() - 1;
            area = Math.max(area, ar[idx]*d);
        }
        return area;
    }
}
