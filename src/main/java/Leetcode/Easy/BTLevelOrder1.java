package Leetcode.Easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTLevelOrder1 {

	/* Given a binary tree, return the level order traversal of its nodes' values. */
	
	public static void main(String[] args) 
	{
	}
	
	// The idea is to take size of a queue before enqueuing new elements. 
    // Any element present in the queue before inserting left and right child is on the same level.
	public List<List<Integer>> levelOrder(TreeNode root) {
		
		List<List<Integer>> tree = new ArrayList<List<Integer>>();
        if(root == null) return tree;
        
        
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
        
        return tree;
        
    }

}
