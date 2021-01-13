package Leetcode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSets2 {

	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		int nums[] = {1,2};
		System.out.println(subsetsWithDup(nums));
		System.out.println();
	}
	
	// Refer to the visualization here-
    // https://leetcode.com/discuss/9213/my-solution-using-bit-manipulation
    public static List<List<Integer>> subsetsWithDup1(int[] nums) 
	{
		Arrays.sort(nums);
		int len = nums.length;
		int totalSubsets = (int) Math.pow(2, len); // For n=3, it will give 8
		// OR => int totalSubsets = 1 << len;

		List<List<Integer>> resultSet = new ArrayList<List<Integer>>(totalSubsets);

		for (int i = 0; i < totalSubsets; i++) // It will generate binary of 0-7. This will be our rows.
		{
			List<Integer> subset = new ArrayList<Integer>();
			for (int j = 0; j < len; j++) // It will generate numbers in the string one by one. It will be our columns.
			{
			    // Now check status of each bit in i (0-7). For a 3 digit binary number,
			    // i >> 0 will give the status of the last bit
			    // i >> 1 will give the status of the middle bit
			    // i >> 2 will give the status of the left most bit
			    // Therefore, i >> j will give-
			    // whether 0th bit should be present or not
			    // whether 1th bit should be present or not
			    // whether 2th bit should be present or not
			    // Each Bit in a 3 digit binary number will denote the status of {1,2,3}.
			    // Whenever, a bit should be present, form a set out of it.
				int pushIthBitToLast = i >> j;
				int iThBitPresent = pushIthBitToLast & 1;
				if (iThBitPresent != 0) 
				{
					subset.add(nums[j]);
				}				
			}
			
		    // -------------------------------------------------------
		    // This is the only change from previous solution
		    // -------------------------------------------------------
			if(!resultSet.contains(subset))
			{
				resultSet.add(subset);
			}
		}
		return resultSet;
	}
	
	// Complexity- 2^n
    // https://leetcode.com/discuss/46668/recursive-iterative-manipulation-solutions-explanations
    // http://www.programcreek.com/2013/01/leetcode-subsets-java/
    public static List<List<Integer>> subsetsWithDup(int[] nums) 
	{
    	if (nums == null)
    		return null;
     
    	Arrays.sort(nums);
     
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
     
    	for (int i = 0; i < nums.length; i++) {
    		List<List<Integer>> temp = new ArrayList<List<Integer>>();
    		
    		
    		// Since we will be adding items one by one to the existing ones, get the existing items.
    		for (List<Integer> a : result) 
    		{
    			temp.add(new ArrayList<Integer>(a));
    		}
     
    		// add S[i] to existing sets which are now in temp
    		for (List<Integer> a : temp) 
    		{
    			a.add(nums[i]);
    		}
     
    		// add S[i] only as a set
    		ArrayList<Integer> single = new ArrayList<Integer>();
    		single.add(nums[i]);
    		temp.add(single);
            
            // add S[i] to existing sets which are now in temp
    		for (List<Integer> a : temp) 
    		{
    			if(!result.contains(a))
    			{
    			    result.add(a);
    			}
    		}
    		
    	}
     
    	//add empty set
    	result.add(new ArrayList<Integer>());
     
    	return result;
	}

}
