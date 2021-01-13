package Leetcode.Easy;

public class RangeSumQuery {

	public static void main(String[] args) 
	{
		int[] nums = {-2,0,3,-5,2,-1}; // sumRange(0,2),sumRange(2,5),sumRange(0,5)
		NumArray N = new NumArray(nums);
		System.out.println(N.sumRange(2,4));

	}

	public static class NumArray 
	{
		int[] nums;

		public NumArray(int[] nums) 
		{
			for(int i = 1; i < nums.length; i++)
				nums[i] += nums[i - 1];

			this.nums = nums;
		}

		public int sumRange(int i, int j) 
		{
			if(i == 0)
				return nums[j];

			// i-1 because, i is inclusive
			return nums[j] - nums[i - 1];
		}
	}

}
