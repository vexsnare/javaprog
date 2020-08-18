package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vinay.saini
 * @created 25/07/2020 - 12:11 PM
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
 */


public class SortSubArray {
    public int findUnsortedSubarray(int[] nums) {
        int i = 0;
        int n = nums.length;
        while (i + 1 < n && nums[i] <= nums[i+1]) i++;
        if(i == n-1) return 0;
        int j = n - 1;
        while (j - 1 >= 0 && nums[j - 1] <= nums[j]) j--;
        int k = i;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        while (k <= j) {
            max = Math.max(max, nums[k]);
            min = Math.min(min, nums[k]);
            k++;
        }

        while (j < n && nums[j] < max) j++;
        j--;

        while (i >= 0 && nums[i] > min) i--;
        i++;
        return  j - i + 1;
    }
}
