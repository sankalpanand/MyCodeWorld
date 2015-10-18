package easy;

public class Atoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myAtoi("2314");

	}
	
	public static int myAtoi(String str) 
	{
		int sign = 1, total = 0;
	    
		// 1. Check if the string is empty
	    if(str.length() == 0) return 0;

	    //2. Check until what index spaces are there. If there is space at n'th location, then we need to start from n+1'th location.
	    int index = 0;
	    while(str.charAt(index) == ' ' && index < str.length())
	        index ++;

	    //3. Handle signs
	    if(str.charAt(index) == '+' || str.charAt(index) == '-')
	    {
	        sign = str.charAt(index) == '+' ? 1 : -1;
	        index ++;
	    }

	    //4. Convert number and avoid overflow
	    while(index < str.length())
	    {
	    	// Calculate the integer equivalent of the char digit by takinng relative difference between the number and '0' which is 48 
	        int digit = str.charAt(index) - '0';
	        
	        // If the difference is out of the bounds, it means that the char is not a digit. Break out of the loop
	        if(digit < 0 || digit > 9) break;

	        //check if total will be overflow after 10 times and add digit
	        // Integer.MAX_VALUE/10 < total && Integer.MAX_VALUE %10 < digit
	        // The above condition will check that the generated digit will be less than maximum value after X10
	        // And the digit we're gonna add is also less than last digit of MAX which is 7, so no overflow will occur if we add it to the number
	        if(Integer.MAX_VALUE/10 < total || Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE %10 < digit)
	            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

	        total = 10 * total + digit;
	        index ++;
	    }
	    
	    return total * sign;
	}

}
