package LeetcodeMedium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreePreorderTraversal Obj = new BinaryTreePreorderTraversal();
	}

	// http://www.geeksforgeeks.org/iterative-preorder-traversal/
	public List<Integer> preorderTraversal(TreeNode root) 
	{
		List<Integer> result = new ArrayList<Integer>();
		if(root == null) return result;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);

		/* Pop all items one by one. Do following for every popped item
		       a) print it
		       b) push its right child
		       c) push its left child
	        Note that right child is pushed first so that left is processed first 
	    */

		while(!stack.isEmpty())
		{
			TreeNode node = stack.pop();
			result.add(node.val);
			if(node.right != null) stack.push(node.right);
			if(node.left != null) stack.push(node.left);
		}

		return result;
	}

}
