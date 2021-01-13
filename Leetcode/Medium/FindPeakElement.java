package Leetcode.Medium;

public class FindPeakElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,1};
		System.out.println(findPeakElement(nums));
	}

	// Sequential logic O(n)
	public int findPeakElement1(int[] nums) 
	{
		for(int i=1; i<nums.length; i++)
		{
			if(nums[i] < nums[i-1]) 
				return i-1;
		}

		return nums.length - 1;
	}

	/*
	 * 	Case 1: If num[i-1] < num[i] > num[i+1], then num[i] is peak
	Case 2: If num[i-1] < num[i] < num[i+1], then num[i+1...n-1] must contains a peak
	Case 3: If num[i-1] > num[i] > num[i+1], then num[0...i-1] must contains a peak
	If num[i-1] > num[i] < num[i+1], then both sides have peak (n is num.length)
	 * */
	public static int findPeakElement(int[] nums) 
	{
		return helper(nums, 0, nums.length - 1);
	}

	public static int helper(int[] nums, int low, int high)
	{
		if(low == high)
			return low;

		else if(low+1 == high)
		{
			if(nums[low] > nums[high])
				return low;
			else
				return high;
		}

		else
		{
			int mid = (low + high)/2;

			// Case 1:
			if((nums[mid] > nums[mid+1]) && (nums[mid] > nums[mid-1]))
				return mid;

			// Case 2:
			else if((nums[mid-1] < nums[mid]) && (nums[mid] < nums[mid+1]))
				return helper(nums, mid+1, high);

			// Case 3:
			else
				return helper(nums, low, mid-1);

		}
	}

}
