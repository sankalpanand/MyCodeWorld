package medium;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println();

	}

	// Naive approach O(n^2)
	public int[] twoSum1(int[] nums, int target) {
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

	// O(n)
	public int[] twoSum(int[] nums, int target) {
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

}
