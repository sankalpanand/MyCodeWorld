package Leetcode.Easy;

import Leetcode.Templates.TreeNode;

public class Q124BinaryTreeMaximumPathSum {

    // Neetcode - https://www.youtube.com/watch?v=Hr5cWUld4vU
    // Leetcode - https://leetcode.com/problems/binary-tree-maximum-path-sum/

    // Method to find the maximum path sum
    Integer res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        // Define the recursive DFS function
        dfs(root);

        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // Recursively compute the maximum path sum for left and right subtrees
        int leftMax = Math.max(dfs(root.left), 0);
        int rightMax = Math.max(dfs(root.right), 0);

        // Update the result with the maximum path sum at the current node
        res = Math.max(res, root.val + leftMax + rightMax);

        // Return the maximum sum of paths including the current node
        return root.val + Math.max(leftMax, rightMax);
    }
}
