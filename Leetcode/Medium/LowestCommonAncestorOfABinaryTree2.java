package Leetcode.Medium;

import Leetcode.Templates.TreeNode;

public class LowestCommonAncestorOfABinaryTree2 {
    boolean pFound = false;
    boolean qFound = false;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode LCA = LCA(root, p, q);
        return pFound && qFound ? LCA : null;
    }

    public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;
        TreeNode left = LCA(root.left, p, q);
        TreeNode right = LCA(root.right, p, q);
        if (root == p) {
            pFound = true;
            return root;
        }
        if (root == q) {
            qFound = true;
            return root;
        }

        // If one side is null, then return the other non null. If both are null, return root.
        if(left == null) {
            return right;
        }

        else if(right == null) {
            return left;
        }

        else
            return root;


    }
}
