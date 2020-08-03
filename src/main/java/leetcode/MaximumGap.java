package leetcode;

import java.util.Arrays;

/**
 * @author vinay.saini
 * @created 02/08/2020 - 6:23 PM
 */
public class MaximumGap {

    public int maximumGap(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        if(max == min) {
            return 0;
        }
        int n = nums.length;
        double gap = Math.ceil((1.0*max-min)/(n-1));

        int[] minArray = new int[n];
        Arrays.fill(minArray, Integer.MAX_VALUE);

        int[] maxArray = new int[n];
        Arrays.fill(maxArray, -1);

        for (int i = 0; i < n; i++) {
            // find bucket
            int index = (int)((nums[i]-  min)/gap);
            minArray[index] = Math.min(minArray[index], nums[i]);
            maxArray[index] = Math.max(maxArray[index], nums[i]);
        }
        int ans = 0;
        int prevMax = maxArray[0];

        for (int i = 1; i < n; i++) {
            // No value in this bucket
            if(minArray[i] == Integer.MAX_VALUE) continue;
            ans = Math.max(ans, minArray[i] - prevMax);
            prevMax = maxArray[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        MaximumGap maximumGap = new MaximumGap();
        int input[] = {1,3,100};
        maximumGap.maximumGap(input);
    }
}
