package Leetcode.Medium;

import Leetcode.Easy.Q108SortedArrayToBST;
import Leetcode.Templates.TreeNode;

public class Q510InorderSuccessorBST2 {
    public static void main(String[] args) {
        Q510InorderSuccessorBST2 obj = new Q510InorderSuccessorBST2();
        Q108SortedArrayToBST obj2 = new Q108SortedArrayToBST();
        TreeNode root = new TreeNode(21);

        TreeNode n1 = new TreeNode(4);
        TreeNode n2 = new TreeNode(56);

        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(8);
        TreeNode n5 = new TreeNode(34);
        TreeNode n6 = new TreeNode(61);

        TreeNode n7 = new TreeNode(10);
        TreeNode n8 = new TreeNode(63);

        root.left = n1;
        root.right = n2;
        n1.parent = root;
        n2.parent = root;

        n1.left = n3;
        n1.right = n4;
        n3.parent = n1;
        n4.parent = n1;

        n2.left = n5;
        n2.right = n6;
        n5.parent = n2;
        n6.parent = n2;

        n4.right = n7;
        n7.parent = n4;

        n6.right = n8;
        n8.parent = n6;

        TreeNode.printNode(root);
        // System.out.println(obj.inorderSuccessor(n7));
        System.out.println(obj.inorderSuccessor(n8));
    }

    public TreeNode inorderSuccessor(TreeNode x) {
        if (x.right == null) {
            TreeNode result = x.parent;
            while (result != null && result.val < x.val) {
                result = result.parent;
            }
            return result;
        } else {
            TreeNode result = x.right;
            while (result.left != null) {
                result = result.left;
            }
            return result;
        }
    }
}
