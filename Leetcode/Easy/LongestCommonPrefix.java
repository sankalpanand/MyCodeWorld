package Leetcode.Easy;

public class LongestCommonPrefix {

	public static void main(String[] args) 
	{

	}

	// Approach is to take the first string. 
	// If it is smaller than the rest and matched, it will be present in indexOf(), so will be returned as it is
	// If it is longer, then as long as it is contained in str[i], it will be truncated from the end.
	// It it doesn't matches at all, it will be truncated till its reduced to zero.
	public String longestCommonPrefix1(String[] strs) {

		if(strs.length == 0) return "";
		String first = strs[0];
		for(int i=1; i < strs.length; i++)
		{
			while(strs[i].indexOf(first) != 0)
			{
				first = first.substring(0, first.length() - 1);
			}
		}
		return first;
	}

	public String longestCommonPrefix(String[] strs) {
		if(strs.length == 0) return "";

		// This loop runs horizontally
		for(int i=0; i<strs[0].length(); i++)
		{
			char ch = strs[0].charAt(i);
			
			// This loop runs vertically
			for(int j=1; j<strs.length; j++)
			{
				if(i >= strs[j].length() || strs[j].charAt(i) != ch)
				{
					return strs[0].substring(0, i);
				}
			}

		}

		return strs[0];

	}

	public String longestCommonPrefix3(String[] strs) {
		if (strs.length == 0)
			return "";
		if (strs.length == 1)
			return strs[0];

		String prefix = "", minSt = strs[0];

		// Find out the string with minimum length
		for (String st: strs)
			if (st.length() < minSt.length()) 
				minSt = st;

		// Run the outer for loop horizontally from i=0 to min.length()
		for (int i=0; i<minSt.length(); i++) 
		{
			// Iterate over each string vertically
			for (String st: strs)
				if (st.charAt(i) != minSt.charAt(i)) // Check each string's character with min string char
					return prefix;

			// All strings matched the first character. Add it to SB.
			prefix += minSt.charAt(i);

			// Check the next character in the next iteration.
		}
		return prefix;
	}
}
