package nov7_2024.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The MergeInterval class provides functionality for merging overlapping intervals.
 * Intervals are represented as pairs of integers [start, end].
 * https://leetcode.com/problems/merge-intervals/description/
 */

public class MergeInterval {

    public int[][] merge(int[][] intervals) {
        List<int[]> results = new ArrayList<>();
        Arrays.sort(intervals, (int[] a, int[] b) -> a[0] - b[0]);
        int[] current = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] <= current[1]) {
                current[1] = Math.max(current[1], intervals[i][1]);
            } else {
                results.add(new int[]{current[0], current[1]});
                current = intervals[i];
            }
        }
        results.add(new int[]{current[0], current[1]});
        return results.toArray(new int[results.size()][]);
    }
}
