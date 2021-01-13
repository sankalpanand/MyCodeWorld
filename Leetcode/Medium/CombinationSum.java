package Leetcode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,3,6,7};

		List<List<Integer>> result = combinationSum(nums, 7);
		for(List<Integer> set : result)
		{
			// System.out.println(Arrays.asList(set));
		}

	}

	// https://www.youtube.com/watch?v=s6FhG--P7z0
	private  static List<List<Integer>> solution;
	private static List<Integer> curSolution;
	private static int count=0;

	/*
	 * Condition 1: Array needs to be in sorted order. This helps us to reduce the number of recursions.
	 * We fix first number, and try out with ALL possibilities for the next digits in a recursive fashion.
	 * Whenever a combnation meets the sum, we add it to the result, 
	 * If it doesn't, then we remove it from our local set.
	 * */
	public static List<List<Integer>> combinationSum(int[] candidates, int target) 
	{
		solution = new ArrayList<List<Integer>>();
		curSolution = new ArrayList<Integer>();
		Arrays.sort(candidates);
		backTrack(candidates, target, 0); 
		return solution;
	}

	private static void backTrack(int[] candidates, int target, int lastIdx) 
	{
		count++;
		
		if (target == 0) 
		{
			solution.add(new ArrayList<>(curSolution));
		}
		else if (target < 0) 
		{
			return;
		}

		else 
		{            
			for(int i=lastIdx; i<candidates.length; i++)
			{
				int candidate = candidates[i];
				curSolution.add(candidate);
				System.out.println(Arrays.asList(curSolution));
				backTrack(candidates, target - candidate, i);
				curSolution.remove(curSolution.size() - 1);     
			}            
		}
	}

}
