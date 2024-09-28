package sep2024.topK;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/top-k-frequent-elements/
 */

class Pair {
    int e;
    int f;
    Pair(int e, int f)  {
        this.e = e;
        this.f = f;
    }
}
public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> frequencyMap = new TreeMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        int[] result = new int[k];
        int index = 0;
        while (!frequencyMap.isEmpty() && index < k) {
            result[index++] = frequencyMap.firstKey();
            frequencyMap.remove(frequencyMap.firstKey());
        }
        return result;
    }
}
