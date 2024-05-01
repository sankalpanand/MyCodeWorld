package Leetcode.Medium;

import Leetcode.Templates.Node;
import Leetcode.Templates.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class LowestCommonAncestorOfABinaryTree4 {

    TreeNode LCA;
    HashSet<Integer> set = new HashSet<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        this.LCA = root;
        for (TreeNode n : nodes)
            set.add(n.val);

        traverse(root);

        return this.LCA;
    }

    public boolean traverse(TreeNode node) {
        if (node == null)
            return false;

        if (set.contains(node.val)) {
            this.LCA = node;
            return true;
        }

        boolean left = traverse(node.left);
        boolean right = traverse(node.right);

        // Left mein bhi hai, right mein bhi hai, to ye to definitely LCA hai. Update karo.
        if (left && right) {
            this.LCA = node;
            return true;
        }

        return false;
    }
}
