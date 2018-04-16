package LeetcodeMedium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MaximumBinaryTree {

    public static void main(String[] args) {
        int[] nums = {3,2,1,6,0,5};
        System.out.println(constructMaximumBinaryTree(nums).val);;
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        List<TreeNode> lklist = new LinkedList<>();
        TreeNode left = null;

        for (int num : nums) {

            TreeNode cur = new TreeNode(num);

            while (!lklist.isEmpty() && lklist.peekFirst().val < cur.val){
                cur.left = lklist.pop();
            }

            if (!lklist.isEmpty()){
                lklist.peekFirst().right = cur;
            }

            lklist.push(cur);

            System.out.println("LinkedList at num: " + num + " is: " + lklist);
        }

        return lklist.peekLast();
    }
}
