package Leetcode.Medium;

import java.util.LinkedList;
import java.util.List;

public class GenerateParenthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenerateParenthesis obj = new GenerateParenthesis();
		// System.out.println();
		obj.generateParenthesis(2);
	}

	List<String> result = new LinkedList<String>();

	public List<String> generateParenthesis(int n) {
		helper("", n, 0);
		return result;
	}
	
	// HINT: Try to print the program to see the flow and also do it on paper
	// ( will send (( and () down the recursion tree
	// () will send only ()( down the recursion tree

    // n= number of left parenthesis
    // m = number of right parenthesis to be added
    // At each function call add a left parenthesis if n >0 and add a right parenthesis if m>0
	public void helper(String str, int open, int close) 
	{
		if(open == 0 && close == 0)
		{
			// System.out.println(str);
			result.add(str);
			return;
		}

        // When we take one more parenthesis, the number of available will be one less
        // And the number of right parenthesis to be added will increase by 1 for the left
		if(open > 0)
		{
			// System.out.println(str+ "(\t" + (n-1) + "\t" + (m+1));
			helper(str+"(", open-1, close + 1);
		}
		
		// When we take one more right parenthesis, the number of available will be one less
        // And the number of left parenthesis to be added will be unchanged
		if(close > 0)
		{
			// System.out.println(str+ ")\t" + (n) + "\t" + (m-1));
			helper(str+")", open, close - 1);
		}
	}

}
