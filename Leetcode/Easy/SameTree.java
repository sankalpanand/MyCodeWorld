package Leetcode.Easy;

import java.util.Stack;

public class SameTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// Recursive
	public boolean isSameTreeR(TreeNode p, TreeNode q) 
    {
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        if(p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    
    public boolean isSameTree(TreeNode p, TreeNode q) 
    {
        if(p==null && q==null) return true;
        else if(p==null || q==null) return false;
        
        Stack<TreeNode> stack_p = new Stack<TreeNode>();
        Stack<TreeNode> stack_q = new Stack<TreeNode>();
        stack_p.push(p);
        stack_q.push(q);
        
        while(stack_p.size() != 0 && stack_q.size() != 0)
        {
            TreeNode temp_p = stack_p.pop();
            TreeNode temp_q = stack_q.pop();
            if(temp_p.val != temp_q.val) return false;
            
            if(temp_p.left != null) stack_p.push(temp_p.left);
            if(temp_q.left != null) stack_q.push(temp_q.left);
            if(stack_p.size() != stack_q.size()) return false;
            
            if(temp_p.right != null) stack_p.push(temp_p.right);
            if(temp_q.right != null) stack_q.push(temp_q.right);
            if(stack_p.size() != stack_q.size()) return false;
            
        }
        
        return true;
        
    }

}
