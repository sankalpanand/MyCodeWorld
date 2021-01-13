package Leetcode.Medium;

import Leetcode.Templates.TreeNode;

import java.util.*;

public class BinaryTreeInorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeInorderTraversal Obj = new BinaryTreeInorderTraversal();
	}

	// https://www.youtube.com/watch?v=nzmtCFNae9k
    public List<Integer> inorderTraversal(TreeNode root){
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        List<Integer> result = new ArrayList<>();

        while(true) {
            // As long as you're getting the node, keep going left
            if(node != null){
                stack.addFirst(node);
                node = node.left;
            }

            // At this point, there's no more left.
            else{
                if(stack.isEmpty()) {
                    break;
                }

                // Pop from the stack
                node = stack.pollFirst();

                // Add it to result
                result.add(node.val);

                // Go to the right of this node
                node = node.right;
            }
        }

        return result;
    }

	public List<Integer> inorderTraversal1(TreeNode root) 
    {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        
        // Go on as long as there is a node at current OR there are elements in stack
        while(curr != null || !stack.isEmpty())
        {
            // As soon as curr is null, break the loop and pop from the stack
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
