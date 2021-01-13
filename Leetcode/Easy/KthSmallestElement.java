package Leetcode.Easy;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElement {

	// https://leetcode.com/discuss/43771/implemented-java-binary-search-order-iterative-recursive

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int kthSmallest(TreeNode root, int k) 
	{
		int countLeft = count(root.left);

		if(countLeft + 1 == k)
			return root.val;
		else if(countLeft + 1 > k)
			return kthSmallest(root.left, k);
		else
			return kthSmallest(root.right, k - countLeft - 1);
	}

	public int count(TreeNode root)
	{
		if(root == null)
			return 0;

		return 1 + count(root.left) + count(root.right);
	}


	// My Solution
	public List<Integer> traversal = new ArrayList<Integer>();
	int serial;

	public int kthSmallest1(TreeNode root, int k) 
	{
		serial = k;
		inOrderTraversal(root);
		return traversal.get(k-1);
	}


	public void inOrderTraversal(TreeNode root)
	{
		if(root == null)
			return;

		inOrderTraversal(root.left);
		if(traversal.size() == serial)
		{
			return;
		}
		else
		{
			traversal.add(root.val);
		}
		inOrderTraversal(root.right);		
	}

}
