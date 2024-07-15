package Leetcode.Medium;

import Leetcode.Templates.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q103BinaryTreeZigzag {

	public static void main(String[] args) {
        Q103BinaryTreeZigzag obj = new Q103BinaryTreeZigzag();
		
		/*
		 * 	3
		   / \
		  9  20
		    /  \
		   15   7
		   
		 * */
		
		
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(9);
		TreeNode node3 = new TreeNode(20);
		TreeNode node4 = new TreeNode(15);
		TreeNode node5 = new TreeNode(7);
		
		node1.left = node2;
		node1.right = node3;
		
		node3.left = node4;
		node3.right = node5;

        obj.zigzagLevelOrder(node1);
		
		
	}

    /*
        Minor tweak in level order traversal, just insert the element in the queue in reverse order when the level is odd
     */
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();

            int cnt = queue.size();
            for (int i = 0; i < cnt; i++) {
                TreeNode node = queue.poll();
                if (res.size() % 2 == 0)
                    level.add(node.val);
                else
                    level.add(0, node.val);

                if (node.left != null)
                    queue.add(node.left);

                if (node.right != null)
                    queue.add(node.right);

            }

            res.add(level);
        }
        return res;
    }
}
