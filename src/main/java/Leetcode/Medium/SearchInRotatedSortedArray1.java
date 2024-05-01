package Leetcode.Medium;

public class SearchInRotatedSortedArray1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int search(int[] nums, int target) 
	{
		// Check the edge cases
		if(nums.length == 1)
		{
			if(nums[0] == target) return 0;
			else return -1;
		}

		int high = nums.length -1;
		int low = 0;


		// Start from both the ends
		while(low <= high)
		{
			// Calculate the mid
			int mid = (low+high)/2;

			// If the number is found at the middle element, return the target
			if(nums[mid] == target)
				return mid;

			// Else check two cases-
			// If mid is less than high, it means right part is sorted and left is not sorted
			if(nums[mid] < nums[high])
			{
				// Check if the target lies in the sorted part, if yes, increase low by 1
				if(nums[mid] < target && target <= nums[high])
				{
					low = mid + 1;
				}

				// Else, target lies in the unsorted part
				else
				{
					high = mid;
				}
			}

			// Apply the same check over here. Else means that the left part is sorted and left is not
			else if(nums[mid] > nums[high]) 
			{
				// Check if the targt exists in the left sorted part or not. Accordingly update the mid.
				if(nums[low] <= target && target < nums[mid])
				{
					high = mid;
				}
				else
				{
					low = mid + 1;
				}
			}          

			// If it is reduced to one number, then nums[mid] will become equal to nums[high]
			// Simply move ahead by decrementing high
			else
			{
				high--;
			}
		}

		return -1;
	}

}
