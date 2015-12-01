package medium;

import java.util.LinkedList;
import java.util.List;

/** Given n, generate all structurally unique BST's (binary search trees) that store values 1...n. */
public class UniqueBST2 
{

	public static void main(String[] args) 
	{
		System.out.println(generateTrees(5));
	}

	// http://www.geeksforgeeks.org/construct-all-possible-bsts-for-keys-1-to-n/
	// The idea is to maintain a list of roots of all BSTs. Recursively construct all possible left and right subtrees.
	
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

		// You have to generate all trees from 1-n. 
		// THerefore, from 1 - n, every node can possibly be a root. 
		// So, it will divide the array in two parts which will form LST and RST.
		// We are going to fix these points from stat to end one by one and will generate their LST and RST
		for (int i = start; i <= end; ++i) 
		{
			// LST = start till i
			List<TreeNode> leftSubtrees = generateSubtrees(start, i - 1);
			
			// RST = (start+1) till end
			List<TreeNode> rightSubtrees = generateSubtrees(i + 1, end);

			// Now for each i, make it as a root. Now generate all combinations of LST and RST for it.
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
