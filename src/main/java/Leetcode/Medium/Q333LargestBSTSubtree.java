package Leetcode.Medium;

import Leetcode.Templates.TreeNode;

public class Q333LargestBSTSubtree {

    // Tushar Roy - https://www.youtube.com/watch?v=4fiDs7CCxkc
    // https://leetcode.com/problems/largest-bst-subtree/description/
    public int largestBSTSubtree(TreeNode root) {
        return helper(root)[4];
    }

    // Every node returns min, max, total number of nodes below it, whether it's a BST, size of largest BST encountered so far:
    // {min value, max value, number of nodes, is a BST, size of largest BST encountered}.
    private int[] helper(TreeNode currNode) {
        if (currNode == null)
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0, 1, 0};

        int[] left = helper(currNode.left);
        int[] right = helper(currNode.right);

        int newMin = Math.min(currNode.val, Math.min(left[0], right[0]));
        int newMax = Math.max(currNode.val, Math.max(left[1], right[1]));
        int newNumNodes = left[2] + right[2] + 1;

        // Check if we can create a new BST with the current node.
        int isBST = (left[1] < currNode.val && currNode.val < right[0] && left[3] == 1 && right[3] == 1) ? 1 : 0;    // 1 is true, 0 is false.
        int currBSTSize = (isBST == 1) ? left[2] + right[2] + 1 : 0;
        int newMaxBSTSize = Math.max(currBSTSize, Math.max(left[4], right[4]));
        return new int[]{newMin, newMax, newNumNodes, isBST, newMaxBSTSize};
    }
}
