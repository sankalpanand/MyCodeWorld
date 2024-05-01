package Leetcode.Hard;

public class FindMinimumInRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3};
		System.out.println(findMin(nums));
	}

	public static int findMin(int[] nums) {

		int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        
        while(start < end)
        {
            mid = start + (end-start)/2;
            
            if(nums[mid] > nums[end])
            	start = mid + 1;
            
            // We can not say end = mid -1 because this case is also possible [3,1,3]
            else if(nums[mid] < nums[end])
            	end = mid;
            else
            	// We are not sure whether the position will be on left or right, 
            	// so we just reduce the high
            	// Consider [1, 0, 1, 1, 1] and [1, 1, 1, 0, 1]
            	end--;
        }
        
        return nums[start];
	}

}
