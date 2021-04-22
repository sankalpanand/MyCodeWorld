package GeeksForGeeks;

public class MathOperations {

	public static void main(String[] args) 
	{
		System.out.println(Sum(8,3));
		System.out.println(multiply(8,-3));
		System.out.println(divide(8,-2));
	}

	// https://www.youtube.com/watch?v=QFq5vbSlXHU
	/*
	A	B	Sum		Carry
	0	0	0		0
	0	1	1		0
	1	0	1		0
	1	1	0		1

	So Sum = A ^ B, Carry = A & B

	XOR (x ^ y) is addition without carry. (x & y) is the carry-out from each bit. (x & y) << 1 is the carry-in to each bit.
	 */
	public static int Sum(int x, int y)
	{
		// Iterate till there is no carry
		while (y != 0)
		{
			// carry now contains common set bits of x and y
			int carry = x & y;  // From Truth table

			// Sum of bits of x and y where at least one of the bits is not set
			x = x ^ y; // From Truth table

			// Carry is shifted by one so that adding it to x gives the required sum
			y = carry << 1;
		}
		return x;
	}

    public static int AddRecursive(int x, int y)
    {
        if (y == 0)
            return x;
        else
            return AddRecursive( x ^ y, (x & y) << 1);
    }

	public static int Diff(int x, int y)
	{
		// Iterate till there is no carry
		while (y != 0)
		{
			// borrow contains common set bits of y and unset
			// bits of x
			int borrow = (~x) & y;

			// Subtraction of bits of x and y where at least
			// one of the bits is not set
			x = x ^ y;

			// Borrow is shifted by one so that subtracting it from
			// x gives the required sum
			y = borrow << 1;
		}
		return x;
	}

	public static int multiply(int x, int y)
	{
		/* 0  multiplied with anything gives 0 */
		if(y == 0)
			return 0;

		/* Add x one by one */
		if(y > 0 )
			return (x + multiply(x, y-1));

		/* the case where y is negative */
		if(y < 0 )
			return -multiply(x, -y); // We are not adding 1 to it because we are making it positive
		
		return 0;
	}
	
	public static int divide(int a, int b)
	{
	    if (a < 0) return - divide(-a, b); 
	    if (b < 0) return - divide(a, -b); 
	    
	    int result = 0;
	    while (a >= 0) 
	    {
	        a -= b;
	        result++;
	    }
	    
	    return (result - 1);
	}
	
	public static float squareRoot(float num)
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
}
