package algorithms.tree;

import utils.Range;
import utils.TreeNode;

import java.util.List;

/**
 * @author vinay.saini
 * @created 13/07/2020 - 3:32 PM
 */

// Uses pointer tree node
public class SegmentTree2 {
    private TreeNode<Integer> root;
    private List<Integer> values;


    SegmentTree2(List<Integer> values) {
        this.values = values;
        root = construct(new Range(0, values.size() - 1));
    }

    private int calculate(Range range, TreeNode<Integer> node, Range queryRange) {
        if(range.equals(queryRange)) {
            return node.getValue();
        } else {
            Range range1 = range.getFirstHalf();
            Range range2 = range.getSecondtHalf();
            int sum = 0;
            if(range1.overlap(queryRange)) {
                sum += calculate(range1, node.getLeft(), new Range(queryRange.index1, Math.min(queryRange.index2, range1.index2)));
            }
            if(range2.overlap(queryRange)) {
                sum += calculate(range2, node.getRight(), new Range(Math.max(queryRange.index1, range2.index1), queryRange.index2));
            }
            return sum;
        }
    }

    private void update(Range range, TreeNode<Integer> node, int index, int diff) {
        if(range.getLength() == 1) {
            node.setValue(node.getValue() + diff);
        } else {
            Range range1 = range.getFirstHalf();
            Range range2 = range.getSecondtHalf();
            if(range1.contains(index)) {
                update(range1, node.getLeft(), index, diff);
            } else {
                update(range2, node.getRight(), index, diff);
            }
            node.setValue(node.getValue() + diff);
        }
    }

    public int getSum(Range queryRange) {
        Range range = new Range(0, values.size() - 1);
        return calculate(range, root, queryRange);
    }

    public void update(int index, int diff) {
        Range range = new Range(0, values.size() - 1);
        update(range, root, index, diff);
    }

    private TreeNode<Integer> construct(Range range) {
        if(range.getLength() == 1) {
            return new TreeNode<>(values.get(range.index1));
        } else {
            TreeNode<Integer> leftNode = construct(range.getFirstHalf());
            TreeNode<Integer> rightNode = construct(range.getSecondtHalf());
            TreeNode<Integer> currentNode = new TreeNode<>(leftNode.getValue() + rightNode.getValue());
            currentNode.setLeft(leftNode);
            currentNode.setRight(rightNode);
            return currentNode;
        }
    }
}
