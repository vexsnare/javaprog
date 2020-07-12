package commons;

/**
 * @author vinay.saini
 * @created 12/07/2020 - 11:39 PM
 */
public class TreeNode<T> {
    T value;
    TreeNode left;
    TreeNode right;
    TreeNode(T value) {
        this.value = value;
        left = null;
        right = null;
    }
    TreeNode(T value, TreeNode left, TreeNode right) {
        this.left = left;
        this.right = right;
        this.value = value;
    }
}
