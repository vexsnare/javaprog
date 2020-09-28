package algorithms.tree;

import commons.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vinay.saini
 * @created 13/07/2020 - 12:01 AM
 */

public class BinarySearchTree {
    TreeNode<Integer> root;

    BinarySearchTree() {
        root = null;
    }

    public void addNode(TreeNode<Integer> node) {
        if(root == null) {
            root = node;
        } else {
            TreeNode<Integer> current = root;
            while (true) {
                if(node.getValue() <= current.getValue()) {
                    // node goes on left
                    if(current.getLeft() == null) {
                        current.setLeft(node);
                        break;
                    } else {
                        current = current.getLeft();
                    }
                } else {
                    // node goes to right
                    if(current.getRight() == null) {
                        current.setRight(node);
                        break;
                    } current = current.getRight();
                }
            }
        }
    }

    public void init(List<Integer> values) {
        values.forEach(value -> {
            TreeNode<Integer> newNode = new TreeNode<>(value);
            this.addNode(newNode);
        });
    }

    public boolean find(Integer value) {
        TreeNode<Integer> current = root;
        while (current != null) {
            if(value < current.getValue()) {
                current = current.getLeft();
            } else if(value > current.getValue()) {
                current = current.getRight();
            } else {
                return true;
            }
        }
        return false;
    }

    private void preOrder(TreeNode<Integer> current) {
        if(current == null) return;
        System.out.print(current.getValue() + ", ");
        preOrder(current.getLeft());
        preOrder(current.getRight());
    }


    private void inOrder(TreeNode<Integer> current) {
        if(current == null) return;
        inOrder(current.getLeft());
        System.out.print(current.getValue() + ", ");
        inOrder(current.getRight());
    }

    public void display() {
        inOrder(root);
    }


}
