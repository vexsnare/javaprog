package leetcode;

import java.util.*;

/**
 * @author vinay.saini
 * @created 30/08/2020 - 4:54 PM
 */



public class FrogJump {
    boolean solve(int[] ar) {

        int n = ar.length;
        Set<Integer>[] dp = new HashSet[n];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new HashSet<>();
        }
        dp[0].add(0);

        Map<Integer, Integer> m = new HashMap<>();

        for (int i = 0; i < n; i++) {
            m.put(ar[i], i);
        }

        for (int i = 0; i < n; i++) {
            // k-1, k, k+1
            for(Integer step: dp[i]) {
                int step1 = step - 1;
                int step3 = step + 1;
                int position = ar[i];
                if(step1 > 0 && m.containsKey(position + step1)) {
                    dp[m.get(position+step1)].add(step1);
                }
                if(step > 0 && m.containsKey(position + step)) {
                    dp[m.get(position+ step)].add(step);
                }
                if(m.containsKey(position + step3)) {
                    dp[m.get(position+step3)].add(step3);
                }
            }
        }
        return dp[n-1].size() > 0;
    }
    public static void main(String[] args) {
        int[] input = {0,1,2,3,4,8,9,11};
        FrogJump frogJump = new FrogJump();
        System.out.println(frogJump.solve(input));
    }
}
