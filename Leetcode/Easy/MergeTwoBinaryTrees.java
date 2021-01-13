package Leetcode.Easy;

public class MergeTwoBinaryTrees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	1. If both trees are empty then we return empty.
    2. Otherwise, we will return a tree. The root value will be t1.val + t2.val, except these values are 0 if the tree is empty.
    3. The left child will be the merge of t1.left and t2.left, except these trees are empty if the parent is empty.
    4. The right child is similar.
	 */

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) {
            return null;
        }
        int sum = (t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val);
        TreeNode newNode = new TreeNode(sum);
        newNode.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        newNode.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);
        return newNode;
    }

}


