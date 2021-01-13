package Leetcode.Easy;

public class MinimumDepthOfBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// My dirty solution
	public int minDepth(TreeNode root) {
		
		// Base case when a leaf node is reached
        if(root == null) return 0;
        
        // Too avoid considering a node with a single child as a leaf node
        if(root.left == null) return 1 + minDepth(root.right); 
        if(root.right == null) return 1 + minDepth(root.left);
        
        // For a normal node with both the children
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

}
