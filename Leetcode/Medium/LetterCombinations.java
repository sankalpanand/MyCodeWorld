package Leetcode.Medium;

import java.util.LinkedList;
import java.util.List;

public class LetterCombinations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		letterCombinations("23");

	}

	// When i=0, add - [a, b, c], because list.head.length = 0
	// When i=1, add - [ad, ae, af, be, bd, bf, cd, ce, cf], because list.head.length = 1
	public static List<String> letterCombinations(String digits) 
	{
		LinkedList<String> result = new LinkedList<String>();
		if(digits.length() == 0)
	        return result;
		
		String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		result.add("");
		for(int i =0; i<digits.length(); i++)
		{
			int digit = digits.charAt(i) - '0';

			while(result.peek().length() == i)
			{
				String t = result.remove();
				for(char s : mapping[digit].toCharArray())
					result.add(t+s);
			}
		}
		return result;
	}

}
