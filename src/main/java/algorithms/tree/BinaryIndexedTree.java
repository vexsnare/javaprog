package algorithms.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author vinay.saini
 * @created 13/07/2020 - 7:42 PM
 */

/**
 * Interesting concept - difficult to understand easy to implement
 * Ref: https://www.youtube.com/watch?v=CWDQJGaN1gY&t=406s
 */

public class BinaryIndexedTree {

    private Integer[] prefixSum;
    private int size;

    BinaryIndexedTree(List<Integer> values) {
        this.size = values.size();
        prefixSum = new Integer[size + 1];
        Arrays.fill(prefixSum,0);
        this.build(values);
    }

    private int get2sCompliment(int number) {
        return ~number + 1;
    }

    private int getNextToUpdate(int number) {
        return number + (number & get2sCompliment(number));
    }

    private int getParent(int number) {
        return number - (number & get2sCompliment(number));
    }

    private void build(List<Integer> values) {
        for(int i = 0; i < values.size(); i++) {
            int pos = i + 1;
            prefixSum[pos] += values.get(i);
            while (getNextToUpdate(pos) < prefixSum.length) {
                pos = getNextToUpdate(pos);
                prefixSum[pos] += values.get(i);
            }
        }
    }

    private int getPrefixSum(int index) {
        int pos = index + 1;
        int sum = prefixSum[pos];
        while (getParent(pos) > 0) {
            pos = getParent(pos);
            sum += prefixSum[pos];
        }
        return sum;
    }

    public int findSum(int index1, int index2) {
        assert(index1 >= 0 && index2 < size );
        if(index1 == 0) {
            return getPrefixSum(index2);
        }
        return getPrefixSum(index2) - getPrefixSum(index1 - 1);
    }

    public void update(int index, int diff) {
        int pos = index + 1;
        prefixSum[pos] += diff;
        while (getNextToUpdate(pos) < prefixSum.length) {
            pos = getNextToUpdate(pos);
            prefixSum[pos] += diff;
        }
    }
}
