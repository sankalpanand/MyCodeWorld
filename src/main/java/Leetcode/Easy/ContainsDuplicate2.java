package Leetcode.Easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicate2 {

	public static void main(String[] args) 
	{
		int[] nums = {1,1,2,2,2,2,2,3,4,5,6,2,2,2};
		
		// int[] nums = {1,2,3,4,5,6,7,8,1};
		System.out.println(containsNearbyDuplicate(nums, 2));
	}


    // Hash Map- 
    // Keep adding the number and their getCellIndex in the hash map.
    // If the number already exists, you will get its previous getCellIndex.
    // Check the difference between the prev Index and the current i.
	public static boolean containsNearbyDuplicate(int[] nums, int k) 
	{
		Map<Integer, Integer> map = new HashMap<>();

		for(int i = 0; i <  nums.length; i++) 
		{
			Integer ord = map.put(nums[i], i);

			if(ord != null && i - ord <= k)
			{
				return true;
			}
		}

		return false;
	}
	
	
	// Sliding Window- 
	// 0 1 2 3 4 5 6 || k = 3
    // Add the elements into the set as and when you move along
    // Keep on removing the elements that slip out of the window
    public static boolean containsNearbyDuplicate1(int[] nums, int k) 
	{
		Set<Integer> set = new HashSet<>();

		for(int i = 0; i < nums.length; i++)
		{
			// Discard the elements that are out of the window.
            // We don't need them. We'll go out of for loop and return false.
			if(i > k) // This is just to make sure we don't get exception at the beginning of the loop
				set.remove(nums[i-k-1]);

			boolean ifFirstTime = set.add(nums[i]); // true for first time, false for second time

			// Check for false. It would mean that the element is there in the set.
			if(!ifFirstTime) 
				return true; // return true
		}
		return false;
	}

}


