package algo;

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
        int n = ar.length;
        Stack<Integer> stack = new Stack<Integer>();
        int max_area = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() || ar[stack.peek()] < ar[i]) stack.push(i);
            else {
                do {
                    int area;
                    int top = stack.pop();
                    if (stack.isEmpty()) {
                        area = ar[top] * i;
                    } else area = ar[top] * (i - stack.peek() - 1);
                    max_area = Math.max(max_area, area);

                } while (!stack.isEmpty() && ar[stack.peek()] > ar[i]);
                stack.push(i);
            }
        }
        while (!stack.isEmpty()) {
            int top = stack.pop();
            int area;
            if(stack.isEmpty()) area = ar[top] * n;
            else area = ar[top] * (n - stack.peek() - 1);
            max_area = Math.max(max_area, area);
        }
        return max_area;
    }
}
