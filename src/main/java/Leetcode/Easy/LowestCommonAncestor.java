package Leetcode.Easy;

import Leetcode.ParentClasses.Tree;
import Leetcode.Templates.TreeNode;

public class LowestCommonAncestor extends Tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
    // Neetcode - https://www.youtube.com/watch?v=gs2LMfuOR9k
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	    // Means both the nodes are to the left
        if(root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        // Means both the nodes are to the right
        else if(root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        else {
            return root;
        }
    }

    // Another approach... if r-p * r-q is negative, then it is the root
    public TreeNode lowestCommonAncestor2R(TreeNode root, TreeNode p, TreeNode q) {

	    // Ideally if (root.val - p.val) * (root.val - q.val) < 0, Then both p and q are on the different sides and we return the root as its the LCA
        // But there's a corner case when root is one of the p or q itself. In that case, the product will be zero. We want to return the root as well.
        // So we use <= 0
        return (root.val - p.val) * (root.val - q.val) <= 0 ? root :  lowestCommonAncestor2R(p.val < root.val ? root.left : root.right, p, q);
    }

}
