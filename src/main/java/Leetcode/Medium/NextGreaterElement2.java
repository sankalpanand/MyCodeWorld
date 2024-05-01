package Leetcode.Medium;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement2 {
    public static void main(String[] args) {
        int[] input = {1,2,1};
        int[] input2 = {5, 4, 3, 2, 1, 6};
        int[] input3 = {8, -1, 8, 2, 3};
        System.out.println(Arrays.toString(nextGreaterElements(input3)));
    }

    // The first typical way to solve circular array problems is to extend the original array to twice length, 2nd half has the same element as first half.
    // PUSH: Every incoming number's getCellIndex will be pushed on to the stack for first N runs by default
    // POP: If incoming number is greater than number at TOS getCellIndex, then keep popping
    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;

        int[] result = new int[n];
        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n * 2; i++)
        {
            int num = nums[i % n];

            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                int topOfStack = stack.pop();
                result[topOfStack] =num;
            }
            if (i < n)
                stack.push(i);
        }
        return result;
    }




}
