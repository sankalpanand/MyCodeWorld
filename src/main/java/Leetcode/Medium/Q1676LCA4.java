package main.java.Leetcode.Medium;

import Leetcode.Templates.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class Q1676LCA4 {

    /*
    Idea is that send a recursion down to the left and right to get how many matching nodes were there.
    When the total matched nodes become equal to the size of the node array, it means we have found LCA.
     */
    TreeNode lca = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        Set<Integer> targetNodes = new HashSet<>();
        for(TreeNode node : nodes) {
            targetNodes.add(node.val);
        }
        helper(root, targetNodes);
        return lca;
    }

    int helper(TreeNode root, Set<Integer> nodes) {
        if(root == null) return 0;
        int leftCount = helper(root.left, nodes);
        int rightCount = helper(root.right, nodes);
        int foundCount = leftCount + rightCount;
        if(nodes.contains(root.val)) {
            foundCount++;
        }
        if(foundCount == nodes.size() && lca == null) {
            lca = root;
        }

        return foundCount;
    }
}
