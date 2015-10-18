package easy;

import java.util.Stack;

public class SymmetricTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// The idea is to compare the LST and inverted RST
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return mirrorEquals(root.left, root.right);
    }
    
    public boolean mirrorEquals(TreeNode left, TreeNode right) {
      if(left == null || right == null) return left == null && right == null;
      return left.val == right.val && mirrorEquals(left.left, right.right) && mirrorEquals(left.right, right.left);
    }
    
    // Non recursive using stack
    public boolean isSymmetric1(TreeNode root) {
    	if (root == null)
            return true;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.isEmpty()) {
            TreeNode node1 = stack.pop();
            TreeNode node2 = stack.pop();
            if (node1 == null && node2 == null)
                continue;
            if (node1 == null || node2 == null)
                return false;
            if (node1.val != node2.val)
                return false;
            stack.push(node1.left);
            stack.push(node2.right);
            stack.push(node1.right);
            stack.push(node2.left);
        }
        return true;
    }
}
