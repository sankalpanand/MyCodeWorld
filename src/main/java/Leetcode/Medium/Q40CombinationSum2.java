package Leetcode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q40CombinationSum2 {

	public static void main(String[] args) {
		Q40CombinationSum2 obj = new Q40CombinationSum2();
		List<List<Integer>> result;

//		int[] nums = {10,1,2,7,6,1,5};
//		List<List<Integer>> result = obj.combinationSum2(nums, 8);

		int[] nums2 = {1, 0, -1, 2, -1, 4};
		result = obj.combinationSum2(nums2, 2);

		for(List<Integer> set : result)
		{
			System.out.println(Arrays.asList(set));
		}
		
		// System.out.println(count);

	}

	// Solution taken from Permutations-
	// https://leetcode.com/problems/permutations/solutions/18239/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partioning/
	public List<List<Integer>> combinationSum2(int[] nums, int target) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(list, new ArrayList<>(), nums, target, 0);
		return list;

	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
		if(remain < 0)
			return;
		else if (remain == 0)
			list.add(new ArrayList<>(tempList));
		else {
			for(int i = start; i < nums.length; i++) {

				if (i > start && nums[i] == nums[i-1])
					continue; // skip duplicates

				tempList.add(nums[i]);
				backtrack(list, tempList, nums, remain - nums[i], i + 1);
				tempList.remove(tempList.size() - 1);
			}
		}
	}

}
