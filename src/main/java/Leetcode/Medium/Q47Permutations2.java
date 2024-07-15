package Leetcode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q47Permutations2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Q47Permutations2 obj = new Q47Permutations2();
		int[] nums = {1,1,2};
		System.out.println(obj.permuteUnique(nums));
	}

	// Solution taken from Permutations 1
	// Similar explanation-
	// https://www.youtube.com/watch?v=YW5F0WqBBWY

	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
		return list;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, boolean [] used){
		if(tempList.size() == nums.length) {
			list.add(new ArrayList<>(tempList));
		} else {
			for(int i = 0; i < nums.length; i++) {
				// In Permutations 1, we relied on `tempList.contains(nums[i])` to skip this iteration.
				// We can't do that in Permutation 2 because if the number is already added to the list, we would still want to add it could be a duplicate number
				// So we need to find a way to tell that the same number 1a has been used but 1b has not been used.
				// For that we are using a boolean array.

				// if an element is already used in the permutation, we skip it OR
				// if an element equals to the element before it and the element before this element is not used in the permutation yet, we also skip it because that'll be duplicate
				// https://leetcode.com/problems/permutations/solutions/18239/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partioning/comments/680610

				// Another explanation (best)-
				// https://leetcode.com/problems/permutations/solutions/18239/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partioning/comments/149966
				if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1])
					continue;

				used[i] = true;
				tempList.add(nums[i]);
				backtrack(list, tempList, nums, used);
				used[i] = false;
				tempList.remove(tempList.size() - 1);
			}
		}
	}
}
