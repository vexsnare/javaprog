package nov7_2024.two_pointers;

import utils.Printer;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/sliding-window-maximum/
 */

public class SlidingWindowMax {
    public List<Integer> slidingMaximum(final List<Integer> num, int K) {
        List<Integer> ans = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();
        int i = 0;
        int j = 0;
        while (j < K) {
            while (!dq.isEmpty() && num.get(dq.peekLast()) <= num.get(j)) dq.pollLast();
            dq.add(j);
            j++;
        }
        ans.add(dq.peekFirst());
        while (j < num.size()) {
            if(dq.peekFirst() == i) {
                dq.pollFirst();
                i++;
            }
            while (!dq.isEmpty() && num.get(dq.peekLast()) <= num.get(j)) dq.pollLast();
            dq.add(j);
            ans.add(dq.peekFirst());
            j++;
        }
        return ans.stream().map(num::get).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        int [] ar = {1,3,-1,-3,5,3,6,7};
        int b = 3;
        SlidingWindowMax slidingWindowMax = new SlidingWindowMax();
        List<Integer> input = Arrays.stream(ar).boxed().collect(Collectors.toList());
        Printer.print(slidingWindowMax.slidingMaximum(input, b));
    }
}
