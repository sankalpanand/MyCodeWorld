package Leetcode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q77Combinations {

	public static void main(String[] args) {
		Q77Combinations obj = new Q77Combinations();
		List<List<Integer>> result = obj.combine(4, 2);
		for(List<Integer> list : result)
		{
			System.out.println(list);
		}
	}

	// Solution taken from Permutations-
	// https://leetcode.com/problems/permutations/solutions/18239/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partioning/
	// Also similar to the highest voted answer -
	// https://leetcode.com/problems/combinations/solutions/27002/backtracking-solution-java/
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> list = new ArrayList<>();
		List<Integer> tempList = new ArrayList<Integer>();
		backtrack(list, tempList, k, 1, n);
		return list;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int k, int start, int end) {
		if (tempList.size() == k)
			list.add(new ArrayList<>(tempList));
		else {
			// Small optimization- https://leetcode.com/problems/combinations/solutions/27002/backtracking-solution-java/comments/190987
			for (int i = start; i <= end; i++) {
				tempList.add(i);
				backtrack(list, tempList, k, i + 1, end);
				tempList.remove(tempList.size() - 1);
			}
		}
	}
}
