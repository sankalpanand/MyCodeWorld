package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {

		int[] nums = {3,2,4};
		int[] res = twoSum(nums, 6);
		System.out.println(Arrays.toString(res));
	}


	// O(n)
	public int[] twoSum2(int[] nums, int target) 
	{
		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for(int i=0; i<nums.length; i++)
		{
			if(map.containsKey(target - nums[i]))
			{
				result[0] = map.get(target - nums[i]);
				result[1] = i+1;
				return result;
			}

			map.put(nums[i], i+1);
		}

		return result;
	}
	
	// This is O(n) time and O(1) space but I can not give back indices
	public static int[] twoSum(int A[], int sum)
	{
		int n = A.length;
	    int l=0;
	    int r=n-1;
	    
	    int[] result = new int[2];
	 
	    /* Sort the elements */
	    Arrays.sort(A);
	 
	    /* Now look for the two candidates in the sorted array*/
	    
	    while (l < r)
	    {
	         if(A[l] + A[r] == sum)
	         {
	        	 result[0] = l+1;
	        	 result[1] = r+1;
	        	 return result;
	         }
	               
	         else if(A[l] + A[r] < sum)
	              l++;
	         else // A[i] + A[j] > sum
	              r--;
	    }    
	    
	    return result;
	}

	// Naive approach O(n^2)
	public int[] twoSum99(int[] nums, int target) 
	{
		int a, b;
		int[] result = new int[2];

		for(int i=0; i<nums.length; i++)
		{
			a = i; 
			b = -1;
			int rem = target - nums[i];

			for(int j=i+1; j<nums.length; j++)
			{
				if(j != i && nums[j] == rem)
				{
					b = j;
				}
			}

			if(b != -1)
			{
				result[0] = a < b ? a+1 : b+1;
				result[1] = a > b ? a+1 : b+1;
			}
		}

		return result;
	}
}
