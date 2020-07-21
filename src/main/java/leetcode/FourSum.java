package leetcode;

import java.util.*;

/**
 * @author vinay.saini
 * @created 21/07/2020 - 10:27 PM
 */

public class FourSum {

    class Pair {
        public int x;
        public int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    Map<Integer, List<Pair>> map = new HashMap<>();

    List<List<Integer>> ans = new ArrayList<>();
    int[] ar;

    private void validateAndInsert(Pair p1, List<Pair> pairs) {
        for(Pair p2: pairs) {
            if(p1.x != p2.x && p1.y != p2.x && p1.x != p2.y && p1.y != p2.y) {
                List<Integer> l = new ArrayList<>();
                l.add(ar[p1.x]);
                l.add(ar[p1.y]);
                l.add(ar[p2.x]);
                l.add(ar[p2.y]);
                Collections.sort(l);
                int k;
                for(k = 0; k < ans.size(); k++) {
                    if(ans.get(k).get(0).equals(l.get(0)) && ans.get(k).get(1).equals(l.get(1)) &&
                            ans.get(k).get(2).equals(l.get(2)) && ans.get(k).get(3).equals(l.get(3))) break;
                }
                if(k == ans.size()) ans.add(l);
            }
        }
    }

    public List<List<Integer>> solve(int[] nums, int target) {
        this.ar = nums;
        for(int i = 0;i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                Integer key = nums[i] + nums[j];
                if(map.containsKey(key)) {
                    map.get(key).add(new Pair(i, j));
                } else {
                    List<Pair> list = new ArrayList<>();
                    list.add(new Pair(i, j));
                    map.put(key, list);
                }
            }
        }

        for(Integer k: map.keySet()) {
            List<Pair> pairs = map.get(k);
            for(Pair p1: pairs) {
                if(map.containsKey(target-k)) {
                    validateAndInsert(p1, map.get(target-k));
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
        int[] input = {-493,-470,-464,-453,-451,-446,-445,-407,-406,-393,-328,-312,-307,-303,-259,-253,-252,-243,-221,-193,-126,-126,-122,-117,-106,-105,-101,-71,-20,-12,3,4,20,20,54,84,98,111,148,149,152,171,175,176,211,218,227,331,352,389,410,420,448,485};
        fourSum.solve(input, 1057);
    }
}
