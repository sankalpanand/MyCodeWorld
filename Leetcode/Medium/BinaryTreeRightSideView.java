package Leetcode.Medium;

import Leetcode.Templates.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class BinaryTreeRightSideView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> rightSideView(TreeNode root) {

		// The idea is to return the last element in level order traversal 
		List<List<Integer>> tree = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		if(root == null) return list;


		List<Integer> level;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);

		while(queue.size() != 0)
		{
			level = new ArrayList<Integer>();
			int size = queue.size();

			for(int i = 0; i < size; i++)
			{
				if(queue.peek().left != null) queue.add(queue.peek().left);
				if(queue.peek().right != null) queue.add(queue.peek().right);
				level.add(queue.poll().val);
			}

			tree.add(level);
		}

		for(List<Integer> level1 : tree)
		{
			list.add(level1.get(level1.size() -1 ));
		}

		return list;
	}

}


