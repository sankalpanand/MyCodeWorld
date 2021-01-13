package Leetcode.Hard;

public class SearchInRotatedSortedArray2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// https://www.youtube.com/watch?v=uufaK2uLnSI
	public int search(int[] nums, int target) {
        if(nums.length == 1)
        {
            if(nums[0] == target) return 0;
            else return -1;
        }
        
        int high = nums.length -1;
        int low = 0;
        
        
        while(low <= high)
        {
            int mid = (low+high)/2;
            if(nums[mid] == target)
                return mid;
                
            if(nums[mid] < nums[high])
            {
                if(nums[mid] < target && target <= nums[high])
                {
                    low = mid + 1;
                }
                else
                {
                    high = mid;
                }
            }
            
            else // if(nums[mid] > nums[high]) // => It means left part is sorted
            {
                if(nums[low] <= target && target < nums[mid])
                {
                    high = mid;
                }
                else
                {
                    low = mid + 1;
                }
            }          
            
        }
        
        return -1;
    }

}
