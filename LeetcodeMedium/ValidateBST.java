package LeetcodeMedium;

public class ValidateBST {

	public static void main(String[] args) 
	{

	}

	// Works for node = MAX, MIN
	public boolean isValidBST(TreeNode root) 
	{
		return helper(root, null, null);
	}

	boolean helper(TreeNode root, Integer min, Integer max) 
	{
		// Step 1- Check for root being null
		if (root == null)
			return true;

		// Step 2- Check for root's value being in range
		if ((min != null && root.val <= min) || (max != null && root.val >= max))
			return false;

		// Step 3- Recur
		// Left wale ke liye max root ki value ho jayegi
		return helper(root.left, min, root.val) && helper(root.right, root.val, max);
	}

	// Your solution can not pass this case:[ Long.MINVALUE , null , Long.MAXVALUE ]
	public boolean isValidBST2(TreeNode root) 
	{
		return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	public boolean isValidBST(TreeNode root, long minVal, long maxVal) 
	{

		if (root == null) return true;
		if (root.val >= maxVal || root.val <= minVal) return false;
		return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
	}


	// InOrder traversal
	TreeNode invalidNode = new TreeNode(Integer.MAX_VALUE);

	public boolean isValidBST3(TreeNode root) {
		return isValidBST(root, null) != invalidNode;
	}

	public TreeNode isValidBST(TreeNode node, TreeNode prev) 
	{
		if(node == null) 
			return prev;

		prev = isValidBST(node.left, prev);

		if( prev != null && node.val <= prev.val ) 
			return invalidNode;

		// For sending the recursive call to the right, current will become previous
		return isValidBST(node.right, node);
	}

}
