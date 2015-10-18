package medium;


public class LowestCommonAncestorBT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
	{
		// If leaf node is reached, return null.
		// If either of p or q is a root, this is a LCA, return it 
		if (root == null || root == p || root == q) 
			return root;

		// Find out LCA in LST
		TreeNode left = lowestCommonAncestor(root.left, p, q);

		// Find out LCA in RST
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		// If p/q exists on left node and p/q exist on the right node as well, then we got our candidate
		if(left != null && right != null)
			return root;
		
		// If left is null, it means right would have got LCA from inner nodes 
		if(left == null)
			return right;
		else
			
			// If right is null, it means left would have got LCA from inner nodes
			return left;
			
	}

}
