package leetcode;

import helpers.Printer;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author vinay.saini
 * @created 23/08/2020 - 9:51 AM
 */
public class SlidingWindowMax {
    public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        ArrayList<Integer> ans = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();
        int i = 0;
        int j = 0;
        while (true) {
            if(j >= B-1) {
                // window achieved - remove from front
                ans.add(dq.peekFirst());
                if(dq.peekFirst().equals(A.get(i))) dq.pollFirst();
                i++;
            }
            if(j + 1 >= A.size()) break;
            int x = A.get(j);
            if(dq.isEmpty() || x > dq.peekFirst()) {
                while (!dq.isEmpty()) dq.pollFirst();
                dq.addFirst(x);
            } else {
                while (dq.peekLast() < x) dq.pollLast();
                dq.addLast(x);
            }
            j++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int [] ar = { 648, 614, 490, 138, 657, 544, 745, 582, 738, 229, 775, 665, 876, 448, 4, 81, 807, 578, 712, 951, 867, 328, 308, 440, 542, 178, 637, 446, 882, 760, 354, 523, 935, 277, 158, 698, 536, 165, 892, 327, 574, 516, 36, 705, 900, 482, 558, 937, 207, 368 };
        int b = 9;
        SlidingWindowMax slidingWindowMax = new SlidingWindowMax();
            List<Integer> input = Arrays.stream(ar).boxed().collect(Collectors.toList());
        Printer.print(slidingWindowMax.slidingMaximum(input, b));
    }
}
