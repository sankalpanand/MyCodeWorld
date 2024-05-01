package Leetcode.Easy;

import java.util.ArrayList;
import java.util.List;

/* Given a binary tree, return all root-to-leaf paths. */

public class BinaryTreePaths {
	List<String> paths = new ArrayList<String>();
    
	public static void main(String[] args) {
		
	}
    
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null)
            return paths;
            
        helper(root, root.val + "->");
        return paths;
        
    }
    
    public void helper(TreeNode root, String helperString)
    {
    	// If you have reached a leaf
        if(root.left == null && root.right == null)
        {
            helperString = helperString.substring(0, helperString.length() - 2);
            paths.add(helperString);
        }
        
        // Go left by appending the root value of to the string
        if(root.left != null)
        {
            helper(root.left, helperString + root.left.val + "->");
        }
        
        // Go right by appending the root value of to the string
        if(root.right != null)
        {
            helper(root.right, helperString + root.right.val + "->");
        }
    }

}
