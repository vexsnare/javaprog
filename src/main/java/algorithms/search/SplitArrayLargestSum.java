package algorithms.search;

/**
 * https://leetcode.com/problems/split-array-largest-sum/
 */

public class SplitArrayLargestSum {
    public static void main(String[] args) {
        int [] ar = {1, 2147483647};

        int m = 2;
        System.out.println(splitArray(ar, m));
    }
    public static int splitArray(int[] nums, int m) {
        long sum = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            sum += nums[i];
        }
        long l = 0;
        long r = sum;
        while(l <= r) {
            long mid = (l + r) / 2;
            if(isOk(nums, m, mid)) {
                r = mid-1;
            } else l = mid+1;
        }
        return (int)l;
    }

    static boolean isOk(int[] ar, int m, long sum) {
        int p = 0;
        int i = 0;
        while (i < ar.length) {
            long temp_sum = 0;
            boolean found = false;
            while (i < ar.length && temp_sum + ar[i] <= sum) {
                temp_sum += ar[i];
                i++;
                found = true;
            }
            if(!found) break;
            p++;
        }
        if(i == ar.length && p <= m)  return true;

        return false;
    }
}