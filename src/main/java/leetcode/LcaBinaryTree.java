package leetcode;

import commons.TreeNode;

import java.util.Scanner;

/**
 * Created by vinaysaini on 6/2/16.
 */

/**
 * http://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/submissions/
 * O(n)
 */
public class LcaBinaryTree {
    private int findLCA(TreeNode<Integer> root, int x, int y) {
        if(root == null) return -1;
        if(root.getValue() == x || root.getValue() == y) return root.getValue();
        else {
            int inLeft = findLCA(root.getLeft(), x, y);
            int inRight = findLCA(root.getRight(), x, y);
            if(inLeft != -1 && inRight != -1) return root.getValue();
            else if(inLeft != -1) return inLeft;
            else if(inRight != -1) return inRight;
            else return -1;
        }
    }
}
