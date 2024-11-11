package nov7_2024.search;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 */
public class RotatedArray {

    private int findValue(int[] ar, int value, int lo, int hi) {
        int index = -1;
        while(lo <= hi) {
            int m = lo + (hi - lo)/2;
            if(ar[m] < value) {
                lo = m + 1;
            } else if(ar[m] > value) {
                hi = m - 1;
            } else {
                index = m;
                break;
            }
        }
        return index;
    }

    private int findPivot(int[] ar) {
        // ar[i] >= ar[0] -> True else False
        int lo = 0;
        int hi = ar.length - 1;
        int pivotIndex = -1;
        while (lo <= hi) {
            int m = lo + (hi - lo) / 2;
            if(ar[m] >= ar[0]) {
                pivotIndex = m;
                lo = m + 1;
            } else {
                hi = m - 1;
            }
        }
        return pivotIndex;
    }

    public int search(int[] nums, int target) {
        int p = findPivot(nums);
        int lo = 0, hi = nums.length - 1;
        if(p == nums.length - 1 || target >= nums[0]) {
            hi = p;
        } else {
            lo = p + 1;
        }
        return findValue(nums, target, lo, hi);
    }

    public static void main(String[] args) {
        System.out.println(new RotatedArray().search(new int[]{5, 4}, 5));
    }
}
