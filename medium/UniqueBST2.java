package medium;

import java.util.LinkedList;
import java.util.List;

public class UniqueBST2 {

	public static void main(String[] args) 
	{
		System.out.println(generateTrees(5));
	}

	// http://www.geeksforgeeks.org/construct-all-possible-bsts-for-keys-1-to-n/
	public static List<TreeNode> generateTrees(int n) 
	{
		return generateSubtrees(1, n);
	}

	private static List<TreeNode> generateSubtrees(int start, int end) 
	{
		List<TreeNode> res = new LinkedList<TreeNode>();

		// BASE CASE
		if (start > end) 
		{
			res.add(null); // empty tree
			return res;
		}

		// Now we need to construct roots from i=start to n and add LSTs and RSTs to them.
		for (int i = start; i <= end; ++i) 
		{
			List<TreeNode> leftSubtrees = generateSubtrees(start, i - 1);
			List<TreeNode> rightSubtrees = generateSubtrees(i + 1, end);

			// Create a tree for every pair of left and right subtree and add the tree to list
			for (TreeNode left : leftSubtrees) 
			{
				for (TreeNode right : rightSubtrees) 
				{
					TreeNode root = new TreeNode(i);
					root.left = left;
					root.right = right;
					res.add(root);
				}
			}
		}
		return res;
	}

}
