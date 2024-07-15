package Leetcode.Medium;

import Leetcode.Templates.TreeNode;

import java.util.*;

public class BinaryTreeInorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeInorderTraversal Obj = new BinaryTreeInorderTraversal();
	}

	// https://www.youtube.com/watch?v=nzmtCFNae9k
    // Same template as -
    // Kth Smallest Element in a BST
    // Validate Binary Search Tree
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.empty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }

}
