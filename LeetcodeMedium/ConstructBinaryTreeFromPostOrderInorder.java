package LeetcodeMedium;

public class ConstructBinaryTreeFromPostOrderInorder {

	// http://www.programcreek.com/2013/01/construct-binary-tree-from-inorder-and-postorder-traversal/
	// O(n^2)
	public static void main(String[] args) {
		ConstructBinaryTreeFromPostOrderInorder Obj = new ConstructBinaryTreeFromPostOrderInorder();
		int[] postorder = {4,5,2,6,7,8,3,1};
		int[] inorder = {4,2,5,1,6,7,3,8};
		TreeNode root = Obj.buildTree(inorder, postorder);
		System.out.println(root.val);
	}

	

	public TreeNode buildTree(int[] inorder, int[] postorder) {
        preIndex = postorder.length - 1;
        TreeNode root = helper(inorder, postorder, 0, inorder.length-1);
		return root;
    }
    
    int preIndex = 0;
	
	public TreeNode helper(int[] inOrder, int[] preOrder, int inStart, int inEnd)
	{
		// Base case
		if(inStart > inEnd) 
			return null;

		// Pick up the current node from PreOrder traversal
		TreeNode node = new TreeNode(preOrder[preIndex]);

		// Increase the preorder pointer so that it can be used for the LST recursive calls
		preIndex--;

		// Else find the index of this node in InOrder traversal
		// LST will be on the left side of it, RST will be on the right side of it
		int inIndex = Search(inOrder, inStart, inEnd, node.val);

		/* Using index in Inorder traversal, construct left and right subtress */
		node.right = helper(inOrder, preOrder, inIndex+1, inEnd);
		node.left = helper(inOrder, preOrder, inStart, inIndex-1);

		return node;

	}

	/* Function to find index of value in arr[start...end]
	   The function assumes that value is present in in[] */
	public int Search(int[] inorder, int start, int end, int val)
	{
		for (int i = start; i <= end; i++) 
		{
			if(inorder[i] == val)
				return i;
		}
		return 0;
	}

}
