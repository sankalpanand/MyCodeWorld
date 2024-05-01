package Leetcode.Medium;

import Leetcode.Templates.TreeNode;

public class CountCompleteTreeNodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int countNodes_TLE(TreeNode root) {
        return count(root);
    }

    public int count(TreeNode root) {
        if(root == null) {
            return 0;
        }

        return 1 + count(root.left) + count(root.right);
    }



    // https://leetcode.com/problems/count-complete-tree-nodes/discuss/61948/Accepted-Easy-Understand-Java-Solution?page=1
    public int countNodes_NoTLE(TreeNode root) {
        if(root == null)
            return 0;

        int hl=0, hr=0;

        TreeNode l=root, r=root;

        while(l != null) {
            hl++;
            l=l.left;
        }

        while(r != null) {
            hr++;
            r=r.right;
        }

        if(hl==hr)
            return (1 << hl) - 1;

        return 1+ countNodes_NoTLE(root.left) + countNodes_NoTLE(root.right);
    }
}
