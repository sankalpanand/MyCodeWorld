package Leetcode.Medium;

public class LongestPalindromicSubsequence {
	// https://www.youtube.com/watch?v=_nCsPn7_OgI
	// http://www.geeksforgeeks.org/dynamic-programming-set-12-longest-palindromic-subsequence/

	public static void main(String args[]){
		LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
		String str = "GEEKSFORGEEKS";
		int  r = lps.calculateDP(str.toCharArray());
		// int r = lps.calculateRecursive(str.toCharArray(), 0, str.length() - 1);
		System.out.print(r);
	}


	public int calculateDP(char []str)
	{
		int T[][] = new int[str.length+1][str.length+1];
		for(int i=0; i < str.length; i++)
		{
			T[1][i] = 1;
		}

		/*
		 *  length = 2, for 1 to 5 
		 *  length = 3, for 1 to 4
		 *  length = 4, for 1 to 3
		 *  length = 5, for 1 to 2
		 *  length = 6, for 1 to 1				
		 * */

		// O(n square)
		for(int length = 2; length <= str.length; length ++)
		{
			for(int i = 1; i <= str.length-length+1; i++)
			{
				if(str[i-1] == str[i-1 + length - 1] && length == 2)
				{
					T[length][i] = 2;
				}

				else if(str[i-1] == str[i + length - 2])
				{
					// We look diagonally across
					T[length][i] = T[length-2][i+1] + 2;
				}

				else
				{
					T[length][i] = Math.max(T[length - 1][i+1], T[length - 1][i]);
				}
			}
		}
		
		return T[str.length][1];
	}

	// Idea behind recursion - 
	// Let X be the input sequence of length n and L(0, n-1) be the length of the longest palindromic subsequence of X.
	// If last and first characters of X are same, then L(0, n-1) = L(1, n-2) + 2.
	public int calculateRecursive(char[] seq, int i, int j) 
	{
		// Base Case 1: If there is only 1 character
		if (i == j)
			return 1;

		// Base Case 2: If there are only 2 characters and both are same
		if (seq[i] == seq[j] && i + 1 == j)
			return 2;

		// If the first and last characters match
		if (seq[i] == seq[j])
			return calculateRecursive (seq, i+1, j-1) + 2;

		// If the first and last characters do not match
		return Math.max(calculateRecursive(seq, i, j-1), calculateRecursive(seq, i+1, j));
		
	}



}
