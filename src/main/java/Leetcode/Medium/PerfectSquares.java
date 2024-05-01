package Leetcode.Medium;

public class PerfectSquares {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numSquares(12));
	}
	
	public static int numSquares(int n) 
	{
	    int[] min = new int[n+1];
	    min[1] = 1;
	    
	    // We keep track of the numbers for every integer until n
	    for(int i=2; i<=n; i++)
	    {
	        int tmp = Integer.MAX_VALUE;
	        
	        // Start the loop from j=1 till j*j becomes greater than i
	        for(int j=1; j*j <= i; j++)
	        {
	        	// Suppose, we count j*j towards sum.
	        	// Then the remaining number of digits will come from [i - j*j].
	        	// For example, n=13. Then j becomes 3. Then i - j*j = 4. 
	        	// Now we want to know how many digits are required to reach 4.
	        	// Additional 1 because we know the number of digits till its previous number,
	        	// for this one, it is just additional 1.
	        	// For 6, it will be Min(min[5]+1 , min[2]+1)
	            tmp = Math.min(tmp, min[i-j*j] + 1);
	        }
	        min[i] = tmp;
	    }
	    return min[n];
	}

}
