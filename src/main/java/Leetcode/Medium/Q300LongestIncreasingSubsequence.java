package Leetcode.Medium;

import java.util.ArrayList;
import java.util.Arrays;

public class Q300LongestIncreasingSubsequence {

	public static void main(String[] args) {
		Q300LongestIncreasingSubsequence lis = new Q300LongestIncreasingSubsequence();
		// int nums[] = {23,10,22,5,33,8,9,21,50,41,60,80,99, 22,23,24,25,26,27};
		int[] nums = {10,9,2,5,3,7,101,18};
		System.out.println(lis.lengthOfLIS(nums));

		nums = new int[] {0,1,0,3,2,3};
		System.out.println(lis.lengthOfLIS(nums));

		nums = new int[] {1, 2, 4, 3};
		System.out.println(lis.lengthOfLIS(nums));
	}

	// Neetcode - https://www.youtube.com/watch?v=cjWnW0hdF1Y
	// Leetcode - https://leetcode.com/problems/longest-increasing-subsequence/
	// O(n ^ 2)
	public int lengthOfLIS(int[] nums) {
		int[] map = new int[nums.length];
		Arrays.fill(map, 1);

		for(int i=nums.length - 1; i >= 0; i--) {
			for (int j= i+1; j < nums.length; j++) {
				if(nums[i] < nums[j]) {
					map[i] = Math.max(map[i], 1 + map[j]);
				}
			}
		}

		return Arrays.stream(map).max().getAsInt();
	}

	// Gajab explanation of a O (n log n) approach
	// https://leetcode.com/problems/longest-increasing-subsequence/solutions/1326308/c-python-dp-binary-search-bit-segment-tree-solutions-picture-explain-o-nlogn/
	public int lengthOfLIS2(int[] nums) {
		ArrayList<Integer> res = new ArrayList<>(nums.length);

		for(int i  =0 ; i < nums.length; i++) {
			if(res.isEmpty() || nums[i] > res.get(res.size()-1)) {
				res.add(nums[i]);
			} else {
				int smallestElementGreaterThanX = findSmallestElement(res, nums[i]);
				res.set(smallestElementGreaterThanX, nums[i]);
			}
		}
		return res.size();
	}

	public int findSmallestElement(ArrayList<Integer> res, int tar)
	{
		int left = 0;
		int right = res.size()-1;

		while(left < right) {
			int mid = (left + right)/2;

			if( res.get(mid) < tar) {
				left = mid+1;
			} else {
				right = mid;
			}
		}
		return left;
	}
}
