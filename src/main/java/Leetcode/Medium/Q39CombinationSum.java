package Leetcode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q39CombinationSum {

	public static void main(String[] args) {
		Q39CombinationSum obj = new Q39CombinationSum();
		int[] nums = {2,3,6,7};

		List<List<Integer>> result = obj.combinationSum(nums, 7);
		for(List<Integer> set : result)
		{
			 System.out.println(Arrays.asList(set));
		}

	}

	// Common solution taken from Permutation problem -
	// https://leetcode.com/problems/permutations/solutions/18239/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partioning/
	// Leetcode - https://leetcode.com/problems/combination-sum/description/
	public List<List<Integer>> combinationSum(int[] nums, int target) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(list, new ArrayList<>(), nums, target, 0);
		return list;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start) {
		if(remain < 0)
			return;

		else if (remain == 0)
			list.add(new ArrayList<>(tempList));
		else {
			for(int i = start; i < nums.length; i++) {
				tempList.add(nums[i]);
				backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
				tempList.remove(tempList.size() - 1);
			}
		}
	}
}
