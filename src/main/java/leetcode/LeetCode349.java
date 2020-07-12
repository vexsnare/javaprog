package leetcode;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays/
 */
public class LeetCode349 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] ar1 = {1,2,2,1};
        int[] ar2 = {2,2};
        int[] result = intersection(ar1, ar2);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
    public  static  int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> ans = new HashSet<Integer>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            int elem = nums2[i];
            if(set.contains(elem)) {
                ans.add(elem);
            }
        }
        int[] ret = new int[ans.size()];
        int i = 0;
        for (int x: ans
             ) {
            ret[i++] = x;
        }
        return ret;
    }
}