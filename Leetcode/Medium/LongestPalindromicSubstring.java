package Leetcode.Medium;

public class LongestPalindromicSubstring {
	// https://www.youtube.com/watch?v=_nCsPn7_OgI
	// https://leetcode.com/discuss/9948/a-very-brief-o-n-time-o-1-space-solution-ac

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestPalindrome1("xxabcdcbaio"));
		// System.out.println(longestPalindrome("abb"));
	}

	public static String longestPalindrome(String s) 
	{
		int length = s.length();
		int finalStart = 0; 
		int finalLength = 1;
		int i=0;

		// Initial condition check
		if (s.length() <= 1) 
			return s;

		while (i < length) 
		{
			// We start checking around i
			int start = i;
			int end = i;

			// If the characters are repeating, we move end forward and leave start here 
			// so that the repeatitive characters are counted towards palindrome.
			while (end < length - 1 && s.charAt(end + 1) == s.charAt(end)) 
				end++; 

			// Store the value of i for the next iteration. We'll take up from the i'th position next time
			i = end + 1;

			// Start expanding around i which is 'start' and 'end'
			while (end < length - 1 && start > 0 && s.charAt(end + 1) == s.charAt(start - 1)) 
			{
				end++;
				start--;
			}

			// We came out of while, it means palindrome break. Store the palindrome length  
			int new_len = end - start + 1;

			// If the length is more than the previous max length, store the new length and the start pointer
			if (new_len > finalLength) 
			{
				finalStart = start;
				finalLength = new_len;
			}
		}
		return s.substring(finalStart, finalStart + finalLength);
	}
	
	

	public static String longestPalindrome1(String s) 
	{
	    int n = s.length();
	    int longestLen = 0;
	    int longestIndex = 0;

	    for(int currentIndex = 0; currentIndex < n; currentIndex++) 
	    {
	    	// This is for the first match aroud the pivot
	        if(isPalindrome(s, currentIndex - longestLen, currentIndex))
	        {
	            longestLen += 1;
	            longestIndex = currentIndex;
	        } 
	        
	        // This is for the subsequent matches when the first match is made
	        else if(currentIndex - longestLen - 1 >= 0 && isPalindrome(s, currentIndex - longestLen - 1, currentIndex)) 
	        {
	            longestLen += 2;
	            longestIndex = currentIndex;
	        }   
	    }
	    
	    longestIndex++;
	    return s.substring(longestIndex - longestLen, longestIndex);
	}
	
	public static boolean isPalindrome(String s, int startIndex, int endIndex) 
	{
	    for(int i = startIndex, j = endIndex; i <= j; i++, j--) 
	            if (s.charAt(i) != s.charAt(j)) 
	            	return false;
	    
	    return true;
	}
}
