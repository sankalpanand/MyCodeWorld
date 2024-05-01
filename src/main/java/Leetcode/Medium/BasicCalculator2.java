package Leetcode.Medium;
import java.util.*;

public class BasicCalculator2 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		// String str = "(1+(4+5+2)-3)+(6+8)";
		String str = "1";
		System.out.println(calculate(str));

	}

	// " 2-1 + 2 " = 3
	// "(1+(4+5+2)-3)+(6+8)" = 23
	public static int calculate(String s) 
	{
	    int len = s.length();
	    if(s==null || len ==0) 
	    	return 0;
	    
	    Stack<Integer> stack = new Stack<Integer>();
	    
	    int num = 0;
	    char sign = '+';
	    
	    for(int i=0;i<len;i++)
	    {
	        if(Character.isDigit(s.charAt(i)))
	        {
	            num = num*10+s.charAt(i)-'0';
	        }
	        	        
	        if((!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i==len-1))
	        {
	            if(sign=='-')
	            {
	                stack.push(-num);
	            }
	            
	            // The sign is + by default. So it works even when it's just a single character.
	            if(sign=='+')
	            {
	                stack.push(num);
	            }
	            
	            if(sign=='*')
	            {
	                stack.push(stack.pop()*num);
	            }
	            
	            if(sign=='/')
	            {
	                stack.push(stack.pop()/num);
	            }
	            
	            sign = s.charAt(i);
	            num = 0;
	        }
	    }

	    int re = 0;
	    for(int i:stack)
	    {
	        re += i;
	    }
	    return re;
	}
	

}
