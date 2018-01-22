package LeetcodeEasy;

public class LowestCommonAncestor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// This is my approach. It doesn't work when the tree becomes large. Gives TLE.
	public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null || root == p || root == q) return root;
		boolean pOnLeft = exists(root.left, p);
		boolean pOnRight = exists(root.right, p);

		boolean qOnLeft = exists(root.left, q);
		boolean qOnRight = exists(root.right, q);


		if((pOnLeft & qOnRight) || (qOnLeft & pOnRight)) 	return root;
		else if(pOnLeft & qOnLeft) 							return lowestCommonAncestor(root.left, p, q);
		else if(pOnRight & qOnRight)  						return lowestCommonAncestor(root.right, p, q);
		return null;
	}


	public boolean exists(TreeNode root, TreeNode node) {
		if(root == null) return false;
		else if(root == node) return true;
		else return exists(root.left, node) || exists(root.right, node);
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
	{
		if(root == null || root == p || root == q)
		{
			return root;
		}

		TreeNode l = lowestCommonAncestor(root.left,p,q);
		TreeNode r = lowestCommonAncestor(root.right,p,q);

		// It means, something is there on the left AND something is there on the right as well. So, this root should be an ancestor.
		// E.g. [1,2,3] p=2, q=3
		if(l != null && r != null)
		{
			return root;
		}

		// Control came here, means, both the nodes fall on one side only. 
		// So, one of l & r would have extracted the LCA by now.
		// Return whichever is not null among left and right.
		return l != null ? l:r;

	}

}
