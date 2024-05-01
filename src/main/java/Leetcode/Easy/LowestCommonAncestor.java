import Leetcode.ParentClasses.Tree;
import Leetcode.Templates.TreeNode;

public class LowestCommonAncestor extends Tree {

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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        else if(root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        else {
            return root;
        }
    }

    // Stefan Pochmann approach
    // Walk down from the whole tree's root as long as both p and q are in the same subtree
    // To do that check if their values are BOTH smaller or BOTH greater than root's.
    // This walks straight from the root to the LCA, not looking at the rest of the tree, so it's pretty much as fast as it gets.
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        while ((root.val - p.val) * (root.val - q.val) > 0) {

            // Go down. Left or right?
            // If the left was smaller, you should be going down the left.
            // If the right was smaller, you should be going down the right.
            root = p.val < root.val ? root.left : root.right;
        }

        return root;
    }

    public TreeNode lowestCommonAncestor2R(TreeNode root, TreeNode p, TreeNode q) {

	    // Ideally if (root.val - p.val) * (root.val - q.val) < 0, Then both p and q are on the different sides and we return the root as its the LCA
        // But there's a corner case when root is one of the p or q itself. In that case, the product will be zero. We want to return the root as well.
        // So we use <= 0
        return (root.val - p.val) * (root.val - q.val) <= 0 ? root :  lowestCommonAncestor2R(p.val < root.val ? root.left : root.right, p, q);
    }

}
