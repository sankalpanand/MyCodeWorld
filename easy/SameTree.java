package easy;

import java.util.Stack;

public class SameTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if((p == null || q == null) || p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
	
	// Without using recursion. 
	public boolean isSameTree1(TreeNode p, TreeNode q) {
        Stack<TreeNode> stack_p = new Stack <> ();       
        Stack<TreeNode> stack_q = new Stack <> ();
        
        if (p != null) stack_p.push( p ) ;
        if (q != null) stack_q.push( q ) ;
        
        // As long as both the queues have some data
        while (!stack_p.isEmpty() && !stack_q.isEmpty()) 
        {
            TreeNode pn = stack_p.pop() ;
            TreeNode qn = stack_q.pop() ;
            
            if (pn.val != qn.val) return false ;
            
            // Push left nodes of both the trees. 
            // If one of them is null, then stack sizes will differ.
            if (pn.left != null) stack_p.push(pn.left) ;                        
            if (qn.left != null) stack_q.push(qn.left) ;
            if (stack_p.size() != stack_q.size()) return false ;
            
            if (pn.right != null) stack_p.push(pn.right) ;
            if (qn.right != null) stack_q.push(qn.right) ;            
            if (stack_p.size() != stack_q.size()) return false ;
        }
        
        // Control reached here, it means either one stack got empty or both got empty.
        // Check the size to determine if trees are same or not.
        return stack_p.size() == stack_q.size() ;   
    }

}
