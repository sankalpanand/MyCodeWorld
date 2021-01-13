package Leetcode.Medium;

import java.util.Arrays;

public class ThreeSumClosest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	Given an array S of n integers, find three integers in S such that the currSum is closest to a given number, target. 
	Return the currSum of the three integers. 
	You may assume that each input would have exactly one solution.	
	 */

	// https://leetcode.com/discuss/6438/a-n-2-solution-can-we-do-better
	// We can fix one element and move two pointers in the remaining array, one from front and other from back.
	public int threeSumClosest(int[] nums, int target) 
	{
		int closestSum = 0;
		int currSum=0;

		Arrays.sort(nums);

		// If less then 3 elements then return their currSum
		if(nums.length <= 3)
		{
			for (int i=0; i<nums.length; i++) 
			{
				currSum = currSum + nums[i];
			}
			return currSum;
		}

		closestSum = nums[0] + nums[1] + nums[2];
		for (int i = 0; i < nums.length - 2; i++) 
		{
			int low = i + 1; // Start right after i
			int high = nums.length - 1; // Start at the end of the array

			while (low < high) // Continue as long as low and high do not cross each other 
			{
				currSum = nums[i] + nums[low] + nums[high]; 

				// We have to take the minimum difference.
				// So we took one as initial in variable closestSum.
				// Now we will compare and update it throughout the array,
				// like a simple min and max search
				if (Math.abs(target - closestSum) > Math.abs(target - currSum))  
				{
					closestSum = currSum;
					if (closestSum == target) // We got our closest match 
						return closestSum;
				}

				// We didn't match. Lets get a little closer.
				// If the currSum was too big, then decrement high.
				// If the currSum was too small, increment low.
				if(currSum > target)
					high--;
				else
					low++;
			}

			// When the while-loop finishes, low and high would have passed each other and there's
			// no more useful combinations that we can try with this i.
		}
		return closestSum;
	}
}
