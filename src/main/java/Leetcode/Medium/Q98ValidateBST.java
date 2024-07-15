package Leetcode.Medium;

import Leetcode.Templates.TreeNode;

import java.util.List;
import java.util.Stack;

public class Q98ValidateBST {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(6)));
//		root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
		Q98ValidateBST obj = new Q98ValidateBST();
		System.out.println(obj.isValidBST_iterative(root));
	}

	// Leetcode - https://leetcode.com/problems/validate-binary-search-tree/description/
	// Neetcode - https://www.youtube.com/watch?v=s6ATEkipzow

	// Inorder
	// This solution also works for
	// 1. Inorder traversal
	// 2. K'th smallest element in BST
	public boolean isValidBST_iterative(TreeNode root) {
		if (root == null)
			return true;

		Stack<TreeNode> stack = new Stack<>();
		TreeNode pre = null;

		// If we won't keep root != null condition, then below tree will give true instead of false
		/*
				5
			   / \
			  1   4
			     / \
			    3   6


		 */

		while (root != null || !stack.isEmpty()) {
			// Keep going left left left
			while (root != null) {
//				 System.out.println("Pushing " + root.val + " on the stack");
				stack.push(root);
				root = root.left;
			}
//			 System.out.println("Popping " + stack.peek().val + " from the stack");
			root = stack.pop();
			if(pre != null && root.val <= pre.val)
				return false;

			// Remember pre for next iteration and go to the right
			pre = root;
			root = root.right;
		}
		return true;
	}

	// pre=5, process 3,

}
