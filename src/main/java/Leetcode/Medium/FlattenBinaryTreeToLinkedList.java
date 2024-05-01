package Leetcode.Medium;

import Leetcode.Templates.TreeNode;

public class FlattenBinaryTreeToLinkedList {

    /*
    Theory - https://www.youtube.com/watch?v=FsxTX7-yhOw
    Method 1 - Indorder Traversal
    Method 2 - BFS
     */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    /*
          1             curr = 1
        /  \
       2    5
      / \    \
     3   4    6

     will become

     1                  curr = 2
      \
       2
      / \
     3   4
          \
           5
            \
             6

     */

    // https://leetcode.com/problems/flatten-binary-tree-to-linked-list/discuss/37010/Share-my-simple-NON-recursive-solution-O(1)-space-complexity!
	// Step 1 - Put the right subtree next to the rightmost node on the left subtree
    // Step 2 - Make the left subtree as the right subtree
    // Step 3 - Make the left subtree null
    public void flatten(TreeNode root)
    {
        TreeNode cur = root;
        while (cur != null)
        {
            if (cur.left != null)
            {
                TreeNode last = cur.left;

                while (last.right != null)
                    last = last.right;

                last.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }

            cur = cur.right;
        }
    }
}
