package algorithms;

import commons.DLLNode;

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
//        segmentTree.update(0, 10);R
//        segmentTree.update(1, 20);
//        System.out.println(segmentTree.getSum(new Range(0,4)));
//        System.out.println(segmentTree.getSum(new Range(1,1)));

//        BinaryIndexedTree binaryIndexedTree = new BinaryIndexedTree(Arrays.asList(1,2,3,4,5,6));
//        System.out.println(binaryIndexedTree.findSum(0, 3));
//        binaryIndexedTree.update(0, 5);
//        System.out.println(binaryIndexedTree.findSum(0, 3));
//        binaryIndexedTree.update(5, -3);
//        System.out.println(binaryIndexedTree.findSum(2, 5));

//        int[] preOrder = {30, 20, 10, 12, 40, 37, 45};
//        int[] inOrder = {10, 12, 20, 30, 37, 40, 45};
//        BinaryTree bt = new BinaryTree(preOrder, inOrder);
//        bt.traverseInInOrder(bt.root);

        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        doublyLinkedList.addFrontByValue(1);
        DLLNode<Integer> ref = doublyLinkedList.addFrontByValue(2);
        doublyLinkedList.addFront(new DLLNode<>(3));
        doublyLinkedList.display();
        doublyLinkedList.remove(ref);
        doublyLinkedList.display();

    }

}
