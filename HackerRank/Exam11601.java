
public class Exam11601 {

	public static void main(String[] args) 
	{
		// long num = -9223372036854775808L;
		// String numStr = Long.toBinaryString(num);
		 // = String.valueOf(num);
		// numStr = numStr
		
		// System.out.println(nextNonOneGapped(num));
		String str = "a,b$c";
		String res = reverse(str);
		System.out.println(res);
		
	}
	
	public static void Question2()
	{
		String a = "11601 final";
		String b = "11601 final";
		
		System.out.println(a==b);
	}
	
	static long nextNonOneGapped(long x) 
	{
		if(x<0) return -1;
		
		for(long i = x+1; i<Long.MAX_VALUE; i++)
		{
            if(i<0)
				return -1;
            
			if(!isOneGapped(Long.toBinaryString(i)))
			{
				return i;
			}
		}
		return -1;

    }
	
	public static boolean isOneGapped(String str)
	{
		if(str.contains("101"))
		{
			return true;
		}
		else
			return false;
	}
	
	public static String reverse(String str)
	{


	    int start = 0, end = str.length()-1;
	    StringBuilder sb = new StringBuilder(str);
	    
	    while(start < end)
	    {
	    	char chStart = sb.charAt(start);
	    	char chEnd = sb.charAt(end);
	    	
	    	if(!charInRange(chStart))
	    	{
	    		start++;
	    		continue;
	    	}

	    	else if(!charInRange(chEnd))
	    	{
	    		end--;
	    		continue;
	    	}
	    	
	    	else
	    	{
	    		char temp = sb.charAt(start);
		    	sb.setCharAt(start, sb.charAt(end));
		    	sb.setCharAt(end, temp);
		    	
		        start++;
		        end--;
	    	}

	    }
	    return sb.toString();
	}
	
	public static boolean charInRange(Character ch)
	{
		if((ch>='a' && ch<= 'z') || (ch>='A' && ch<= 'Z'))
			return true;
		else
			return false;
	}

}
