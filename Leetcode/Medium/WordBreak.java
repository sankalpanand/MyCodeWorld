package Leetcode.Medium;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {

	/*
	Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
	For example, given
	s = "leetcode",
	dict = ["leet", "code"].

	Return true because "leetcode" can be segmented as "leet code".

	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> dict = new HashSet<String>();
		dict.add("leet");
		dict.add("code");
		// "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"
		// ["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]
		dict.add("a");
		dict.add("aa");
		dict.add("aaa");
		dict.add("aaaa");
		dict.add("aaaaa");
		dict.add("aaaaaa");
		dict.add("aaaaaaa");
		dict.add("aaaaaaaa");
		dict.add("aaaaaaaaa");
		dict.add("aaaaaaaaaa");

		System.out.println(wordBreakDP("leetcode", dict));
		// System.out.println(wordBreak("aaaaaaa", dict));
		// System.out.println(wordBreakDP("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", dict));

	}


	// http://www.geeksforgeeks.org/dynamic-programming-set-32-word-break-problem/
	// This solution is perfect, but it gives TLE because of recursion
	public static boolean wordBreakR(String str, Set<String> dict)
	{
		int size = str.length();

		// Base case
		if (size == 0)  
			return true;

		// Try all prefixes of lengths from 1 to size
		for (int i=1; i<=size; i++)
		{
			if (dict.contains(str.substring(0, i)) // Prefix is present in the dictionary  
					&& wordBreakR(str.substring(i, size), dict)) // Check for the rest of the word
				return true; // If both are contained in the dictionary, then return true
		}

		// If we have tried all prefixes and none of them worked
		return false;
	}

	// This is a DP solution of the above problem.
	public static boolean  wordBreakDP(String str, Set<String> dict)
	{
		int size = str.length();
		if (size == 0)   return true;

		// Create the DP table to store results of subroblems. The value wb[i]
		// will be true if str[0..i-1] can be segmented into dictionary words,
		// otherwise false.
		boolean[] wb = new boolean[size+1];

		for (int i=1; i<=size; i++)
		{
			// Step 1- Look behind
			// if wb[i] is false, then check if current prefix can make it true.
			// Current prefix is "str.substr(0, i)"
			if (wb[i] == false && dict.contains(str.substring(0, i) ))
				wb[i] = true;

			// Step 2- If word can be formed from left part, then we need to investigate the right part.
			// wb[i] is true, then check for all substrings starting from (i+1)th character and store their results. 
			// For example, we matched leet, so we will start in the remaining word. We will check for c, co, cod, code.
			if (wb[i] == true)
			{
				// If wb[i] is true, it means word can be formed till (i-1). But i has reached the lenght. So, search over.
				if (i == size)
					return true;

				// Start from i+1. So it will be 1 char from i, then 2 chars from i, then 3 and so on
				for (int j = i+1; j <= size; j++)
				{
					String remWord = str.substring(i, j);

					if (wb[j] == false && dict.contains(remWord))
						wb[j] = true;

					// If we reached the last character while checking in the right part
					if (wb[j] == true && j == size)
						return true;
				}
			}
		}

		/* Uncomment these lines to print DP table "wb[]" */
		for (int i = 1; i <= size; i++)
			System.out.print(wb[i] + " "); 

		// If we have tried all prefixes and none of them worked
		return false;
	}

}
