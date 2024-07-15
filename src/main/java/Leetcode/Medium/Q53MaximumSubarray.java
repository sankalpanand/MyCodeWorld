package Leetcode.Medium;

public class Q53MaximumSubarray {

	public static void main(String[] args) {
        Q53MaximumSubarray obj = new Q53MaximumSubarray();
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(obj.maxSubArray(nums));
	}

	// Kadane's Algorithm
    // https://www.youtube.com/watch?v=epTQfFlhQBo
    // Neetcode - https://www.youtube.com/watch?v=5WZl3MMT0Eg
    // Leetcode - https://leetcode.com/problems/maximum-subarray/
    public int maxSubArray(int[] nums) {
        int maxSub = nums[0];
        int curSum = 0;

        for (int n : nums) {
            if (curSum < 0) {
                curSum = 0;
            }
            curSum += n;
            maxSub = Math.max(maxSub, curSum);
        }

        return maxSub;
    }

}
