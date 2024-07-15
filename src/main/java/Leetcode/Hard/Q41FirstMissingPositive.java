package Leetcode.Hard;

import java.util.Arrays;

public class Q41FirstMissingPositive {

    public static void main(String[] args) {
        int[] nums = {4,-1,-3, 2, 1};
        int res = Q41FirstMissingPositive.firstMissingPositive(nums);
        System.out.println(res);
    }

    // Neetcode - https://www.youtube.com/watch?v=8g78yfzMlao
    // Leetcode -
    // https://leetcode.com/problems/first-missing-positive/discuss/17214/Java-simple-solution-with-documentation
    public static int firstMissingPositive(int[] nums) {
        System.out.println("Original Array:\t\t" + Arrays.toString(nums));
        int len = nums.length;

        // 1. mark numbers (num < 0) and (num > len) with a special marker number (len+1)
        // (we can ignore those because if all number are > len then we'll simply return 1)
        for (int i = 0; i < len; i++) {
            if (nums[i] <= 0 || nums[i] > len) {
                nums[i] = len + 1;
            }
        }
        // note: all number in the array are now positive, and on the range 1..len+1
        System.out.println("After first iteration:\t\t" + Arrays.toString(nums));

        // 2. mark each cell appearing in the array, by converting the index for that number to negative
        for (int i = 0; i < len; i++) {
            int num = Math.abs(nums[i]);
            if (num > len) {
                continue;
            }
            num--; // -1 for zero index based array (so the number 1 will be at pos 0)
            if (nums[num] > 0) { // prevents double negative operations
                nums[num] = -1 * nums[num];
            }
        }

        System.out.println("After second iteration:\t\t" + Arrays.toString(nums));

        // 3. find the first cell which isn't negative (doesn't appear in the array)
        for (int i = 0; i < len; i++) {
            if (nums[i] >= 0) {
                return i + 1;
            }
        }

        // 4. no positive numbers were found, which means the array contains all numbers 1..len
        return len + 1;
    }
}
