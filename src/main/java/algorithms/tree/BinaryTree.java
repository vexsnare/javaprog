package algorithms.tree;

/**
 * Created by vinaysaini on 6/1/16.
 * Edited on 14-July-2020.
 */

import utils.TreeNode;
class BinaryTree {
    TreeNode<Integer> root;
    BinaryTree(int[] preOrder, int[]inOrder ) {
        this.root = build(preOrder, 0, preOrder.length-1, inOrder, 0, inOrder.length-1);
    }
    private TreeNode build(int[] preOrder, int i, int j, int[] inOrder, int p, int q) {
        if(i == j) return new TreeNode(preOrder[i]);
        TreeNode currentRoot = new TreeNode(preOrder[i]);
        int pos = p;
        for (; pos <= q ; pos++) {
            if(inOrder[pos] == preOrder[i]) break;
        }
        int leftTreeSize = pos - p;
        int rightTreeSize = q - pos;
        if(leftTreeSize > 0) {
            currentRoot.setLeft(build(preOrder, i + 1, i + leftTreeSize, inOrder, p, pos - 1));
        }
        if(rightTreeSize > 0) {
            currentRoot.setRight( build(preOrder, j - rightTreeSize + 1, j, inOrder, pos + 1, q));
        }
        return currentRoot;
    }

    public void traverseInPreOrder(TreeNode root) {
        if(root == null) return;
        System.out.print(root.getValue() + ", ");
        traverseInPreOrder(root.getLeft());
        traverseInPreOrder(root.getRight());
    }

    public void traverseInInOrder(TreeNode root) {
        if(root == null) return;
        traverseInInOrder(root.getLeft());
        System.out.print(root.getValue() + ", ");
        traverseInInOrder(root.getRight());
    }
}

