package Leetcode.Medium;


import Leetcode.Templates.TreeNode;

public class LowestCommonAncestorBT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Note - this is Binary Tree, not Binary Search Tree.
    // https://www.youtube.com/watch?v=13m9ZCB8gjw
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
	{
		// If leaf node is reached, return null.
		// If either of p or q is a root, this is a LCA, return it 
		if (root == null)
			return null;

        if(root == p || root == q) {
            return root;
        }

		// Find out LCA in LST
		TreeNode lcaInLeftSubTree = lowestCommonAncestor(root.left, p, q);

		// Find out LCA in RST
		TreeNode lcaInRightSubTree = lowestCommonAncestor(root.right, p, q);

		// I'm getting a non null node from both left and right side.
        // It means, this node right here is LCA
        if(lcaInLeftSubTree != null && lcaInRightSubTree != null) {
            return root;
        }

        // Neither of the two nodes were found in the LST or RST of this root
        if(lcaInLeftSubTree == null && lcaInRightSubTree == null) {
            return  null;
        }

		return lcaInLeftSubTree != null ? lcaInLeftSubTree : lcaInRightSubTree;
			
	}

}
