package LeetcodeMedium;

import java.util.Stack;

public class BinarySearchTreeIterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	Stack<TreeNode> stack = new Stack<TreeNode>();

    public BinarySearchTreeIterator(TreeNode root) {
        refreshStack(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(stack.isEmpty()) return false;
        else return true;
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        refreshStack(node.right);
        return node.val;
    }
    
    public void refreshStack(TreeNode root)
    {
        if(root == null) return;
        while(root != null)
        {
            stack.push(root);
            root = root.left;
        }
    }

}
