package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicate2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,1,2,2,2,2,2,3,4,5,6,2,2,2};
		
		// int[] nums = {1,2,3,4,5,6,7,8,1};
		System.out.println(containsNearbyDuplicate(nums, 2));
	}

	// Using Hash Map- Keep adding the number and their index in the hash map. 
    // If the number already exists, you will get its previous index.
    // Check the difference between the prev Index and the current i.
	public static boolean containsNearbyDuplicate(int[] nums, int k) 
	{
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

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
	
    public static boolean containsNearbyDuplicate1(int[] nums, int k) 
	{
		Set<Integer> set = new HashSet<Integer>();

		for(int i = 0; i < nums.length; i++)
		{
			// Discard the elements that are out of the window. We don't need them. We'll go out of for loop and return false.
			if(i > k) 
				set.remove(nums[i-k-1]);

			boolean ifFirstTime = set.add(nums[i]); // true for first time, false for second time

			// Check for false. It would mean that the element is there in the set.
			if(!ifFirstTime) 
				return true; // return true
		}
		return false;
	}
}


