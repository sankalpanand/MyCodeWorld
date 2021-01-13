package Leetcode.Easy;

import java.util.*;

public class ContainsDuplicate1 {

	public static void main(String[] args) 
	{
		// int[] nums = {1,1,2,2,2,2,2,3,4,5,6,2,2,2};

		int[] nums = {1,2,3,4,5,6,7,8,1};
		System.out.println(containsDuplicate(nums));
	}

	/* Find if the array contains any duplicates */
	// Possible solutions- https://discuss.leetcode.com/topic/14730/possible-solutions

    // Time complexity: O(N), memory: O(N)
    public static boolean containsDuplicate(int[] nums)
	{
		HashSet<Integer> set = new HashSet<Integer>();
		
		for(int num : nums)
		{
			if(!set.add(num))
				return true;
		}
		return false;
    }

    // Time complexity: O(N^2), memory: O(1)
    public boolean containsDuplicate1(int[] nums) {

        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    // Time complexity: O(N log N), memory: O(1) - not counting the memory used by sort
    public boolean containsDuplicate2(int[] nums) {

        Arrays.sort(nums);
        for(int ind = 1; ind < nums.length; ind++) {
            if(nums[ind] == nums[ind - 1]) {
                return true;
            }
        }
        return false;
    }



}
