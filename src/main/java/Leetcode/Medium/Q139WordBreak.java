package Leetcode.Medium;

import java.util.ArrayList;
import java.util.List;

public class Q139WordBreak {

	/*
	Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
	For example, given
	s = "leetcode",
	dict = ["leet", "code"].

	Return true because "leetcode" can be segmented as "leet code".

	 */
	public static void main(String[] args) {
		Q139WordBreak obj = new Q139WordBreak();
		List<String> dict = new ArrayList<>();
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
//		System.out.println(obj.wordBreak("leetcode", dict));
		// System.out.println(wordBreak("aaaaaaa", dict));
		// System.out.println(wordBreakDP("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", dict));

		dict = new ArrayList<>();
		dict.add("cats");
		dict.add("dog");
		dict.add("sand");
		dict.add("and");
		dict.add("cat");
		System.out.println(obj.wordBreak("catsanddog", dict));

	}


	// Neetcode - https://www.youtube.com/watch?v=Sx9NNgInc3A
	// Leetcode - https://leetcode.com/problems/word-break/description/
	// Bottom up approach using 1D array
	public boolean wordBreak(String s, List<String> wordDict) {
		boolean[] dp = new boolean[s.length() + 1];
		dp[s.length()] = true;

		for (int i = s.length() - 1; i >= 0; i--) {
			for (String w : wordDict) {
				if ((i + w.length() <= s.length()) 						// There are enough length left in the string from i
						&& s.substring(i, i + w.length()).equals(w)) { 	// The current word w appears in the string

					dp[i] = dp[i + w.length()];							// Check if we were able to match remainder of the string, copy its value here
				}

				if (dp[i]) {	// Koi ek word match ho gaya hai, baaki ke words match karne ki jarurat nahi
					break;
				}
			}
		}

		return dp[0];
	}
}
