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

//        SegmentTree2 segmentTree = new SegmentTree2(Arrays.asList(2,3,4,6,10));
//        System.out.println(segmentTree.getSum(new Range(2,4)));
//        segmentTree.update(0, 10);
//        segmentTree.update(1, 20);
//        System.out.println(segmentTree.getSum(new Range(0,4)));
//        System.out.println(segmentTree.getSum(new Range(1,1)));

        BinaryIndexedTree binaryIndexedTree = new BinaryIndexedTree(Arrays.asList(1,2,3,4,5,6));
        System.out.println(binaryIndexedTree.findSum(0, 3));
        binaryIndexedTree.update(0, 5);
        System.out.println(binaryIndexedTree.findSum(0, 3));
        binaryIndexedTree.update(5, -3);
        System.out.println(binaryIndexedTree.findSum(2, 5));
    }
}
