package sep2024.interval;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for inserting an interval into a list of non-overlapping intervals.
 * https://leetcode.com/problems/insert-interval/
 */
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        while (i < intervals.length) {
            // new interval comes first
            if (newInterval[1] < intervals[i][0]) {
                break;
            } // new interval comes later
            else if (newInterval[0] > intervals[i][1]) {
                result.add(new int[]{intervals[i][0], intervals[i][1]});
                i++;
            } else {
                // overlap - update new interval
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
                i++;
            }
        }
        result.add(new int[]{newInterval[0], newInterval[1]});
        while (i < intervals.length) {
            result.add(new int[]{intervals[i][0], intervals[i][1]});
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}