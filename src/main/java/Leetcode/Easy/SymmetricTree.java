package Leetcode.Easy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SymmetricTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// My Flaw-
	// 1- I was returning True instead of continuing whenever both the popped values were null. 
	// Because of this, even null nodes were pushed on the stack and in the next time, they were returning true
	public boolean isSymmetricStack(TreeNode root) 
    {
        if(root == null) return true;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root.left);
        stack.push(root.right);
        
        while(stack.size() != 0)
        {
            TreeNode right = stack.pop();
            TreeNode left = stack.pop();
            
            if(left== null && right == null) continue; // Don't have to push anything new.
            else if(left== null || right == null) return false;
            else if(left.val != right.val) return false;
            
            stack.push(left.left);
            stack.push(right.right);
            stack.push(left.right);
            stack.push(right.left);
        }
        
        return true;
    }
    
    
    
    public boolean isSymmetricQ(TreeNode root) 
	{
		if(root == null) return true;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root.left);
		queue.offer(root.right);
		
		while(queue.size() != 0)
		{
			TreeNode left = queue.poll();
			TreeNode right = queue.poll();
			
			if(left == null && right == null) continue;
			else if(left == null || right == null) return false;
			else if(left.val != right.val) return false;
			
			queue.offer(left.left);
			queue.offer(right.right);
			
			queue.offer(left.right);
			queue.offer(right.left);
		}
		
		return true;
	}
	
    public boolean isSymmetricR(TreeNode root) 
    {
        if(root == null) return true;
        return isMirror(root.left, root.right);
    }
    
    public boolean isMirror(TreeNode left, TreeNode right)
    {
        if(left== null && right == null) return true;
        else if(left== null || right == null) return false;
        else if(left.val != right.val) return false;
        
        boolean leftResult = isMirror(left.left, right.right);
        boolean rightResult = isMirror(left.right, right.left);
        
        return leftResult && rightResult;
    }
}
