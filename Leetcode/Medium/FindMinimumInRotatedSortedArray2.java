package Leetcode.Medium;

public class FindMinimumInRotatedSortedArray2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3};
		System.out.println(findMin(nums));
	}

	public static int findMin(int[] num) {

		if (num == null || num.length == 0) 
		{
			return 0;
		}

		if (num.length == 1) 
		{
			return num[0];
		}
		int start = 0; 
		int end = num.length - 1;
		
		while (start < end) 
		{
			int mid = (start + end) / 2;
			
			if (mid > 0 && num[mid] < num[mid - 1]) 
			{
				return num[mid];
			}
			
			if (num[start] <= num[mid] && num[mid] > num[end]) 
			{
				start = mid + 1;
			} 
			else 
			{
				end = mid - 1;
			}
		}
		
		return num[start];
	}

}
