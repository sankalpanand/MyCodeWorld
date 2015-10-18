package medium;

public class SearchForRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,2};
		searchRange(nums, 2);

	}

	// https://leetcode.com/discuss/18242/clean-iterative-solution-binary-searches-with-explanation
    // Simple binary search with just one catch !!
    // mid calculation in second part
    public static int[] searchRange(int[] nums, int target) 
	{
		int i=0;
		int j= nums.length - 1;
		int[] res = {-1,-1};

		// Search for the left one
		while(i<j)
		{
			int mid = (i+j)/2;
			if(nums[mid] < target)
				i = mid+1;
			else
				j=mid;
		}

		if(nums[i] != target)
			return res;

		else
			res[0] = i;

		// Search for the right one
		j = nums.length - 1;
		while(i<j)
		{
		    // We make mid biased towards j
		    // If we remove +1, it gives TLE for [2,2], 2
		    // In order for loop to keep moving, we should make mid as right biased
			int mid = (i+j)/2 + 1; // One catch !!!
			
			if(nums[mid] > target)
				j = mid - 1;
			else
				i=mid;
		}

		res[1] = j;
		return res;

	}

}
