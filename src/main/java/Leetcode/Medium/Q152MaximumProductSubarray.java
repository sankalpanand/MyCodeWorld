package Leetcode.Medium;

public class Q152MaximumProductSubarray {

	public static void main(String[] args) {
		Q152MaximumProductSubarray obj = new Q152MaximumProductSubarray();
		int nums[] = {-2, 3, -4};
		System.out.println(obj.maxProduct(nums));
	}

	// Solution taken from this comment-
	// https://leetcode.com/problems/maximum-product-subarray/solutions/48230/possibly-simplest-solution-with-o-n-time-complexity/
	// Neetcode solution was hard to understand
	// This explanation is far better - https://www.youtube.com/watch?v=keVevSvaDKo
	public int maxProduct(int[] nums) {
		// store the result that is the max we have found so far
		int maxSum = nums[0];

		// (+) the max cumulative product UP TO current element starting from SOMEWHERE in the past. It could contribute to the new minimum if the A[i] is positive.
		// (-) the minimum cumulative product UP TO current element. It could contribute to the new maximum if the A[i] is negative.
		// imax/imin represent the max/min product ended with A[i-1]
		// when it encounters A[i], it has two choices: absorb A[i] to the product or start a new continuous subarray start with A[i].
		int currentMax = nums[0];
		int currentMin = nums[0];

		for (int i = 1; i < nums.length; i++) {
			// if we see a negative number, the "candidate" for max should instead become the previous min product,
			// because a bigger number multiplied by negative becomes smaller, hence the swap()
			if (nums[i] < 0) {
				int tmp = currentMax;
				currentMax = currentMin;
				currentMin = tmp;
			}


			// at each new element, u could either add the new element to the existing product,
			// or start fresh the product from current index (wipe out previous results),
			// hence the 2 Math.max() lines.
			currentMax = Math.max(nums[i], currentMax * nums[i]);
			currentMin = Math.min(nums[i], currentMin * nums[i]);

			// the newly computed max value is a candidate for our global result
			maxSum = Math.max(maxSum, currentMax);
		}
		return maxSum;
	}
}
