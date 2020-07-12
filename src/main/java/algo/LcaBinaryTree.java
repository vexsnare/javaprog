package algo;

import java.util.Scanner;

/**
 * Created by vinaysaini on 6/2/16.
 */

/**
 * http://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
 * O(n)
 */
public class LcaBinaryTree {
    static int lca = 0;
    public static void main(String[] args) {
        int[] preOrder = {30, 20, 10, 12, 40, 37, 45};
        int[] inOrder = {10, 12, 20, 30, 37, 40, 45};
        BinaryTree bt = new BinaryTree(preOrder, inOrder);
       // bt.displayPreOrder();
        Scanner in = new Scanner(System.in);
        int Q = in.nextInt();
        for (int q = 0; q < Q; q++) {
            int x = in.nextInt();
            int y = in.nextInt();
            System.out.println(findLCA(bt.root, x, y));
        }
    }
    /**
     * todo
     * @param root
     * @param x
     * @param y
     * @return either ans(lca) or x or y
     */

    private static int findLCA(TreeNode root, int x, int y) {
        if(root == null) return -1;
        if(root.value == x || root.value == y) return root.value;
        else {
            int inLeft = findLca(root.left, x, y);
            int inRight = findLca(root.right, x, y);
            if(inLeft != -1 && inRight != -1) return root.value;
            else if(inLeft != -1) return inLeft;
            else if(inRight != -1) return inRight;
            else return -1;
        }
    }

    private static int findLca(TreeNode root, int x, int y) {
        int ret = -1;
        if(root == null) return -1;
        int inLeft = findLca(root.left, x, y);
        int inRight = findLca(root.right, x, y);
        if(inLeft == -1 && inRight == -1) {
            ret = (root.value == x || root.value == y) ? root.value : -1;
        } else if(inRight == -1) {
            if(inLeft == x) ret = root.value == y ? root.value : inLeft;
            else if (inLeft == y) ret = root.value == x ? root.value : inLeft;
            else ret = inLeft;
        } else if(inLeft == -1) {
            if(inRight == x) ret = root.value == y ? root.value : inRight;
            else if (inRight == y) ret = root.value == x ? root.value : inRight;
            else ret = inRight;
        } else if((inLeft == x && inRight == y) || (inLeft == y && inRight == x)) ret = root.value;
        return ret;
    }
}
