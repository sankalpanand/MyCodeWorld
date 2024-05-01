package Leetcode.Medium;

import java.util.Stack;

public class EvaluateReversePolish {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int evalRPN(String[] tokens) 
	{
        int a,b;
        Stack<Integer> stack = new Stack<Integer>();
        
        for (String item : tokens) 
        {
            if(item.equals("+")) 
            {
            	stack.add(stack.pop()+stack.pop());
            }
            
            else if(item.equals("/")) 
            {
                b = stack.pop();
                a = stack.pop();
                stack.add(a / b);
            }
            
            else if(item.equals("*")) 
            {
            	stack.add(stack.pop() * stack.pop());
            }
            
            else if(item.equals("-")) 
            {
                b = stack.pop();
                a = stack.pop();
                stack.add(a - b);
            }
            else 
            {
            	stack.add(Integer.parseInt(item));
            }
        }   
        return stack.pop();
    }
}
