package sep2024.topK;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/
 */


class Touple {
    int i1;
    int i2;
    Touple(int x, int y) {
        this.i1 = x;
        this.i2 = y;
    }
}

public class KSmallestPair {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Touple> heap = new PriorityQueue<>((x, y) -> {
            return nums1[x.i1] + nums2[x.i2] - nums1[y.i1] - nums2[y.i2];
        });
        for (int i = 0; i < nums1.length && i < k; i++) {
            heap.add(new Touple(i, 0));
        }
        List<List<Integer>> result = new ArrayList<>();
        while (!heap.isEmpty() && result.size() < k) {
           Touple p = heap.poll();
           result.add(List.of(nums1[p.i1], nums2[p.i2]));
           if(p.i2 < nums2.length -1) heap.add(new Touple(p.i1, ++p.i2));
          // else if (heap.isEmpty()) heap.add(new Touple(++p.i1, 0));
        }
        return result;
    }

    public static void main(String[] args) {
        new KSmallestPair().kSmallestPairs(new int[]{1,2,4,5,6}, new int[]{3,5,7,9}, 3);
    }
}
