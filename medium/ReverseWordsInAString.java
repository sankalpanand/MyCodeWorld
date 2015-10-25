package medium;

import java.util.Stack;

public class ReverseWordsInAString {

	public static void main(String[] args) {
		// String input = "1 ";
		String input = "the sky is blue";
		// input = "a";
		// input = "sankalp";
		System.out.println(reverseWords(input));

	}

	// Without using stack
	public static String reverseWords(String s) 
	{
		if(s == null) 
			return "";

		int i = 0;
		StringBuilder newStr = new StringBuilder();
		String word = "";

		while(i < s.length())
		{
			char c = s.charAt(i);

			// Words are generated here from characters
			if(c != ' ')
			{
				word += c;
			}

			// Words are appended to sentences
			else
			{
				// It means there are already words in the string, we just need to appeand the word
				if(newStr.length() != 0 && word != "") 
					newStr.insert(0, word + " "); // Notice the order here, we are placing word ahead of the new string

				// It means this space occurs after the first word
				if(newStr.length() == 0 && word != "") 
					newStr.append(word);

				// Reset the word
				word = "";
			}

			i++;
		}

		// To take care of last word in the sentence
		if(newStr.length() != 0 && word != "")
			newStr.insert(0, word + " ");


		// To take care of just one word string because the if() block never executed, so the word was not pushed to newStr
		if(newStr.length() == 0 && word != "")
			newStr.append(word);

		return newStr.toString();
	}

	// Using Stack
	public static String reverseWords1(String s) 
	{
		if(s.length() == 0) return s;


		StringBuilder result = new StringBuilder();
		Stack<Character> stack = new Stack<Character>();

		for(int i = s.length()-1; i>=0; i--)
		{
			if(s.charAt(i) == ' ')
			{
				while(!stack.isEmpty())
				{
					result.append(stack.pop());
				}

				// If there is a space at the 0th index, we don't want that to append to the new string
				if(i!= 0)
					result.append(" ");
			}
			else
			{
				stack.push(s.charAt(i));
			}
		}

		// For the last word
		while(!stack.isEmpty())
		{
			result.append(stack.pop());
		}

		return result.toString();
	}

	
}
