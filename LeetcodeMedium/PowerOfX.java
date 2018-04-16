package LeetcodeMedium;

public class PowerOfX {

	public static void main(String[] args) {
		System.out.println(myPow(2.00000d, -2147483648));
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
                return x * x * myPow( x * x, n / 2 );
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
		
		while(n>0)
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

}
