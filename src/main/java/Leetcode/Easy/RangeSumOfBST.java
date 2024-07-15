package Leetcode.Easy;

import java.util.Stack;
import Leetcode.Templates.TreeNode;

public class RangeSumOfBST {
    public static void main(String[] args) {
        // Example 2
        // 10,5,15,3,7,13,18,1,null,6
        // L 6, R 10
        //
        //                 10
        //                /  \
        //               5   15
        //              / \  / \
        //             3  7 13 18
        //            /  /
        //           1  6

        // Inorder - 1, 2, 5, 6, 7, 10, 13, 15, 18
    }

    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root == null) return 0;

        // If root element is greater than the upper bound, then the whole right sub tree will be greater and shall be discarded.
        if(root.val > R) return rangeSumBST(root.left, L, R);

        // If root element is smaller than the lower bound, then the whole left sub tree will be smaller and shall be discarded.
        if(root.val < L) return rangeSumBST(root.right, L, R);

        // It means root.val falls between L and R inclusive, so that should be considered in the sum
        return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
    }

    public int rangeSumBST_Iterative(TreeNode root, int L, int R) {
        Stack<TreeNode> stk = new Stack<>();
        stk.push(root);
        int sum = 0;

        while (!stk.isEmpty()) {
            TreeNode n = stk.pop();
            if (n == null) { continue; }
            if (n.val > L) { stk.push(n.left); } // left child is a possible candidate.
            if (n.val < R) { stk.push(n.right); } // right child is a possible candidate.
            if (L <= n.val && n.val <= R) { sum += n.val; }
        }
        return sum;
    }
}
