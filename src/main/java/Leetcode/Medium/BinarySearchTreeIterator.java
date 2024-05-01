package Leetcode.Medium;

import Leetcode.Templates.TreeNode;

import java.util.Stack;

public class BinarySearchTreeIterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// https://leetcode.com/problems/binary-search-tree-iterator/discuss/52526/Ideal-Solution-using-Stack-(Java)

    private final Stack<TreeNode> stack;

    public BinarySearchTreeIterator(TreeNode root) {
        stack = new Stack<>();
        TreeNode cur = root;

        // Left jaate jaao
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();

        // Traversal cur node's right branch
        TreeNode cur = node.right;

        while (cur != null){
            stack.push(cur);
            cur = cur.left;
        }

        return node.val;
    }

}
