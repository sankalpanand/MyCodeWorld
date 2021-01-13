package Leetcode.Medium;

public class PowerOfX {

	public static void main(String[] args) {
		System.out.println(myPow3(2.00000d, -2147483648));
	}

	// "Exponentiation by squaring"
	// Complexity - O(log(n)+log(n))
    // https://www.programminglogic.com/fast-exponentiation-algorithms/
    public static double myPow(double x, int n) {

	    // If n=0, return 1 obviously
	    if(n ==0)
            return 1;
		
		// If power is negative, then perform the same operations on inverted number
		if(n<0)
		{
            if( n == Integer.MIN_VALUE ) {
                ++n;  // Make -2147483648 to -2147483647
                n = -n;
                x = 1/x;
                return x * x * myPow( x*x, n / 2 );
            }

			n = -n;
			x = 1/x;
		}
		
		// Now, the general recursive statement start
		double res = 0d;

		// If n is even,
		if(n%2 == 0)
		    res = myPow(x*x, n/2);

		else // If n is odd, take on x out so that rest of it becomes even
		    res = x * myPow(x * x, n/2);
		    
		return res;
    }
    
    // Iterative solution
    public static double myPow1(double x, int n) {

		double res=1;

        // If power is negative, then perform the same operations on inverted number
		if(n<0)
		{
			x = 1/x;
			n = -n;
		}
		
		while(n > 0)
		{
		    // Checking for power being odd
			if((n&1) == 1) 
			{
			    // take out one x outside
				res=res*x; 
			}
			
			// Square x
			x = x * x;
			
			// Divide n by 2
			n = n>>1; 
		}

		return res;
	}

	/* Works only if a >= 0 and b >= 0 */
	// Power without multiplication and division
	static int myPow1(int x, int n)
	{
		if (n == 0)
			return 1;

		int answer = x;
		int increment = x;
		int i, j;

		for (i = 1; i < n; i++) {

		    // First 5 times add 5, we get 25
			for (j = 1; j < x; j++) {
				answer += increment;
			}

			increment = answer;
		}

		return answer;
	}

    static int pow(int a, int b)
    {

        if (b > 0)
            return multiply(a, pow(a, b - 1));
        else
            return 1;
    }

    /* A recursive function to get x*y */
    static int multiply(int x, int y)
    {
        if (y > 0)
            return (x + multiply(x, y - 1));
        else
            return 0;
    }

    // https://leetcode.com/problems/powx-n/discuss/19546/short-and-easy-to-understand-solution/146898
	public static double myPow3(double x, int n) {
		if (n == 0) return 1;
		if (n < 0){
			x = 1/x;
			return (n %2 == 0) ? myPow3(x*x, -(n/2)) : x*myPow3(x*x, -(n/2));
		}
		return (n %2 == 0) ? myPow3(x*x, n/2) : x*myPow3(x*x, n/2);
	}

}
