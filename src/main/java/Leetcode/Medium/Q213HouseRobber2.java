package Leetcode.Medium;

import java.util.Arrays;

public class Q213HouseRobber2 {

	public static void main(String[] args) {
		Q213HouseRobber2 obj = new Q213HouseRobber2();

	}
	
	// https://leetcode.com/discuss/36770/9-lines-0ms-o-1-space-c-solution
	// Neetcode - https://www.youtube.com/watch?v=rWAJCfYYOvM
	// Leetcode - https://leetcode.com/problems/house-robber-ii/description/
	public int rob(int[] nums) {
		return Math.max(nums[0], Math.max(helper(Arrays.copyOfRange(nums, 1, nums.length)), helper(Arrays.copyOfRange(nums, 0, nums.length - 1))));
	}

	private int helper(int[] nums) {
		int rob1 = 0, rob2 = 0;

		for (int n : nums) {
			int newRob = Math.max(rob1 + n, rob2);
			rob1 = rob2;
			rob2 = newRob;
		}
		return rob2;
	}
}
