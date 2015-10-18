package medium;

import java.util.Stack;

public class ReverseWordsInAString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "1 ";
		System.out.println(reverseWords(input));

	}

	public static String reverseWords1(String s) {
		if(s.length() == 0) return s;
		StringBuilder result = new StringBuilder();

		Stack<Character> stack = new Stack<Character>();
		for(int i = s.length()-1; i>=0; i--)
		{
			if(s.charAt(i) == ' ')
			{
				// StringBuilder word = new StringBuilder();

				while(!stack.isEmpty())
				{
					result.append(stack.pop());
				}
				if(i!= 0) // For dealing with " 1"
					result.append(" ");
			}
			else
			{
				stack.push(s.charAt(i));
			}
		}

		while(!stack.isEmpty())
		{
			result.append(stack.pop());
		}

		return result.toString();
	}

	public static String reverseWords2(String s) {
		String[] parts = s.trim().split("\\s+");
		StringBuilder out = new StringBuilder();

		if (parts.length > 0) 
		{
			for (int i = parts.length - 1; i > 0; i--) 
			{
				out.append(parts[i]+ " ");
			}

			// Last word in the end to avoid extra backspace
			out.append(parts[0]);
		}
		return out.toString();
	}

	// GeeksforGeeks method
	public char[] reverse(char[] arr, int i, int j) 
	{
		while (i < j) 
		{
			char tmp = arr[i];
			arr[i++] = arr[j];
			arr[j--] = tmp;
		}
		return arr;
	}

	public static String reverseWords(String s) 
	{
		if(s == null) 
			return "";

		int i = 0;
		String newStr = "";
		String word = "";
		while(i<s.length())
		{
			char c = s.charAt(i);
			if(c == ' ')
			{
				// It means it is a continuing string, we just need to appeand the word
				if(newStr != "" && word != "") 
					newStr = word + " " + newStr; // Notice the order here, we are placing word ahead of the new string

				// It means this space occurs after the first word
				if(newStr == "" && word != "") 
					newStr = word;
				
				// We are done with append, reset the word
				else
					word = "";
			}

			// Word formation takes place here
			else
			{
				word += c;
			}

			i++;
		}
		
		if(newStr != "" && word != "")
			newStr = word + " " + newStr;
		if(newStr == "" && word != "")
			newStr = word;

		return newStr;
	}

}
