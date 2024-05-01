package Leetcode.Medium;
import java.util.*;

public class ContainsDuplicates3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// difference between nums[i] and nums[j] is at most t and 
	// the difference between i and j is at most k.
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) 
	{
		if(nums == null || k < 0 || t < 0)
			return false;

		TreeSet<Integer> window = new TreeSet<>();

		for(int i = 0; i < nums.length; i++)
		{
			// Remove values that slipped out of the sliding window
			if(i - k - 1 >= 0)
			{
				window.remove(nums[i - k - 1]);
			}

			int n = nums[i];

			// Ceiling : Returns the least element in this set greater than or equal to the given element, or null if there is no such element.
			// Floor : Returns the greatest element in this set less than or equal to the given element, or null if there is no such element
			Integer floor = window.floor(n); 
			Integer ceiling = window.ceiling(n); 

			// it is same as saying n-floor <= t && ceiling-n <= t. But it gives overflow error, so we're using this.
			if(floor != null && n <= t + floor ||  
					ceiling != null && ceiling <= t + n)
				return true;

			window.add(n);
		}
		return false;
	}

}
