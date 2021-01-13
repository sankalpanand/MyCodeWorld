package Leetcode.Medium;

import Leetcode.Templates.TreeNode;

import java.util.Stack;

public class KthSmallestElement {

	// https://leetcode.com/discuss/43771/implemented-java-binary-search-order-iterative-recursive

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// https://leetcode.com/problems/kth-smallest-element-in-a-bst/discuss/63660/3-ways-implemented-in-JAVA-(Python):-Binary-Search-in-order-iterative-and-recursive
    // Binary Search (BFS)
	public int kthSmallest(TreeNode root, int k) {
		int count = countNodes(root.left);
		if (k <= count) {
			return kthSmallest(root.left, k);
		} else if (k > count + 1) {
			return kthSmallest(root.right, k-1-count); // 1 is counted as current node
		}

		return root.val;
	}

	public int countNodes(TreeNode n) {
		if (n == null) return 0;

		return 1 + countNodes(n.left) + countNodes(n.right);
	}


    // better keep these two variables in a wrapper class
    private static int number = 0;
    private static int count = 0;

    public int kthSmallest_DFS_recursive(TreeNode root, int k) {
        count = k;
        helper(root);
        return number;
    }

    public void helper(TreeNode n) {
        if (n.left != null)
            helper(n.left);

        count--;

        // Agar deep jaate jaate count zero ho chuka hai, to ye hi number hai
        if (count == 0) {
            number = n.val;
            return;
        }

        if (n.right != null)
            helper(n.right);
    }


    public int kthSmallest_DFS_Iterative(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        int count = 0;

        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);  // Just like recursion
                p = p.left;

            } else {
                TreeNode node = stack.pop();
                if(++count == k) return node.val;
                p = node.right;
            }
        }

        return Integer.MIN_VALUE;
    }

}
