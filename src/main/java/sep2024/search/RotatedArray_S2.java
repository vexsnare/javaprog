package sep2024.search;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 */
public class RotatedArray_S2 {

    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int m = lo + (hi - lo) / 2;
            if(nums[m] == target) return m;
            if(nums[m] >= nums[lo]) {
                if(target < nums[m] && target >= nums[lo]) hi = m - 1;
                else lo = m + 1;
            } else {
                if(target > nums[m] && target <= nums[hi]) lo = m + 1;
                else hi = m - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(new RotatedArray_S2().search(new int[]{5, 4}, 5));
    }
}
