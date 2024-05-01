package Leetcode.Medium;

public class PalindromePermutation2 {
	
	// https://leetcode.com/discuss/oj/palindrome-permutation-ii
	
	/*
	 Given a string, determine if a permutation of the string could form a palindrome.
	For example,
	"code" -> False, "aab" -> True, "carerac" -> True.
	 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*
	 Just check that no more than one character appears an odd number of times. 
	 Because if there is one, then it must be in the middle of the palindrome. 
	 So we can't have two of them.
	 * */
	public boolean canPermutePalindrome(String s) {
	    return true;
	}

}
