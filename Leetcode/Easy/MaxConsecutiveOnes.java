package Leetcode.Easy;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] num = {1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(num));

    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
                result = Math.max(count, result);
            }
            else count = 0;
        }

        return result;
    }
}
