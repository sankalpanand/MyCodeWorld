package Leetcode.Medium;

public class Q5LongestPalindromicSubstring {

	// Second approach here - https://leetcode.com/problems/longest-palindromic-substring/solutions/4212564/beats-96-49-5-different-approaches-brute-force-eac-dp-ma-recursion/
	// Also explained by Neetcode - https://youtu.be/XYQecbcd6_c?si=yzEbjSdqb54W0kEq
	public static void main(String[] args) {
		Q5LongestPalindromicSubstring obj = new Q5LongestPalindromicSubstring();
		System.out.println(obj.longestPalindrome("xxabcdcbaio"));
		// System.out.println(longestPalindrome("abb"));
	}

	public String longestPalindrome(String s) {
		String result = "";
		result = expand(s, result, 0);	// We'll expand from single element for odd length string
		result = expand(s, result, 1);	// We'll expand from single element for even length string
		return result;
	}

	public String expand(String s, String result, int offset) {
		for(int i=0; i< s.length(); i++) {

			int left = i, right = i+offset;

			while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
				int lenOfCurrSubstring = right - left + 1;
				if(lenOfCurrSubstring > result.length()) {
					result = s.substring(left, right+1);	// right inclusive
				}

				left--;
				right++;
			}
		}

		return result;
	}
}
