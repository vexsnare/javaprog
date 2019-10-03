package Tree;

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;
    TreeNode(int value, TreeNode left, TreeNode right) {
        this.left = left;
        this.right = right;
        this.value = value;
    }
    TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
public class BinarySearchTree {
    private TreeNode root = null;

    public TreeNode getRootNode() {
        return root;
    }

    public void insertNode(TreeNode node) {
        if(root == null) {
            root = node;
        } else {
            TreeNode curNode = root;
            while (true) {
                if (node.value <= curNode.value) {
                    if (curNode.left == null) {
                        curNode.left = node;
                        break;
                    }
                    else curNode = curNode.left;
                } else {
                    if (curNode.right == null) {
                        curNode.right = node;
                        break;
                    }
                    else curNode = curNode.right;
                }
            }
        }
    }

    void init(int[] input) {
        for (int e: input) {
            insertNode(new TreeNode(e));
        }
    }


    public void printPreOrder(TreeNode node) {
        if(null == node) return;
        System.out.println(node.value + " -> ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    public void printPostOrder(TreeNode node) {
        if(null == node) return;
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.println(node.value + " -> ");
    }

    public void printInOrder(TreeNode node) {
        if(null == node) return;
        printInOrder(node.left);
        System.out.println(node.value + " -> ");
        printInOrder(node.right);
    }
    

    
}
