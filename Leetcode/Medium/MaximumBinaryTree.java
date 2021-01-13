package Leetcode.Medium;

import Leetcode.Templates.TreeNode;

import java.util.LinkedList;

public class MaximumBinaryTree {

    public static void main(String[] args) {
        int[] nums = {3,2,1,6,0,5};
        System.out.println(constructMaximumBinaryTree_Recursive(nums).val);;
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        MaximumBinaryTree mbt = new MaximumBinaryTree();
        LinkedList<TreeNode> lklist = new LinkedList<>();

        for (int num : nums) {
            System.out.println("LinkedList before num: " + num + " is: " + mbt.toString(lklist));
            TreeNode cur = new TreeNode(num);

            // Jab tak current list ke head se bada hai, tab tak list ka head nikaalte jaao and us ko current ka left sub tree mein daal do
            // Eventually, jitne bhi elements nikaale the, un ka largest element current ke left mein rah jayega
            while (!lklist.isEmpty() && lklist.peekFirst().val < cur.val){
                cur.left = lklist.pop();
            }

            // Is point tak aate aate, current hamesha list ke head se chhota hi hoga. Us ko list ke right sub tree mein daal do.
            if (!lklist.isEmpty()){
                lklist.peekFirst().right = cur;
            }

            lklist.push(cur);

            System.out.println("LinkedList after num: " + num + " is: " + mbt.toString(lklist));
            System.out.println();
        }

        return lklist.peekLast();
    }


    public String toString(LinkedList<TreeNode> lklist) {
        StringBuilder result = new StringBuilder();
        for(TreeNode item : lklist) {
            result.append(item.val + " -> ");
        }
        return result.toString();
    }

    public static TreeNode constructMaximumBinaryTree_Recursive(int[] nums) {
        if(nums == null || nums.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(nums[0]);
        for(int i = 1; i < nums.length; i++) {
            root = insert(root, new TreeNode(nums[i]));
        }
        return root;
    }

    private static TreeNode insert(TreeNode root, TreeNode node) {
        if(root == null) {
            return node;
        }
        if(node.val > root.val) {
            node.left = root;
            return node;
        }
        root.right = insert(root.right, node);
        return root;
    }
}
