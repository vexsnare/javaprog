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
        if(intervals.length <= 0) result.add(newInterval);
        int i = 0;
        while (i < intervals.length) {
            // is overlap
            if(intervals[i][1] < newInterval[0]) {
                result.add(intervals[i]);
                i++;
            } else if(intervals[i][1] >= newInterval[0]) {
                
            }
//            if (intervals[i][1] < newInterval[0]) {
//                result.add(intervals[i]);
//                i++;
//            } else if (intervals[i][0] > newInterval[1]) {
//                result.add(newInterval);
//                while (i < intervals.length) {
//                    result.add(intervals[i]);
//                    i++;
//                }
//                break;
//            } else {
//                newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
//                newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
//                i++;
//            }
        }
        return result.toArray(new int[result.size()][]);
    }
}