package sep2024.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author vinay.saini
 *
 * Given an array A of N integers, find three integers in A such that the sum is closest to a given number B. Return the sum of those three integers.
 * Assume that there will only be one solution.
 * A = [-1, 2, 1, -4]
 * B = 1
 * ANS = 2
 */

// https://www.interviewbit.com/problems/3-sum/

public class ThreeSum {
    public int threeSumClosest(ArrayList<Integer> A, int B) {
        if(A.size() <= 2) return -1;
        Collections.sort(A);
        int ans = A.get(0) + findClosest(A, 1, B - A.get(0));
        for (int i = 1; i < A.size() - 2; i++) {
            int current = A.get(i) + findClosest(A, i + 1, B - A.get(i));
            if(Math.abs(B - current) < Math.abs(B - ans)) ans = current;
        }
        return ans;
    };

    private int findClosest(ArrayList<Integer> a, int si, int target) {
        int p1 = si;
        int p2 = a.size()-1;
        int closest = a.get(p1) + a.get(p2);
        while (p1 < p2) {
            int sum = a.get(p1) + a.get(p2);
            if(Math.abs(target - sum) < Math.abs(target - closest)) closest = sum;
            if(sum > target) {
                p2--;
            } else p1++;
        }
        return closest;
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(5, -2, -1, -10, 10));

        System.out.println(new ThreeSum().threeSumClosest(a, 5));
    }
}
