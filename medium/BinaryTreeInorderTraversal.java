package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeInorderTraversal Obj = new BinaryTreeInorderTraversal();
	}
	
	public List<Integer> inorderTraversal1(TreeNode root) 
    {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;
        
        // Go on as long as there is a node at current OR there are elements in stack
        while(curr != null || !stack.isEmpty())
        {
            while(curr != null)
            {
                stack.push(curr);
                curr = curr.left;
            }
            
            TreeNode node = stack.pop();
            result.add(node.val);
            
            // This will take care of the RST of any nodes which will be pushed onto stack in the next iteration
            curr = node.right;
        }
        
        return result;
    }

}
