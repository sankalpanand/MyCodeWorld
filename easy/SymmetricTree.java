package easy;

import java.util.Stack;

public class SymmetricTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Non recursive using stack
    public boolean isSymmetric1(TreeNode root) 
    {
    	if (root == null)
            return true;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.isEmpty()) 
        {
            TreeNode right = stack.pop();
            TreeNode left = stack.pop();
            
            // Agar dono mein se kahi chid hai, tabhi aage badho
            if(right != null || left != null)
            {
                // Agar ek khali hai to symmetry toot gayi
                // Dono khali nahi ho sakte because wo just upar check kiya hai
                if (right == null || left == null)
                    return false;
                
                // Agar values hi different hain, to bhi symmetry toot gayi
                if (right.val != left.val)
                    return false;
                    
                // Sequence really matters here because we are going to compare the outer nodes with each other 
                // and inner nodes with each other
                stack.push(left.right);
                stack.push(right.left);
                
                stack.push(left.left);
                stack.push(right.right);
            }
        }
        return true;
    }
    
    // The idea is to compare the LST and inverted RST
	public boolean isSymmetric(TreeNode root) {
		if(root == null) return true;
		return mirrorEquals(root.left, root.right);
	}

	public boolean mirrorEquals(TreeNode left, TreeNode right) 
	{
		// Agar dono null hain, to match hai. Return true.
		if(left == null && right == null) 
		{
			return true;
		}

		// Agar koi ek null ho gaya hai, to symmetry toot gayi.
		else if(left == null || right == null) 
		{
			return false;
		}

        // Agar dono mein values hain, magar wo alag hain to bhi symmetry toot gayi
		if(left.val != right.val)
			return false;


		// Yahan tak sab kuchh sahi hai... ab bachho ko check karna start karo
		return mirrorEquals(left.left, right.right) && mirrorEquals(left.right, right.left);
	}
}
