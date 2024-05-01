package Leetcode.Easy;

public class BalancedBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isBalanced(TreeNode root) 
	{
	    // height is a helper function which will return -1 in case of a disbalance.
	    // In other cases, it will return the height of the tree.
	    return height(root)!=-1;
	}

	public int height(TreeNode node)
	{
	    // Base case if the leaf is hit
		if(node == null)
			return 0;
		
		// Cheeck the height of LST using recursive call
		int leftHt =  height(node.left);
		
		// Cheeck the right height using recursive call
		int rightHt = height(node.right);
		
		// If any of the child return their height as -1, it means some inner node is at disbalance.
		if(leftHt == -1 || rightHt == -1) return -1;
		
		// If the difference between left and right > 1 then its a fail case. Return -1.
		if(Math.abs(rightHt-leftHt) > 1) return -1;
		
		// If the control fell through here, it means it's a pass case. Send the max of the left and right height.
		return 1 + Math.max(leftHt, rightHt);
	}
}
