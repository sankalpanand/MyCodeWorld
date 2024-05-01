package Leetcode.Medium;

import java.util.ArrayList;
import java.util.HashMap;

public class DifferentWaystoAddParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// Note that this solution does not have many multiple subproblems. So, we can use DP.
    public ArrayList<Integer> diffWaysToCompute1(String input) {
        
    	ArrayList<Integer> result = new ArrayList<Integer>();
        
        for(int i=0; i<input.length(); i++)
        {
            if(input.charAt(i) == '*' || input.charAt(i) == '-' || input.charAt(i) == '+')
            {
                String left = input.substring(0, i);
                String right = input.substring(i+1);
                
                ArrayList<Integer> resLeft = diffWaysToCompute(left);
                ArrayList<Integer> resRight = diffWaysToCompute(right);
                
                for(Integer leftNums : resLeft)
                {
                    for(Integer rightNums : resRight)
                    {
                        int c = 0;
                        
                        switch(input.charAt(i))
                        {
                            case '+': c= leftNums + rightNums;
                                        break;
                                        
                            case '-': c= leftNums - rightNums;
                                        break;
                                        
                            case '*': c= leftNums * rightNums;
                                        break;
                        }
                        
                        result.add(c);
                    }
                }
            }
        }
        
        if(result.size() == 0) 
            result.add(Integer.parseInt(input));
        
        return result;
    }
    
    // Dynamic Programming
    public ArrayList<Integer> diffWaysToCompute(String input) 
    {
        HashMap<String, ArrayList<Integer>> cache = new HashMap<String, ArrayList<Integer>>();
        ArrayList<Integer> result = helper(input, cache);
        return result;
    }
    
    public ArrayList<Integer> helper(String input, HashMap<String, ArrayList<Integer>> cache)
    {
        if(cache.get(input) != null) 
            return cache.get(input);
        
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        for(int i=0; i<input.length(); i++)
        {
            
            // if(input.charAt(i) == '*' || input.charAt(i) == '-' || input.charAt(i) == '+')
            if("+-*".indexOf(input.charAt(i)) != -1)
            {
                String left = input.substring(0, i);
                String right = input.substring(i+1);
                
                ArrayList<Integer> resLeft = helper(left, cache);
                ArrayList<Integer> resRight = helper(right, cache);
                
                for(Integer leftNums : resLeft)
                {
                    for(Integer rightNums : resRight)
                    {
                        result.add(calculate(leftNums, rightNums, input.charAt(i)));
                    }
                }
            }
        }
        
        cache.put(input, result);
        
        if(result.size() == 0) 
            result.add(Integer.parseInt(input));
        
        
        
        return result;
    }
    
    public int calculate(int leftNums, int rightNums, char operator)
    {
        int result = 0;
        switch(operator)
        {
            case '+': result = leftNums + rightNums;
                        break;
                                        
            case '-': result = leftNums - rightNums;
                        break;
                                        
            case '*': result = leftNums * rightNums;
                        break;
        }
        
        return result;
    }

}
