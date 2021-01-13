package Leetcode.Medium;

public class Sqrt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(mySqrt(2147395599));
	}

	// Newton Method
	public static int mySqrt(int original)
	{
		// It has to be long because we are calculating its product while checking
		long guess = original;
		int count=0;
	    while (guess * guess > original)
	    {
	        guess = (guess + original/guess) / 2;
	        count++;
	    }
	    System.out.println(count);
	    return (int) guess;
	}
	
	
	// Newton Method - With Precision
	public static float mySqrt(float num)
	{
		float guess = num;
		float original = num;
		float closeness = 1;

		// Set the precision
		float precision = 0.000001f;

		// with each iteration, guess will go down from num and y will go up from 1.
		// And they continue doing so until the precision is met 
		// If I do not update y, the while loop will not exit
		while(guess - closeness > precision)
		{
			guess = (guess + original/guess)/2;
			closeness = original / guess;
			System.out.println(closeness + "\t" + guess);
		}
		return guess;
	}
	
	// Other efficient log n solutions- bit manipulation 
	public static int mySqrt2(int x) 
	{
		long ans = 0;
		
		// Set bit as 16 bit 1 followed by 0s
		long bit = 1 << 16;
		
		// With every iteration, we are going to shift bit to right by 1
		// Continue this until bit is reduced to 0
		while(bit > 0) 
		{
			ans = ans | bit;
			
			if (ans * ans > x) 
			{
				ans = ans ^ bit;
			}
			else if(ans * ans == x)
			{
				break;
			}
			
			bit = bit >> 1;
		}
		
		return (int)ans;
	}
	
	public int mySqrt3(int x) 
	{
		if (x == 0)
			return 0;
		
		long left = 1;
		long right = x;
		
		while (true) 
		{
			long mid = (left + right)/2;
			
			if (mid * mid > x) 
			{
				right = mid - 1;
			} 
			else 
			{
				if ((mid + 1) * (mid + 1) > x)
					return (int) mid;
				left = mid + 1;
			}
		}
	}

}
