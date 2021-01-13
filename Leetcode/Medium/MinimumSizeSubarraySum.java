package Leetcode.Medium;

public class MinimumSizeSubarraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr1[] = {1, 4, 4};
		int x = 4;

		//	    int arr1[] = {1,2,3,4,5};
		//	    int x = 11;
		System.out.println(minSubArrayLen(x, arr1));
	}

	public static int minSubArrayLen1(int s, int[] nums) 
	{
		int n = nums.length;
		int minLen = n+1;

		for(int i=0; i<n; i++)
		{
			if(nums[0] >= s) return 1;
			int sum = nums[i];

			for(int j=i+1; j<n; j++)
			{
				sum = sum + nums[j];

				if(sum > s && (j-i+1 < minLen))
				{
					minLen = j-i+1;
				}
			}
		}

		return minLen;
	}

	public static int minSubArrayLen(int s, int[] nums) 
	{
		if(nums.length == 0) return 0;

		int currSum = 0;
		int start=0, end=0;
		int minLength = Integer.MAX_VALUE;

		while(end<nums.length)
		{
			// As soon as it grows greater than s, break the loop
			while(currSum < s && end<nums.length )
			{
				currSum = currSum + nums[end];
				end++;
			}

			if (currSum < s) 
				break;

			// As soon as it becomes smaller than s, break the loop    
			while(currSum >= s && start < end)
			{
				currSum = currSum - nums[start];
				start++;
			}

			// +1 because the above start++ has made it lesser than the sum, we want it to be >=
			if(end-start+1 < minLength && currSum <= s)
				minLength = end-start+1;
		}

		return minLength == Integer.MAX_VALUE ? 0 : minLength;
	}

}
