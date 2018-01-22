package LeetcodeEasy;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

	public static void main(String[] args) {

		int[] nums = {0,1,2,4,5,7};
		// int[] nums = {0,3,5};

		List<String> list = summaryRanges(nums); 

		System.out.println(list);
	}

	public static List<String> summaryRanges(int[] nums) {

		int start = 0;
		int end = 0;

		List<String> result = new ArrayList<String>();
		if(nums.length == 0) return result;

		for(int i=1; i<nums.length; i++)
		{
			if(nums[i] == nums[i-1] + 1)
			{
				end = i;
			}
			else // Sequence toot gayi
			{
				AddToResult(result, nums, start, end);
				start = i;
				end = i;
			}
		}

		AddToResult(result, nums, start, end);
		return result;
	}

	public static void AddToResult(List<String> result, int[] nums, int start, int end)
	{
		String seq = null;
		if(start != end) seq = nums[start] + "->" + nums[end];
		else if(start == end) seq = nums[start]+ "";
		result.add(seq);
	}

}
