package algorithms.math;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * https://www.interviewbit.com/problems/maximum-absolute-difference/
 */
public class MaxAbsDiff {

    int solve(ArrayList<Integer> A) {
        if(A.size() <= 1) return -1;
        int ans = -1;
        int max1 = A.get(0);
        int min1 = A.get(0);
        int max2 = A.get(0);
        int min2 = A.get(0);
        for(int i = 1; i < A.size(); i++) {
            if(A.get(i) + i > max1) max1 = A.get(i) + i;
            if(A.get(i) + i < min1) min1 = A.get(i) + i;
            if(A.get(i) - i > max2) max2 = A.get(i) - i;
            if(A.get(i) - i < max2) min2 = A.get(i) - i;
        }
        ans = Math.max ( ans, max1 - min1 );
        ans = Math.max ( ans, max2 - min2 );
        return ans;

    }
                
    public static void main(String[] args) {
        MaxAbsDiff maxAbsDiff = new MaxAbsDiff();
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1, 2, -3, 12, 9));
        System.out.println(maxAbsDiff.solve(input));
    }
}
