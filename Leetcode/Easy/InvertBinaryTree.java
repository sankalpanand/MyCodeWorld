package Leetcode.Easy;

import java.util.Stack;

public class InvertBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub



	}

	public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        while(!stack.isEmpty())
        {
            TreeNode node = stack.pop();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            
            if(node.left != null) stack.push(node.left);
            if(node.right != null) stack.push(node.right);
        }
        
        return root;
    }
    
    public TreeNode invertTreeR(TreeNode root) {

		// 268 ms
		if(root == null) return null;

		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;

		invertTree(root.left);
		invertTree(root.right);

		return root;

		/*if(root == null) return null;
        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;*/
	}

}