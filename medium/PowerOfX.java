package medium;

public class PowerOfX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(myPow(8.88023d, 3));
	}

	// You might wanna look at "Exponentiation by squaring" approach
    // http://stackoverflow.com/questions/101439/the-most-efficient-way-to-implement-an-integer-based-power-function-powint-int
    public double myPow1(double x, int n) {
        if(n ==0) 
            return 1;
		
		// If power is negative, then perform the same operations on inverted number
		if(n<0)
		{
			n = -n;
			x = 1/x;
		}
		
		// Now, the general recursive statement start
		double res = 0d;
		
		if(n%2 == 0)
		    res = myPow(x*x, n/2);
		else
		    // Take one part outside, then the power will again become even.
		    res = x * myPow(x * x, n/2);
		    
		return res;
    }
    
    // Iterative solution
    public static double myPow(double x, int n) {

		double res=1;
		if(n<0)
		{
			x=1/x;
			n=-n;
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
