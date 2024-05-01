package Leetcode.Medium;

public class HouseRobber2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// https://leetcode.com/discuss/36770/9-lines-0ms-o-1-space-c-solution
    public int rob(int[] nums) 
    {
        int n = nums.length;
        
        if(n==0) return 0;
        if(n==1) return nums[0];
        
        return Math.max(helper(nums, 0, n-2), helper(nums, 1, n-1));
    }
    
    public int helper(int[] nums, int start, int end) 
	{
		int ifRobbedPrevious = 0; 	// max monney can get if rob current house
	    int ifDidntRobPrevious = 0; // max money can get if not rob current house
	    
	    // We go through all the values, we maintain two counts, 1) if we rob this cell, 2) if we didn't rob this cell
	    for(int i=start; i <= end; i++) 
	    {
	    	// If we rob current cell, previous cell shouldn't be robbed. So, add the current value to previous one.
	        int currRobbed = ifDidntRobPrevious + nums[i];
	        
	        // If we don't rob current cell, then the count should be max of the previous cell robbed and not robbed
	        int currNotRobbed = Math.max(ifDidntRobPrevious, ifRobbedPrevious); 
	        
	        // Update values for the next round
	        ifDidntRobPrevious  = currNotRobbed;
	        ifRobbedPrevious = currRobbed;
	    }
	    
	    return Math.max(ifRobbedPrevious, ifDidntRobPrevious);
	}

}
