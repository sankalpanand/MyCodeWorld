package Leetcode.Easy;
import Leetcode.Templates.TreeNode;

public class Q572SubtreeOfAnotherTree {
    // Leetcode - https://leetcode.com/problems/subtree-of-another-tree/
    // Neetcode - https://www.youtube.com/watch?v=E36O5SWp-LE

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (isSame(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;

        if (s.val != t.val) return false;

        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}
