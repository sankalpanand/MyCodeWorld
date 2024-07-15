package Leetcode.Medium;

public class Q209MinimumSizeSubarraySum {

	public static void main(String[] args) {
		Q209MinimumSizeSubarraySum obj = new Q209MinimumSizeSubarraySum();
		int arr1[] = {1, 4, 4};
		int x = 4;

		//	    int arr1[] = {1,2,3,4,5};
		//	    int x = 11;
		System.out.println(obj.minSubArrayLen(x, arr1));
	}

	// Neetcode - https://www.youtube.com/watch?v=aYqYMIqZx5s
	// Leetcode - https://leetcode.com/problems/minimum-size-subarray-sum/description/
	public int minSubArrayLen(int target, int[] nums) {

		int l = 0, total = 0;
		int res = Integer.MAX_VALUE;

		for (int r = 0; r < nums.length; r++) {
			total += nums[r];
			while (total >= target) {
				res = Math.min(res, r - l + 1);
				total -= nums[l];
				l++;
			}
		}

		return res == Integer.MAX_VALUE ? 0 : res;
	}

}
