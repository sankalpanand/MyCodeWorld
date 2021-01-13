package Leetcode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,1};

		List<List<Integer>> result = combinationSum3(3,9);
		for(List<Integer> set : result)
		{
			System.out.println(Arrays.asList(set));
		}

		// System.out.println(count);

	}

	private  static List<List<Integer>> solution;
	private static List<Integer> curSolution;

	// It will start by fixing 1 and then trying out all different combinations of 1-9 at second place and then go deeper at 3rd place.
	public static List<List<Integer>> combinationSum3(int k, int n) 
	{
		solution = new ArrayList<List<Integer>>();
		curSolution = new ArrayList<Integer>();
		backTrack(k, n); 
		return solution;
	}

	private static void backTrack(int k, int n) 
	{
		if (curSolution.size() == k && n == 0) 
		{
			solution.add(new ArrayList<>(curSolution));
		}		

		if(curSolution.size() < k) 
		{
			int start=0;
			if(curSolution.size() == 0)
				start = 1;
			else
				start = curSolution.get(curSolution.size()-1) + 1;				
			
			for(int i=start; i<=9; i++)
			{				
				if(n-i<0)
					break;
				
				curSolution.add(i);
				backTrack(k, n-i);
				curSolution.remove(curSolution.size() - 1);     
			}            
		}
	}

}
