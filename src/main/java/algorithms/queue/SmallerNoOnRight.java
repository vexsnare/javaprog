package algorithms.queue;

import java.util.*;

class SmallerNoOnRight {

    class TreeNode {
        int value;
        int onleft;
        int dup;
        TreeNode left;
        TreeNode right;
        TreeNode (int v, int onLeft, int dup) {
            this.value = v;
            this.onleft = onLeft;
            this.dup = 0;
            this.left = null;
            this.right = null;
        }
    }

    TreeNode root = null;
    int ans = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int n = in.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = in.nextInt();
        }
     //  int[] ar  = {26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41};
        SmallerNoOnRight sol = new SmallerNoOnRight();
        sol.countSmaller(ar);
    }
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<Integer>();
        for (int i = n-1; i >= 0; i--) {
            root = insert(nums[i], root);
            System.out.println(ans);
            list.add(ans);
            ans = 0;
        }
        Collections.reverse(list);
        return list;
    }
    TreeNode insert(int val, TreeNode cur) {
        if(cur == null) {
            cur = new TreeNode(val, 0, 0);
        } else {
            if(val < cur.value) {
                cur.onleft++;
                cur.left = insert(val, cur.left);
            } else if (val > cur.value) {
                ans += (cur.dup + cur.onleft + 1);
                cur.right = insert(val, cur.right);
            } else {
                cur.dup++;
                ans += cur.onleft;
            }
        }
        return cur;
    }
}