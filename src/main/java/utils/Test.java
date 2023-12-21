package utils;/*
You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.



Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation:
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Example 2:

Input: nums = [1], k = 1
Output: [1]


Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
1 <= k <= nums.length
 */


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Test {

    private static List<Integer> findMax(int[] input, int K) {
        List<Integer> list = new ArrayList<>();

        Deque<Integer> dq = new LinkedList<>();

        int i = 0;
        int j = K - 1;
        for (int k = 0; k <= j; k++) {
            while (!dq.isEmpty() && input[dq.peekLast()] < input[k]) {
                dq.pollLast();
            }
            dq.add(k);
        }
        // [1  3  -1]
        // [1, 2]

        list.add(input[dq.peekFirst()]);
        while (j < input.length) {
            i++;
            if (!dq.isEmpty() && dq.peekFirst() < i) dq.pollFirst();
            j++;
            if(j == input.length) break;
            while (!dq.isEmpty() && input[dq.peekLast()] < input[j]) {
                dq.pollLast();
            }
            dq.add(j);
            list.add(input[dq.peekFirst()]);
        }

        return list;

    }

    public static void main(String[] args) {
        int[] input = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        List<Integer> result = findMax(input, k);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }


    }
}