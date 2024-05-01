package Leetcode.Medium;

import java.util.Arrays;

public class SortColor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,2};
		sortColors(nums);
		System.out.println(Arrays.toString(nums));

	}

	// Given an array with n objects colored red, white or blue, 
	// sort them so that objects of the same color are adjacent, 
	// with the colors in the order red, white and blue.	
	public static void sortColors(int[] nums) 
	{
		if(nums.length <= 1) return;

		int zeros = 0;
		int twos = nums.length - 1;
		for (int i=0; i<=twos; )
		{
			// We will shift all the zeros towards left
			if(nums[i] == 0)
			{
				swap(nums, i, zeros);
				zeros++;
				i++;
			}

			// We will shift all the twos towards right
			// We need not do i++ in this case. 
			// Because if the number which we are bringing from the back happens to be 0, by i++ it will be skipped and 0 will remain in the middle always.
			else if(nums[i] == 2)
			{
				swap(nums, i, twos);
				twos--;

			}
			else
				i++;

		}
	}

	public static void swap(int[] nums, int i, int j) 
	{
		// You can not use fancy way here. That method doesn't work for the same indexes.
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}
