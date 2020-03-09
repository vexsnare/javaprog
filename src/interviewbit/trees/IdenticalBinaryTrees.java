package interviewbit.trees;

/**
 * @author vinay.saini
 * @created 08/03/2020 - 9:59 AM
 */
public class IdenticalBinaryTrees {
    public int isSameTree(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return 1;
        }
        if(A == null | B == null) return 0;
        if(A.val != B.val) return 0;
        return isSameTree(A.left, B.left) & isSameTree(A.right, B.right);
    }
}
