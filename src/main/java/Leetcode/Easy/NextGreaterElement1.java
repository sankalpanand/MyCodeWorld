package Leetcode.Easy;

import java.util.*;

public class NextGreaterElement1 {
    public static void main(String[] args) {
        int[] nums1 = {4,1,2}, nums2 = {1,3,4,2};
        System.out.println(Arrays.toString(nextGreaterElement2(nums1, nums2)));
    }

    // https://discuss.leetcode.com/topic/77916/java-10-lines-linear-time-complexity-o-n-with-explanation
    // Whenever we see a number x greater than stack.peek() we pop all elements less than x and for all the popped ones, their next greater element is x
    public static int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
        Stack<Integer> stack = new Stack<>();

        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() < num)
                map.put(stack.pop(), num);

            stack.push(num);
        }
        for (int i = 0; i < findNums.length; i++)
            findNums[i] = map.getOrDefault(findNums[i], -1);

        return findNums;
    }


    // https://discuss.leetcode.com/topic/77880/simple-o-m-n-java-solution-using-stack
    public static int[] nextGreaterElement2(int[] subSet, int[] nums) {
        int[] result = new int[subSet.length];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = nums.length - 1; i >= 0; i--) {
            // Agar number stack ke top se bada hai, to stack ka top hatate jaao
            while(!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }

            if(stack.isEmpty())
                map.put(nums[i], -1);
            else
                map.put(nums[i], stack.peek());

            stack.push(nums[i]);
        }

        for(int i = 0; i < subSet.length; i++) {
            result[i] = map.get(subSet[i]);
        }

        return result;
    }
}
