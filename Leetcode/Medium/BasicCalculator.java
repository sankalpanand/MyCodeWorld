package Leetcode.Medium;
import java.util.*;

public class BasicCalculator {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		String str = "(1+(4+5+2)-3)+(6+8)";
		System.out.println(calculate(str));

	}

	// " 2-1 + 2 " = 3
	// "(1+(4+5+2)-3)+(6+8)" = 23
	public int calculate1(String s) 
	{
		Stack<Integer> stack = new Stack<Integer>();
		int result = 0;
		int number = 0;
		int sign = 1;
		
		for(int i = 0; i < s.length(); i++)
		{
			char c = s.charAt(i);
			
			if(Character.isDigit(c))
			{
				number = 10 * number + (int)(c - '0');
			}
			else if(c == '+')
			{
				result += sign * number;
				number = 0; // Make the number for forming the numbers following this sign
				sign = 1;
			}
			else if(c == '-')
			{
				result += sign * number;
				number = 0; // Make the number for forming the numbers following this sign
				sign = -1;
			}
			
			// push the previous result and the sign into the stack, set result to 0, 
			// just calculate the new result within the parenthesis.
			else if(c == '(')
			{
				//we push the result first, then sign;
				stack.push(result);
				stack.push(sign);
				
				//reset the sign and result for the value in the parenthesis
				sign = 1;   
				result = 0;
			}
			
			// Pop out the top two numbers from stack, 
			// first one is the sign before this pair of parenthesis,
			// second is the temporary result before this pair of parenthesis. We add them together.
			else if(c == ')')
			{
				result += sign * number; // This is the local result in within the parenthesis  
				number = 0;
				
				// This is the result which we added on top of stack before this bracket began
				result *= stack.pop();    // stack.pop() is the sign before the parenthesis
				result += stack.pop();    // stack.pop() now is the result calculated before the parenthesis
			}
		}
		
		if(number != 0) 
			result += sign * number;
		
		return result;
	}
	
	public static int calculate(String s) 
	{
        int pos=0;
        return evaluate(s,pos);
    }

    public static int evaluate(String s, int i) 
    {
        int res = 0;
        boolean negFlag=false;
        
        while(i<s.length() && s.charAt(i) != ')') 
        {
            if(s.charAt(i)=='+' || s.charAt(i) ==' ') 
                i++;
            
            else if(s.charAt(i) =='-') 
            {
                i++;
                negFlag=true;
            }
            
            else if(s.charAt(i) =='(') 
            {
                i++;
                res+= negFlag?-evaluate(s,i):evaluate(s,i);
                negFlag=false;
            }
            
         // numeric chars
            else 
            {
                int num=0;
                while(i<s.length() && Character.isDigit(s.charAt(i)))
                    num = num*10 + s.charAt(i++)-'0';
                res+=negFlag?-num:num;
                negFlag=false;
            }
        }
        
        i++; // skip the current ')'
        return res;
    }

}
