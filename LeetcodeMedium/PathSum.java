package LeetcodeMedium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(1);
		root.right = new TreeNode(1);
		
		pathSum(root, 1);
	}

	public static List<List<Integer>> pathSum(TreeNode root, int sum)
	{
		List<List<Integer>> result  = new LinkedList<List<Integer>>();
		List<Integer> currentResult  = new LinkedList<Integer>();
		pathSum(root, sum, currentResult, result);
		return result;
	}

	public static void pathSum(TreeNode root, int sum, List<Integer> currentResult,
			List<List<Integer>> result) 
	{

		// Base case, we've reached the leaf
		if (root == null)
			return;

		// The node is not null, add it to the current list
		currentResult.add(root.val);

		// We got the leaf node. The data contained by this node, equals the remaining sum.
		// We got our path
		if (root.left == null && root.right == null && sum == root.val) 
		{
			// New object should be added because we will be removing elements from the main variable
			result.add(new ArrayList<Integer>(currentResult));
			
			// don't forget to remove the last integer because we will return from this call
			// The same currentResult will be passed to its right sibling. To avoid this node being counted again, remove it.
			currentResult.remove(currentResult.size() - 1);
			return;
		} 

		// We are still mid way. Send out recursive calls to both the child with a reduced sum.
		else 
		{
			pathSum(root.left, sum - root.val, currentResult, result);
			pathSum(root.right, sum - root.val, currentResult, result);
		}
		
		// Same reason as above.
		currentResult.remove(currentResult.size() - 1);
	}

}
