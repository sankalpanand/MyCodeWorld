package Leetcode.Medium;

import Leetcode.Templates.TreeNode;

import java.util.Stack;

public class Q230KthSmallestElementInABst {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Explanation- https://www.youtube.com/watch?v=5LUXSvjmGCw
	// Code taken from https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/#
	public int kthSmallest(TreeNode root, int k) {

		Stack<TreeNode> s = new Stack<>();
		TreeNode curr = root;

		// Traverse the tree
		while (curr != null || s.size() > 0) {

			// Reach the left most Node of the curr Node
			while (curr !=  null) {
				// Place pointer to a tree node on the stack before traversing the node's left subtree
				s.push(curr);
				curr = curr.left;
			}

			// Current must be NULL at this point, so get the last pushed element
			curr = s.pop();
			k--;

			if (k == 0)
				return curr.val;


			System.out.print(curr.val + " ");

			// we have visited the node and its left subtree.
			// Now, it's right subtree's turn
			curr = curr.right;
		}

		return -1;
	}

	// Same template as -
	// 1. Binary Tree Inorder Traversal
	// 2. Validate Binary Search Tree
	public int kthSmallest2(TreeNode root, int k) {
		Stack<TreeNode> stack = new Stack<>();
		while(root != null || !stack.isEmpty()) {
			while(root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			if(--k == 0)
				break;
			root = root.right;
		}
		return root.val;
	}

}
