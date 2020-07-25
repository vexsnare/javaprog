package adhoc;

import commons.TreeNode;

/**
 * @author vinay.saini
 * @created 23/07/2020 - 7:32 PM
 */




public class AmazonHackerRank2 {

    TreeNode<Integer> root = null;

    private int findDistance(TreeNode<Integer> current, int value) {
        if(value < current.value) {
            return 1 + findDistance(current.left, value);
        } else if(value > current.value) {
            return 1 + findDistance(current.right, value);
        } else {
            return 0;
        }
    }

    private int findLCA(TreeNode<Integer> current, int value1, int value2) {
        if(value1 < current.value && value2 < current.value) {
            return findLCA(current.left, value1, value2);
        } else if(value1 > current.value && value2 > current.value) {
            return findLCA(current.right, value1, value2);
        } else {
            return current.value;
        }
    }

    private void addNode(TreeNode<Integer> node) {
        if(root == null) {
            root = node;
        } else {
            TreeNode<Integer> current = root;
            while (true) {
                if(node.value <= current.value) {
                    // node goes on left
                    if(current.left == null) {
                        current.left = node;
                        break;
                    } else {
                        current = current.left;
                    }
                } else {
                    // node goes to right
                    if(current.right == null) {
                        current.right = node;
                        break;
                    } current = current.right;
                }
            }
        }
    }

    public static void main(String[] args) {
        int num = 6;
        int[] values = {5, 6, 3, 1, 2 , 4};
        AmazonHackerRank2 exp = new AmazonHackerRank2();
        for (int i = 0; i < values.length; i++) {
            exp.addNode(new TreeNode<>(values[i]));
        }
        int n1 = 2;
        int n2 = 4;
        int found = 0;
        for (int i = 0; i < values.length; i++) {
            if(values[i] == n1) found++;
            if(values[i] == n2) found++;
        }
        if (found < 2) {
            System.out.println(-1);
        }
        int lca = exp.findLCA(exp.root, n1, n2);
        int d = exp.findDistance(exp.root, lca);
        int d1 = exp.findDistance(exp.root, n1);
        int d2 = exp.findDistance(exp.root, n2);
        System.out.println(d1 + d2 - 2*d);

    }
}
