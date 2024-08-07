package Leetcode.Medium;

import Leetcode.Templates.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q107BTLevelOrder2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		

	}

	// Leetcode - https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
	
	// Same as the first one, only difference being we add value at index 0
	public List<List<Integer>> levelOrderBottom1(TreeNode root) {
		
		List<List<Integer>> tree = new ArrayList<List<Integer>>();
        if(root == null) return tree;
        
        
        List<Integer> level;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        
        while(queue.size() != 0) {
            level = new ArrayList<Integer>();
            int size = queue.size();
            
            
            for(int i = 0; i < size; i++) {
                if(queue.peek().left != null)
                	queue.add(queue.peek().left);
                if(queue.peek().right != null)
                	queue.add(queue.peek().right);
                level.add(queue.poll().val);
            }
            
            tree.add(0, level);
        }
        
        return tree;
    }
	
	// Second Solution Recursive
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
	    List<List<Integer>> list = new ArrayList<>();
	    traverse(list, 0 , root);
	    return list;
	}

	private void traverse(List<List<Integer>> list, int level, TreeNode node)
	{
	    if(node == null) return;
	    if(list.size() - 1 < level) list.add(0, new ArrayList<Integer>());
	    list.get(list.size() - level - 1).add(node.val);
	    traverse(list, level + 1, node.left);
	    traverse(list, level + 1, node.right);
	}

}
