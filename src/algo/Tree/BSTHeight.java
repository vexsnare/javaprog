package algo.Tree;

public class BSTHeight {

    int calculateHeight(TreeNode node) {
        if(null == node) {
            return 0;
        }
        return 1 + Math.max(calculateHeight(node.left), calculateHeight(node.right));
    }

    public static void main(String[] args) {
        BSTHeight bstHeight =  new BSTHeight();
        BinarySearchTree bst = new BinarySearchTree();
        int[] input = { 4, 1, 10};
        bst.init(input);
        int h = bstHeight.calculateHeight(bst.getRootNode());
        System.out.println(h);
    }
}
