package LeetcodeMedium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigZag {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
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
		
		zigzagLevelOrder(node1);
		
		
	}
	
	public static  List<List<Integer>> zigzagLevelOrder(TreeNode root) 
    {
        List<List<Integer>> sol = new ArrayList<>();
        travel(root, sol, 0);
        return sol;
    }

    private static void travel(TreeNode curr, List<List<Integer>> result, int level)
    {
    	// BASE CASE: If you have reaached the leaf node, then return
        if(curr == null) 
        	return;

        // If there are lesser number of levels in the result set then the number of level of the present row,
        // Create a new empty level and add it to result set.
        if(result.size() <= level)
        {
            List<Integer> newLevel = new LinkedList<>();
            result.add(newLevel);
        }

        // At this point, we will have a list for this level, 
        // Either newly created empty or one from siblings at the same levels
        List<Integer> collection  = result.get(level);
        
        // Check the level to determine the direction. Add the current value onto them.
        if(level % 2 == 0) 
        	collection.add(curr.val);
        else 
        	collection.add(0, curr.val);

        // Send the recursive call to both left and right child
        travel(curr.left, result, level + 1);
        travel(curr.right, result, level + 1);
    }

}
