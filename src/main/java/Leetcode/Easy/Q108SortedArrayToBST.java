package Leetcode.Easy;


import Leetcode.ParentClasses.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import Leetcode.Templates.TreeNode;

public class Q108SortedArrayToBST extends Tree {

	public static void main(String[] args) {
//		int[] nums = {1,2,3,4,5,6,7,8,9,10};
		int[] nums = {1,4,8,10,21,34,56,61,63};
		Q108SortedArrayToBST obj = new Q108SortedArrayToBST();
		TreeNode root = obj.sortedArrayToBST_Iterative_BFS(nums);

		TreeNode.printNode(root);
	}

	// Most basic solution.
    // Video explanation
    //---------------------------------------------------------------------------
    // RECURSIVE SOLUTION
    //---------------------------------------------------------------------------
    public TreeNode sortedArrayToBST(int[] num) {
        if (num.length == 0) {
            return null;
        }
        TreeNode head = helper(num, 0, num.length - 1);
        return head;
    }

    public TreeNode helper(int[] num, int low, int high) {
        if (low > high) { // Done
            return null;
        }

        int mid = low + (high - low) / 2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = helper(num, low, mid - 1);
        node.right = helper(num, mid + 1, high);
        return node;
    }


    private static class MyNode {
        TreeNode node;
        int leftBound, rightBound;
        public MyNode(TreeNode node, int leftBound, int rightBound) {
            this.node = node;
            this.leftBound = leftBound;
            this.rightBound = rightBound;
        }
    }

    //---------------------------------------------------------------------------
    // ITERATIVE DFS SOLUTION USING STACK
    //---------------------------------------------------------------------------
    public TreeNode sortedArrayToBST_Iterative_DFS(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;

        TreeNode root = new TreeNode(0); // We start with zero as default
        Stack<MyNode> stack = new Stack<>();

        MyNode node = new MyNode(root, 0, nums.length - 1);
        stack.push(node);

        while (!stack.isEmpty()) {
            MyNode cur = stack.pop();
            int mid = cur.leftBound + (cur.rightBound - cur.leftBound) / 2;
            cur.node.val = nums[mid];

            if (cur.leftBound < mid) {
                cur.node.left = new TreeNode(0);
                stack.push(new MyNode(cur.node.left, cur.leftBound, mid - 1));
            }

            if (cur.rightBound > mid) {
                cur.node.right = new TreeNode(0);
                stack.push(new MyNode(cur.node.right, mid + 1, cur.rightBound));
            }
        }
        return root;
    }

    //---------------------------------------------------------------------------
    // ITERATIVE BFS SOLUTION USING QUEUE
    //---------------------------------------------------------------------------
    // It is basically same as DFS one but the order in which we visit the rows is different.
    // It doesn't make any difference because each node passes down a fixed set of upper and lower bounds, no matter in what order you visit them.
    public TreeNode sortedArrayToBST_Iterative_BFS(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;

        Queue<MyNode> queue = new LinkedList<>();
        int left = 0;
        int right = nums.length - 1;
        int midVal = nums[left + (right - left) / 2];
        TreeNode root = new TreeNode(midVal);
        queue.offer(new MyNode(root, left, right));

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {

                MyNode cur = queue.poll();
                int mid = cur.leftBound + (cur.rightBound - cur.leftBound) / 2;
                cur.node.val = nums[mid];

                if (cur.leftBound < mid) {
                    cur.node.left = new TreeNode(0);
                    queue.offer(new MyNode(cur.node.left, cur.leftBound, mid - 1));
                }

                if (cur.rightBound > mid) {
                    cur.node.right = new TreeNode(0);
                    queue.offer(new MyNode(cur.node.right, mid + 1, cur.rightBound));
                }
            }
        }

        return root;
    }

}
