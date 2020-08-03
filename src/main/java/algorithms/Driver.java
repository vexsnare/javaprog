package algorithms;

import commons.Graph;
import commons.Pair;
import commons.WeightedGraph;

import java.util.*;
import java.util.LinkedList;

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

//        BinaryIndexedTree binaryIndexedTree = new BinaryIndexedTree(Arrays.asList(1,2,3,4,5,6,1,2,3,4,5,6,1,2,3,4,5,6,1,2,3,4,5,6,1,2,3,4,5,6));
//        System.out.println(binaryIndexedTree.findSum(0, 3));
//        binaryIndexedTree.update(19, 5);
//        System.out.println(binaryIndexedTree.findSum(0, 3));
//        binaryIndexedTree.update(5, -3);
//        System.out.println(binaryIndexedTree.findSum(2, 5));

//        int[] preOrder = {30, 20, 10, 12, 40, 37, 45};
//        int[] inOrder = {10, 12, 20, 30, 37, 40, 45};
//        BinaryTree bt = new BinaryTree(preOrder, inOrder);
//        bt.traverseInInOrder(bt.root);

//        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
//        doublyLinkedList.addFrontByValue(1);
//        DLLNode<Integer> ref = doublyLinkedList.addFrontByValue(2);
//        doublyLinkedList.addFront(new DLLNode<>(3));
//        doublyLinkedList.display();
//        doublyLinkedList.display();
//        doublyLinkedList.remove(ref);

//        LRUCache lruCache = new LRUCache(3);
//        lruCache.set(2,5);
//        lruCache.set(2,4);
//        lruCache.set(2, 1);
//        System.out.println(lruCache.get(2));
//        lruCache.set(3, 5);
//        System.out.println(lruCache.get(2));
//        System.out.println(lruCache.get(3));
//        lruCache.set(5,10);
//        System.out.println(lruCache.get(1));

//        List<Integer> input = Arrays.asList(4,3,2,15,8,19,21,4,90);
//        LinkedList linkedList = new LinkedList(input);
//        linkedList.display();
//        linkedList.reverseList(linkedList.head);
//        linkedList.display();

//        CircularQueue circularQueue = new CircularQueue(3);
//        Scanner scanner = new Scanner(System.in);
//        while (true) {
//            int typeOfopr = scanner.nextInt();
//            if(typeOfopr == 1) {
//                circularQueue.push(scanner.nextInt());
//            } else {
//                System.out.println(circularQueue.pop());
//            }
//        }

//        PrintAllPermutation printAllPermutation = new PrintAllPermutation();
//        Scanner in = new Scanner(System.in);
//        String s = in.nextLine();
//        printAllPermutation.permute(new StringBuilder(s), 0);

//        UnionFind unionFind = new UnionFind(10);
//        System.out.println(unionFind.find(4));
//        unionFind.union(3, 4);
//        System.out.println(unionFind.find(4));
//        unionFind.union(3, 5);
//        unionFind.union(6, 5);
//        unionFind.union(6, 9);
//        unionFind.union(3, 7);
//        System.out.println(unionFind.find(6));
//        System.out.println(unionFind.find(9));
//
//        int V = 5;
//        int E = 7;
//        int[][]mat = {
//                {0, 3, 1},
//                {0, 4, 5},
//                {0, 1, 8},
//                {2, 4, 3},
//                {2, 1, 3},
//                {4, 1, 9},
//                {3, 4, 2}
//        };
//        WeightedGraph graph = new WeightedGraph(V, E, mat, false);
//        MST mst = new MST();
//        List<Pair<Integer, Integer>> edges =  mst.findMst(graph);
//        edges.stream().forEach(e -> System.out.println(e.first + " " + e.second));
    }

}
