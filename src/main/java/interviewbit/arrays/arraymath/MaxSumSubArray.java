package interviewbit.arrays.arraymath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://www.interviewbit.com/problems/max-sum-contiguous-subarray/
 */
public class MaxSumSubArray {

    private int findSum(final List<Integer> input) {
        int max_so_far = Integer.MIN_VALUE;
        int sum = 0;
        for (Integer anInput : input) {
            sum += anInput;
            if (sum < 0) {
                max_so_far = Math.max(max_so_far, sum);
                sum = 0;
            } else max_so_far = Math.max(max_so_far, sum);
        }
        return max_so_far;
    }

    public static void main(String[] args) {
        List<Integer> input1 = new ArrayList<>(Arrays.asList(-2, 1, -3, 4, -1, 2, 1, -5, 4));
        List<Integer> input2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, -10));
        MaxSumSubArray maxSumSubArray = new MaxSumSubArray();
        System.out.println(maxSumSubArray.findSum(input2));
    }
}
                                    