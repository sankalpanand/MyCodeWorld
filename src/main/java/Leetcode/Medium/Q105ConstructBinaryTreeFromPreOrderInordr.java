package Leetcode.Medium;

import Leetcode.Templates.TreeNode;

public class Q105ConstructBinaryTreeFromPreOrderInordr {

	// Leetcode - https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
	// Neetcode - https://www.youtube.com/watch?v=ihj4IQGZ2zc
	public static void main(String[] args) {
		Q105ConstructBinaryTreeFromPreOrderInordr obj = new Q105ConstructBinaryTreeFromPreOrderInordr();
		int[] preorder = {1,2};
		int[] inorder = {2,1};
		TreeNode root = obj.buildTree(preorder, inorder);
	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder.length == 0 || inorder.length == 0) {
			return null;
		}
		return buildTreeHelper(preorder, inorder, 0, 0, inorder.length - 1);
	}

	private TreeNode buildTreeHelper(int[] preorderArr, int[] inorderArr, int preStart, int inStart, int inEnd) {
		if (preStart > preorderArr.length - 1 || inStart > inEnd) {
			return null;
		}

		// First element of the pre-order will always be the root
		TreeNode root = new TreeNode(preorderArr[preStart]);
		int rootIndexInInorder = findIndexFromInorder(inorderArr, inStart, inEnd, preorderArr[preStart]);
		// Everything to the left of rootIndexInInorder will be LST => 	inStart to rootIndexInInorder - 1
		// and everything on the right will be RST => 					rootIndexInInorder + 1 to inEnd

		// Once we are done creating the root and its LST and RST from the preorder array, we need to store the next root also.
		// We'll use preStart and send it down to the LST and RST so that they know where to pick their root node from.

		// preStart + 1 => because we found the root above at preStart
		// We also need to pass inorder until mid, so we pass inStart and rootIndexInInorder - 1
		root.left = buildTreeHelper(preorderArr, inorderArr, preStart + 1, inStart, rootIndexInInorder - 1);

		// In PreOrder, its Root -> Left -> Right.
		// So its complicated to find out where does the right starts
		// We can get the immediate right child index by skipping all the node on the left branches/subtrees of current node
		// The inorder array has this information exactly. Remember when we found the root in "inorder" array we immediately know how many nodes are on the left subtree and how many are on the right subtree
		// numsOnLeft = rootIndexInInorder - inStart (size of root's left subtree)
		// immediate right child index = preStart + numsOnLeft + 1 (root)
		root.right = buildTreeHelper(preorderArr, inorderArr, preStart + rootIndexInInorder - inStart + 1, rootIndexInInorder + 1, inEnd);

		return root;
	}

	private int findIndexFromInorder(int[] inorder, int inStart, int inEnd, int rootVal) {
		int inIndex = 0; // Index of the current root in inorder

		for (int i = inStart; i <= inEnd; i++) {
			if (inorder[i] == rootVal) {
				inIndex = i;
				break;
			}
		}

		return inIndex;
	}
}
