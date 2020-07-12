package algo;

/**
 * Created by vinaysaini on 6/1/16.
 */

/**
 *
 */
class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;
    TreeNode(int v) {
        this.value = v;
        this.left = null;
        this.right = null;
    }
}
class BinaryTree {
    TreeNode root;
    BinaryTree(int[] preOrder, int[]inOrder ) {
        this.root = build(preOrder, 0, preOrder.length-1, inOrder, 0, inOrder.length-1);
    }
    TreeNode build(int[] preOrder, int i, int j, int[] in, int p, int q) {
        if(i == j) return new TreeNode(preOrder[i]);
        TreeNode current_root = new TreeNode(preOrder[i]);
        int pos = p;
        for (; pos <= q ; pos++) {
            if(in[pos] == preOrder[i]) break;
        }
        int leftTreeSize = pos - p;
        int rightTreeSize = q - pos;
        if(leftTreeSize > 0) {
            current_root.left = build(preOrder, i + 1, i + leftTreeSize, in, p, pos - 1);
        }
        if(rightTreeSize > 0) {
            current_root.right = build(preOrder, j - rightTreeSize + 1, j, in, pos + 1, q);
        }
        return current_root;
    }
    BinaryTree() {
        this.root = new TreeNode(6);
        this.root.left = new TreeNode(9);
        this.root.left.left = new TreeNode(12);
        this.root.left.right = new TreeNode(4);
        this.root.right = new TreeNode(2);
        this.root.right.left = new TreeNode(6);
    }

    public void displayPreOrder() {
        traverseInPreOrder(this.root);
        System.out.println();
    }
    private void traverseInPreOrder(TreeNode root) {
        if(root == null) return;
        System.out.print(root.value + ", ");
        traverseInPreOrder(root.left);
        traverseInPreOrder(root.right);
    }
    public void displayInOrder() {
        traverseInInOrder(this.root);
        System.out.println();
    }
    private void traverseInInOrder(TreeNode root) {
        if(root == null) return;
        traverseInInOrder(root.left);
        System.out.print(root.value + ", ");
        traverseInInOrder(root.right);
    }
}

class BinaryTreeTest {
    public static void main(String[] args) {
        int[] preOrder = {30, 20, 10, 12, 40, 37, 45};
        int[] inOrder = {10, 12, 20, 30, 37, 40, 45};
        BinaryTree bt = new BinaryTree(preOrder, inOrder);
        bt.displayPreOrder();
        bt.displayInOrder();
    }
}