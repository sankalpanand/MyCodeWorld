package Leetcode.Easy;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] num = {1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(num));

    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int count = 0;

        for (int num : nums) {
            if (num == 1) {
                count++;
                result = Math.max(count, result);
            } else {
                count = 0;
            }

        }

        return result;
    }

    // One optimization - no need to update result on 1s
    public static int findMaxConsecutiveOnes_optimized(int[] nums) {
        int result = 0;
        int count = 0;

        for (int num : nums) {
            if (num == 1) {
                count++;

            } else {
                result = Math.max(count, result);
                count = 0;
            }

        }

        return Math.max(count, result);
    }

}
