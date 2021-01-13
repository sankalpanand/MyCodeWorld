package Leetcode.Medium;

public class SearchInRotatedSortedArray2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// https://www.youtube.com/watch?v=uufaK2uLnSI
	public boolean search(int[] nums, int target) 
	{
		if(nums.length == 1)
		{
			if(nums[0] == target) return true;
			else return false;
		}

		int high = nums.length -1;
		int low = 0;


		while(low <= high)
		{
			int mid = (low+high)/2;
			if(nums[mid] == target)
				return true;

			// If it is the normal case, mid < high then investigate further
			if(nums[mid] < nums[high])
			{
				// If the target is in the right side, increase low
				if(nums[mid] < target && target <= nums[high])
				{
					low = mid + 1;
				}
				
				// If the target is in the left side, update mid
				else
				{
					high = mid;
				}
			}

			// If it is the rotated case, mid < high then investigate further
			else if(nums[mid] > nums[high]) // => It means left part is sorted
			{
				// If the target is in the left side, update high
				if(nums[low] <= target && target < nums[mid])
				{
					high = mid;
				}
				// If the target is in the right side, increase low
				else
				{
					low = mid + 1;
				}
			}

			// The codeschool solution doesn't work in the case of duplicates. That is why this else loop here.
			else
			{
				high--;
			}
		}

		return false;
	}

}
