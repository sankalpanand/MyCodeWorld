package Leetcode.Easy;

import java.util.Stack;

public class ValidParenthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	Character by character chalo. 
	Agar opening bracket dikhe, stack pe chadha do.
	Agar closing bracket dikhe, to stack se peek() karo and check karo opening bracket se.
		Agar match karta hai, to stack se hata do, aur aage badho.
		Agar matchi nahi kiya, to false.

	 */
	public boolean isValid(String s) 
	{
		if(s.length() <= 1) return false;

		Stack<Character> stack = new Stack<Character>();
		char[] charString = s.toCharArray();

		for(int i=0; i<s.length(); i++)
		{
			if(charString[i] == '(' || charString[i] == '{' || charString[i] == '[')
			{
				stack.push(charString[i]);
			}

			else if(charString[i] == ')' || charString[i] == '}' || charString[i] == ']')
			{
				try
				{
					char last = stack.peek();
					if((charString[i] == ')' && last == '(') || (charString[i] == '}' && last == '{') || (charString[i] == ']' && last == '['))
						stack.pop();
					else
						return false;
				}

				// Try catch handles errors if input is like - "[])"
				catch(Exception e)
				{
					return false;
				}
			}

			else
				return false;

		}

		if(stack.size() != 0)
			return false;
		else
			return true;



	}

	// without using {} () []
	public boolean isValid1(String s) {
		Stack<Integer> p = new Stack<>();
		for(int i = 0; i < s.length(); i++) {
			int q = "(){}[]".indexOf(s.substring(i, i + 1));
			if(q % 2 == 1) {
				if(p.isEmpty() || p.pop() != q - 1) return false;
			} else p.push(q);
		}
		return p.isEmpty();
	}

	// Without stack
	public static boolean isValid2(String s) 
	{
		if (s.length() == 0)
			return true;

		else if (s.length() % 2 == 1)
			return false;

		// My Flaws - 
		// 1- I forgot the condition in this while loop
		// 2- I was not reassigning the s.replace()
		while (s.contains("()") || s.contains("[]") || s.contains("{}")) 
		{
			s = s.replace("()", "");
			s = s.replace("[]", "");
			s = s.replace("{}", "");
		}

		return s.length() == 0;
	}

}
