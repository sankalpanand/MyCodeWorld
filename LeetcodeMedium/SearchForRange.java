package LeetcodeMedium;

public class SearchForRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,2};
		// searchRange(nums, 2);
		
		int[] A = {1,5,5,5,6,7,8};
		System.out.println(firstGreaterEqual(A,5));

	}
	/** Given a sorted array of integers, find the starting and ending position of a given target value. */
	// https://leetcode.com/discuss/19368/very-simple-java-solution-with-only-binary-search-algorithm
    public static int[] searchRange(int[] A, int target) 
    {
        int start = firstGreaterEqual(A, target);
        if (start == A.length || A[start] != target) 
        {
            return new int[]{-1, -1};
        }
        
        int nextHigherStart = firstGreaterEqual(A, target + 1); 
        int end = nextHigherStart - 1;
        return new int[]{start, end};
    }

    // Finds the position of the first element in an ordered range that has a value greater than or equivalent to a specified value
    // Can return A.length if target is greater than A[A.length-1].
    // Same as lower_bound in C++ STL.
    private static int firstGreaterEqual(int[] A, int target) 
    {
        int low = 0, high = A.length;
        
        while (low < high) 
        {
            int mid = low + ((high - low) >> 1);
            
            // low <= mid < high
            if (A[mid] < target) 
            {
                low = mid + 1;
            } 
            else 
            {
            	// Agar pahli baar mein target mil gaya, to bhi ye guranteed nahi hai ki wahi se range start ho rahi hai.
            	// Is liye we need to keep checking left unless we reach the startin index for that continuous target

            	// Agar target nahi mila, to ye simple binary search hai... discard right half
                high = mid;
            }
        }
        return low;
    }
    
	// https://leetcode.com/discuss/18242/clean-iterative-solution-binary-searches-with-explanation
    // Simple binary search with just one catch !!
    // mid calculation in second part
    public static int[] searchRange2(int[] nums, int target) 
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
