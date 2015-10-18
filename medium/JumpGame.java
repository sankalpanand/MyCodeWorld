package medium;

public class JumpGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// The idea is to visit each index, maintain a count of till what point you can reach from that index.
	// That count will be the capability + the present which is i + nums[i].
	// Sometimes, the ability can be so less that using it we can not proceed pretty much further.
	// In this case, we can take the help of the fact that there might be some superstar already visited, 
	// which could provide us a bigger leap. Therefore, we need to take the max.
	
	// Hint- Do this solution on piece of paper making three rows- index, value, reachable.
	
	public boolean canJump(int[] nums) 
	{
	    int reachable = 0;
	    for (int i=0; i<nums.length; ++i) 
	    {
	        if (i > reachable) 
	        	return false;
	        
	        reachable = Math.max(reachable, i + nums[i]);
	    }
	    return true;
	}

}
