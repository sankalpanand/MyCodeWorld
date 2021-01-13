package Leetcode.Easy;

public class TrimBST {
    public static void main(String[] args) {


    }

    // Time Complexity - We will have to visit every node once so O(N);
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null)
            return null;

        // If the value of this node is less than L, then the whole left subtree will be smaller,
        // so we can discard the left sub tree and return the root of the trimmed right sub tree
        if (root.val < L)
            return trimBST(root.right, L, R);

        // If the value of this node is greater than R, then the whole right subtree will be greater
        // so we can discard the right sub tree and return the root of the trimmed left sub tree
        if (root.val > R)
            return trimBST(root.left, L, R);

        // If the value of this node does not need to be deleted, we need to pass this recursive call downwards
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);

        // All the processing of the subtrees done, now return this node
        return root;
    }


    public TreeNode trimBST_iterative(TreeNode root, int L, int R) {
        if (root == null) {
            return root;
        }
        // Find a valid root which is used to return.
        while (root.val < L || root.val > R) {
            if (root.val < L) {
                root = root.right;
            }
            if (root.val > R) {
                root = root.left;
            }
        }
        TreeNode dummy = root;

        // Remove the invalid nodes from left subtree.
        while (dummy != null) {
            while (dummy.left != null && dummy.left.val < L) {
                dummy.left = dummy.left.right;
                // If the left child is smaller than L, then we just keep the right subtree of it.
            }
            dummy = dummy.left;
        }
        dummy = root;

        // Remove the invalid nodes from right subtree
        while (dummy != null) {
            while (dummy.right != null && dummy.right.val > R) {
                dummy.right = dummy.right.left;
                // If the right child is biggrt than R, then we just keep the left subtree of it.
            }
            dummy = dummy.right;
        }
        return root;
    }
}
