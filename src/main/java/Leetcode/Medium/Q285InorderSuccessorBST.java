package Leetcode.Medium;

import Leetcode.Easy.Q108SortedArrayToBST;
import Leetcode.Templates.TreeNode;

public class Q285InorderSuccessorBST {
    public static void main(String[] args) {
        Q285InorderSuccessorBST obj = new Q285InorderSuccessorBST();
        int[] nums = {1,4,8,10,21,34,56,61,63};
        Q108SortedArrayToBST obj2 = new Q108SortedArrayToBST();
        TreeNode root = obj2.sortedArrayToBST_Iterative_BFS(nums);
        TreeNode.printNode(root);
        System.out.println(obj.inorderSuccessor_R(root, new TreeNode(1)).val);
    }

    // https://leetcode.com/problems/inorder-successor-in-bst/solutions/72662/java-5ms-short-code-with-explanations/
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode succ = null;
        while (root != null) {
            // In this case, root can be a possible answer, so we store the root node first and call it res.
            // However, we don't know if there is anymore node on root's left that is larger than p.val.
            // So we move root to its left and check again.
            // Hindi: Agar left mein jaa rahe ho, tabhi root ko temp mein store karne ki jarurat hai.
            // Agar right mein ja rahe ho, then parent to chhota hi hoga, to yaad rakhne ki jarurat nahi hai.
            if (p.val < root.val) {
                succ = root;
                root = root.left;
            }

            // So we only need to consider root's right child, thus we move root to its right and check again.
            else
                root = root.right;
        }
        return succ;
    }

    public TreeNode inorderSuccessor_R(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }

        // The inorder successor must be in the right subtree
        if (root.val <= p.val) {
            return inorderSuccessor_R(root.right, p);
        }

        // the inorder successor could be current root, or some smaller value inside the left subtree.
        else {
            TreeNode temp = inorderSuccessor_R(root.left, p);
            return temp == null ? root : temp;
        }
    }

    public TreeNode predecessor(TreeNode root, TreeNode p) {
        if (root == null)
            return null;

        if (root.val >= p.val) {
            return predecessor(root.left, p);
        } else {
            TreeNode right = predecessor(root.right, p);
            return (right != null) ? right : root;
        }
    }
}
