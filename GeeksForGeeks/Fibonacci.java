import java.util.Arrays;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println(fib(4));
		System.out.println(Arrays.toString(fibDP(-1)));

	}

	// http://www.geeksforgeeks.org/program-for-nth-fibonacci-number/

	public static int[] fibDP(int n)
	{
		/* Declare an array to store Fibonacci numbers. */
		if(n<=0)
			return new int[0];

		n = n-1;
		int[] f = new int[n+1];
		int i;



		/* 0th and 1st number of the series are 0 and 1*/
		f[0] = 0;
		
		if(n==0)
			return f;
		
		f[1] = 1;

		for (i = 2; i <= n; i++)
		{
			/* Add the previous 2 numbers in the series and store it */
			f[i] = f[i-1] + f[i-2];
		}

		return f;
	}
	
	// Time Complexity - O(n)
	// Space Complexity - O(n)
	public int[] fibonacciSequence(int num)
	{
	    // Condition check for negative cases
	    if(num <= 0)
	        return new int[0];
	        
	    // Set the offset
	    num = num - 1;
	    int[] array = new int[num+1];
	    
	    
	    
	    // 0th and 1st number of the series are 0 and 1 always
	    array[0] = 0;
	    
	    // If the size is just 1, return the array from here
	    if((num+1)==1)
	        return array;
	    
	    array[1] = 1;
	    
	    // Now start generating next numbers in the sequence starting from 2
	    for(int i=2; i<=num; i++)
	    {
	        array[i] = array[i-1] + array[i-2]; // Add the previous two numbers to get the current number
	    }
	    
	    return array;    
	        
	}

	/* function that returns nth Fibonacci number */
	public static int fib(int n)
	{
		int[][] F = {{1,1},{1,0}};
		if (n == 0)
			return 0;
		power(F, n-1);
		return F[0][0];
	}

	/* Optimized version of power() in method 4 */
	public static void power(int[][] F, int n)
	{
		if( n == 0 || n == 1)
			return;

		int[][] M = {{1,1},{1,0}};

		power(F, n/2);
		multiply(F, F);

		if (n%2 != 0)
			multiply(F, M);
	}

	public static void multiply(int[][] F, int[][] M)
	{
		int x =  F[0][0]*M[0][0] + F[0][1]*M[1][0];
		int y =  F[0][0]*M[0][1] + F[0][1]*M[1][1];
		int z =  F[1][0]*M[0][0] + F[1][1]*M[1][0];
		int w =  F[1][0]*M[0][1] + F[1][1]*M[1][1];

		F[0][0] = x;
		F[0][1] = y;
		F[1][0] = z;
		F[1][1] = w;
	}
	
	

}
