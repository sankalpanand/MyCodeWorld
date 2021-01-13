package Leetcode.Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum2 {

	public static void main(String[] args) {

		int[] nums = {2, 7, 11, 15};
		int[] res = twoSum(nums, 9);
		System.out.println(Arrays.toString(res));
	}

	// Same hashmap solution from TwoSum will work with incrementing the getCellIndex by 1
	public static int[] twoSum(int[] nums, int target)
	{
		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<>();

		for(int i=0; i<nums.length; i++)
		{
			int numberToFind = target - nums[i];
			if(map.containsKey(numberToFind))
			{
				result[0] = map.get(numberToFind)+1;
				result[1] = i+1;
				return result;
			}

			map.put(nums[i], i);
		}

		return result;
	}

	public static int[] twoSum1(int A[], int sum)
	{
		int start = 0;
		int end = A.length - 1;

		int[] result = new int[2];

		/* Now look for the two candidates in the sorted array */
		while (start < end)
		{
			if(A[start] + A[end] == sum)
			{
				result[0] = start+1;
				result[1] = end+1;
				return result;
			}

			else if(A[start] + A[end] < sum)
				start++;

			else // A[i] + A[j] > sum
				end--;
		}

		return result;
	}
}
