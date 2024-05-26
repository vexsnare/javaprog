package psds.twoptr;

import utils.Printer;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author vinay.saini
 * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 * Return the max sliding window
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 */

// https://leetcode.com/problems/sliding-window-maximum/

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
        return ans.stream().map(x -> num.get(x)).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        int [] ar = {1,3,-1,-3,5,3,6,7};
        int b = 3;
        SlidingWindowMax slidingWindowMax = new SlidingWindowMax();
        List<Integer> input = Arrays.stream(ar).boxed().collect(Collectors.toList());
        Printer.print(slidingWindowMax.slidingMaximum(input, b));
    }
}
