package algorithms;

import commons.Range;
import java.util.Arrays;

/**
 * @author vinay.saini
 * @created 13/07/2020 - 10:41 AM
 */
public class Driver {
    public static void main(String[] args) {
//        BinarySearchTree bst = new BinarySearchTree();
//        bst.init(Arrays.asList(2,3,1, 4,51,61, 0));
//        bst.display();
//        System.out.println(bst.find(0));

        SegmentTree segmentTree = new SegmentTree(Arrays.asList(2,3,4,6,10));
        System.out.println(segmentTree.getSum(new Range(2,4)));
        segmentTree.update(0, 10);
        segmentTree.update(1, 20);
        System.out.println(segmentTree.getSum(new Range(0,4)));
        System.out.println(segmentTree.getSum(new Range(1,1)));
    }
}
