package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicate1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int[] nums = {1,1,2,2,2,2,2,3,4,5,6,2,2,2};

		int[] nums = {1,2,3,4,5,6,7,8,1};
		System.out.println(containsNearbyDuplicate(nums));
	}

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
