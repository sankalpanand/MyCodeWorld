package Leetcode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,1};

		List<List<Integer>> result = combinationSum2(nums, 1);
		for(List<Integer> set : result)
		{
			System.out.println(Arrays.asList(set));
		}
		
		// System.out.println(count);

	}

	private  static List<List<Integer>> solution;
	private static List<Integer> curSolution;

	public static List<List<Integer>> combinationSum2(int[] candidates, int target) 
	{
	    Arrays.sort(candidates);
		solution = new ArrayList<List<Integer>>();
		curSolution = new ArrayList<Integer>();
		Arrays.sort(candidates);
		backTrack(candidates, target, 0); 
		return solution;
	}

	private static void backTrack(int[] candidates, int target, int lastIdx) 
	{
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
			    // Just one line addition for II. 
			    // Array is sorted, if the two consecutive elements are same, skip it because it will lead to duplicate results in the set.
			    // i==lastIdx => For letting it go first time, otherwise, null pointer exception at i=0
			    // candidates[i] != candidates[i-1] => Our main condition
				 if(i==lastIdx || candidates[i] != candidates[i-1])
				 {
				    int candidate = candidates[i];
    				curSolution.add(candidate);
    				backTrack(candidates, target - candidate, i+1);
    				curSolution.remove(curSolution.size() - 1);     
				 }
			}            
		}
	}

}
