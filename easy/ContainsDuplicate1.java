package easy;

import java.util.*;

public class ContainsDuplicate1 {

	public static void main(String[] args) 
	{
		// int[] nums = {1,1,2,2,2,2,2,3,4,5,6,2,2,2};

		int[] nums = {1,2,3,4,5,6,7,8,1};
		System.out.println(containsNearbyDuplicate(nums));
	}

	/* Find if the array contains any duplicates */
    public static boolean containsNearbyDuplicate(int[] nums) 
	{
		HashSet<Integer> set = new HashSet<Integer>();
		
		for(int num : nums)
		{
			if(!set.add(num))
				return true;
		}
		
		return false;       
        
    }
}
