package LeetcodeMedium;

public class ConstructBinaryTreeFromPreOrderInordr {

	// http://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/
	// O(n^2)
	public static void main(String[] args) {
		int[] preorder = {1,2};
		int[] inorder = {2,1};
		TreeNode root = buildTree(preorder, inorder);
	}

	

	public static TreeNode buildTree(int[] preorder, int[] inorder)
	{
		System.out.println(preIndex);
		TreeNode root = helper(inorder, preorder, 0, inorder.length-1);
		return root;
	}

	static int preIndex = 0;
	
	public static  TreeNode helper(int[] inOrder, int[] preOrder, int inStart, int inEnd)
	{
		// Base case
		if(inStart > inEnd) 
			return null;

		// Pick up the current node from PreOrder traversal
		TreeNode node = new TreeNode(preOrder[preIndex]);

		// Increase the preorder pointer so that it can be used for the LST recursive calls
		preIndex++;

		// Else find the index of this node in InOrder traversal
		// LST will be on the left side of it, RST will be on the right side of it
		int inIndex = Search(inOrder, inStart, inEnd, node.val);

		/* Using index in Inorder traversal, construct left and right subtress */
		node.left = helper(inOrder, preOrder, inStart, inIndex-1);
		node.right = helper(inOrder, preOrder, inIndex+1, inEnd);

		return node;

	}

	/* Function to find index of value in arr[start...end]
	   The function assumes that value is present in in[] */
	public  static int Search(int[] inorder, int start, int end, int val)
	{
		for (int i = start; i <= end; i++) 
		{
			if(inorder[i] == val)
				return i;
		}
		return 0;
	}

}
