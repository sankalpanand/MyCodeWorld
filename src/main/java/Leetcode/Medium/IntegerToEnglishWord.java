package Leetcode.Medium;

public class IntegerToEnglishWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numberToWords(123));
	}
	
	public static String numberToWords(int num) 
	{
		// We will divide the numbers into digits of 3
	    String[] unit = { "", " Thousand", " Million", " Billion"};
	    
	    // Since it is given that the maximum number will be till 2^31 - 1, the number will be 2 147 483 647
	    // Therefore, we will require an array of size 4.
	    int[] parts = new int [4];
	    
	    // We split the number and store every 3 digits in the array
	    for(int i  = 0; i < 4; ++i)
	    {
	        parts[i] = num % 1000;
	        num /= 1000; 
	    }
	    
	    // Now, we will pass the chunks of 3 digits through helper function and start generating the string.
	    StringBuilder sb = new StringBuilder(); 
	    for(int i = 0; i < 4; ++i)
	    {
	    	// If the number is small and there is no thousands or millions, then skip that part.
	        if(parts[i] == 0) 
	        	continue;	        
	        
	        // Since the above for loop has extracted the digits from the end, we will append the generated string at the start
	        // unit will add the Thousand, Million, Billion, etc.
	        String generated = helper(parts[i]) + unit[i];
	        sb.insert(0,  generated);
	    }
	    
	    // If the helper function generated something, we remove the extra space in the beginning.
	    if(sb.length() != 0)
	    {
	    	sb.deleteCharAt(0);
	    	return sb.toString();
	    }
	    
	    // The helper function returned zero for all the passed digits, it means the number was zero.
	    else
	    {
	    	return  "Zero";
	    }
	}
	
	public static String helper(int num)
	{
		// This is for the range 0-9
	    String[] less_ten = { "", " One", " Two", " Three", " Four", " Five", " Six", " Seven", " Eight", " Nine" };
	    
	    // This is for the range 10-19
	    String[] less_twenty = { " Ten", " Eleven", " Twelve", " Thirteen", " Fourteen", " Fifteen", " Sixteen", " Seventeen", " Eighteen", " Nineteen" };
	    
	    // This is for the range 20s 30s, etc.
	    String[] less_hundred = { "", "", " Twenty", " Thirty", " Forty", " Fifty", " Sixty", " Seventy", " Eighty", " Ninety" };

	    
	    StringBuilder sb = new StringBuilder(); 

	    // Start processing the three digit number
	    if (num != 0)
	    {
	        // Get all the three digits
	        int hundred = num / 100;
	        num %= 100; 
	        int tenth = num / 10; 
	        int single = num % 10; 

	        // Parse digit at 100th place
	        if (hundred != 0) 
	        	sb.append(less_ten[hundred] + " Hundred");

	        // Parse digit at 10th place 
	        if (tenth != 0)
	        {
	        	// If digit at tenth place is 1, it needs to be treated in teens.
	            if (tenth == 1)
	            {
	            	sb.append(less_twenty[single]);	  
	            	
	            	// Remember, in teens, there is no need to parse unit digit. So return from here itself.
	                return sb.toString();
	            }
	            
	            // Otherwise, it will be treated as 20s, 30s, 40s and so on.
	            else  
	            	sb.append(less_hundred[tenth]);
	        }
	        
	        // Parse digit at unit place
	        if (single != 0) 
	        	sb.append(less_ten[single]);
	    } // End of If. At this point, the string is generated for the passed three digits.
	    
	    return sb.toString();
	}
}
