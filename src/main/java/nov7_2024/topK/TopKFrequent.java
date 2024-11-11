package nov7_2024.topK;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/top-k-frequent-elements/
 */

public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> frequencyMap = new TreeMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        List<Integer> sortedKeys = new ArrayList<>(frequencyMap.keySet());
        sortedKeys.sort((x, y) -> frequencyMap.get(y) - frequencyMap.get(x));
        return sortedKeys.subList(0, k).stream().mapToInt(Integer::intValue).toArray();
    }
}
