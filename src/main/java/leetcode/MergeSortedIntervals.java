package leetcode;

import commons.Range;
import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * @author vinay.saini
 * @created 19/08/2020 - 7:56 PM
 */
class MergeSortedIntervals {

    class Pair {
        public int i;
        public int j;
        Pair(int x, int y) {
            this.i = x;
            this.j = y;
        }
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int i = 0;
        List<Pair> result = new ArrayList<>();
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(new Pair(intervals[i][0], intervals[i][1]));
            i++;
        }
        // merge
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        // add remaining
        result.add(new Pair(newInterval[0], newInterval[1]));
        while (i < intervals.length) {
            result.add(new Pair(intervals[i][0], intervals[i][1]));
            i++;
        }
        // Build answer
        int[][] ans = new int[result.size()][2];
        for(i = 0; i < result.size(); i++) {
            ans[i][0] = result.get(i).i;
            ans[i][1] = result.get(i).j;
        }
        return ans;
    }
}
