package medium;

public class KthLargestElementInAnArray {

	public static void main(String[] args) {
		// int nums[] = {12, 3, 5, 7, 4, 19, 26};
		int nums[] = {9,4,3,6,1,8,2,7};
		int k = 2;
		System.out.println(findKthLargest(nums, k));


		//		int nums[] = {1,2};
		//		System.out.println(findKthLargest(nums, 1));


	}

	// http://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array/
	public static int findKthLargest(int[] nums, int k) 
	{		
		int len = nums.length;

		// We are sending k as len-k because we are for 2nd largest element in an array of size 10, we will search for 8th one. 
		return helper(nums, len-k, 0, len-1);
	}

	public static int helper(int[] nums, int searchIndex, int start, int end) 
	{

		// Step 1: Partition the array around last element and get position of pivot
		int pIndex = partition(nums, start, end);

		// Step 2: If position = k, return element
		if(pIndex == searchIndex)
		{
			return nums[pIndex];
		}

		// Step 3: pIndex usually means that all the elements lesser than it lies towards its left and the ones greater than it lie towards its right. 
		// Since the search index is less than the pIndex, the search element should be in the LHS.
		else if(pIndex > searchIndex)
		{
			return helper(nums, searchIndex, start, pIndex - 1);
		}

		// Step 4: Since the search index is more than the pIndex, the search element should be in the RHS.
		else
			return helper(nums, searchIndex, pIndex + 1, end);

	}

	// It considers the last element as the pivot
	// Moves all smaller elements to the left of it
	// Greater elements to the right of it
	public static int partition(int[] nums, int start, int end)
	{
		int pivot = nums[end];
		int pIndex = start;

		for(int i = start; i <= end-1; i++)
		{
			if(nums[i] < pivot)
			{
				swap(nums, i, pIndex);
				pIndex++;
			}
		}

		swap(nums, pIndex, end);
		return pIndex;
	}

	public static void swap(int[] nums, int a, int b)
	{
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}



}
