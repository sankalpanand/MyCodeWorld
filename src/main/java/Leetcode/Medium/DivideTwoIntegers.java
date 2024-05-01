package Leetcode.Medium;

public class DivideTwoIntegers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(divide(91,13));

	}
	
	public static int divide(int dividend, int divisor)
    {
        if (divisor == 0)
        {
            return Integer.MAX_VALUE;
        }
        else if (divisor == 1)
        {
            return dividend;
        }
        else if (divisor == -1)
        {
            return (dividend == Integer.MIN_VALUE) ? Integer.MAX_VALUE : -dividend;
        }
        else
        {
            boolean negative = (dividend > 0 ^ divisor > 0) == true;

            long ldividend = Math.abs((long) dividend);
            long ldivisor = Math.abs((long) divisor);
            
            int result = 0;

            for (int bit = Integer.SIZE - 1; bit >= 0 && ldividend >= ldivisor; bit--)
            {
            	// Divisor ko tab tak 31, 30, 29... bits se shift karte jaao jab tak wo dividend se chhota nahi ho jaata
                if (ldividend >= (ldivisor << bit))
                {
                	// Jaise hi wo shift karne ke baad agar chhota hone lage, to usko dividend mein se ghata do
                	ldividend = ldividend - (ldivisor << bit);
                	
                	// Result ko utni hi bits se shift kar do
                	result = result | 1 << bit;
                }
            }

            return negative ? -result : result;
        }
    }

}
