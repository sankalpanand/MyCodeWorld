package Leetcode.Medium;

public class MaximumSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Kadane's Algorithm
    // https://www.youtube.com/watch?v=epTQfFlhQBo
    
    public static int maxSubArray(int[] A) {
        
        int maxSoFar = A[0];
        int maxEndingHere = A[0];
        
        // try Implementing it on a paper using above example and making 3 rows, best revision.
        for(int i=1; i<A.length; i++)
        {
            maxEndingHere = Math.max(maxEndingHere + A[i], A[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        
        return maxSoFar;
    }

}
