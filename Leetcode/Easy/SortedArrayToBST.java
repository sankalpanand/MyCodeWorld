package Leetcode.Easy;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SortedArrayToBST {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7,8,9,10};
	}

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

        int mid = (low + high) / 2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = helper(num, low, mid - 1);
        node.right = helper(num, mid + 1, high);
        return node;
    }


    private static class MyNode {
        TreeNode node;
        int leftBound, rightBound;
        public MyNode(TreeNode node, int left, int right) {
            this.node = node;
            this.leftBound = left;
            this.rightBound = right;
        }
    }

    // Iterative version
    public static TreeNode sortedArrayToBST_Iterative_DFS(int[] nums) {
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

    public TreeNode sortedArrayToBST_Iterative_BFS(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;

        Queue<MyNode> queue = new LinkedList<>();
        int left = 0;
        int right = nums.length - 1;
        int val = nums[left + (right - left) / 2];
        TreeNode root = new TreeNode(val);
        queue.offer(new MyNode(root, left, right));

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {

                MyNode cur = queue.poll();
                int mid = cur.leftBound + (cur.rightBound - cur.leftBound) / 2;
                cur.node.val = nums[mid];

                if (cur.leftBound < mid) {
                    cur.node.left = new TreeNode(0);
                    queue.offer(new MyNode(cur.node.left , cur.leftBound, mid - 1));
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
