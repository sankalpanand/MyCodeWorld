package Leetcode.Medium;

import Leetcode.Templates.TreeNode;

public class Q337HouseRobber3 {

    public int rob(TreeNode root) {
        int[] num = dfs(root);
        return Math.max(num[0], num[1]);
    }

    // Leetcode - https://leetcode.com/problems/house-robber-iii/description/
    // Neetcode - https://www.youtube.com/watch?v=nHR8ytpzz7c
    private int[] dfs(TreeNode x) {
        if (x == null) return new int[2];
        int[] left = dfs(x.left);
        int[] right = dfs(x.right);
        int[] res = new int[2];
        res[0] = left[1] + right[1] + x.val;
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return res;
    }
}
