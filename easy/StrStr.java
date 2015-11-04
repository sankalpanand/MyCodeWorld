package easy;


// https://www.youtube.com/watch?v=GTJr8OvyEVQ


public class StrStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String haystack = "mississippi";
		String needle = "issip";
		// System.out.println(strStr(haystack, needle));
		System.out.println(strStr(haystack, needle));
		// String sample = "acacabacacabacacac";

		// int[] array = failureFunction(sample.toCharArray());
		// int[] array = computeTemporaryArray(sample.toCharArray());
		// System.out.println(Arrays.toString(array));

	}

	// Order of mn
	/*
	DO loop leke chalo. Bahar wala haystack ko control karega, andar waala needle ko.
	It is interesting to note in this program that it doesn't have a compilation error.
	*/
	public int strStr2(String haystack, String needle) 
	{
        for (int i = 0; ; i++) 
		{
			for (int j = 0; ; j++) 
			{
			    // It means, neither break; executed nor return -1 occured.
			    // By that time j++ went on.. and now j has reached needle length.
			    // It means, match occurred.
				if (j == needle.length()) 
					return i;
                
                // it means, i is anchored and while j moving forward we hit the boundary of haystack
				if (i + j == haystack.length()) 
					return -1;
                
                // i is anchored. Now it is j'th character in needle and j'th character from i in haystack
                // If mismatch occurs, break the anchor. Proceed to next index.
				if (needle.charAt(j) != haystack.charAt(i + j)) 
					break;
			}
		}
    }

	// KMP Algorithm - Order of m + n
	/**
	 * KMP algorithm of pattern matching.
	 */
	public static int strStr(String haystack, String needle)
	{
		if(needle.length() == 0) return 0;
		if(haystack.length() == 0) return -1;

		// O(n)
		int lps[] = computeTemporaryArray(needle);
		
		int i=0;
		int j=0;

		while(i < haystack.length() && j < needle.length())
		{
			if(haystack.charAt(i) == needle.charAt(j))
			{
				i++;
				j++;

				if (j == needle.length()) 
					return i-j;
			}

			// If a mismatch occurs
			else
			{
				if(j != 0) // Move back and take the new index from there
				{
					j = lps[j-1];
				}
				// j is still at zero and there is a mismatch. Move i one step ahead.
				else
				{
					i++;
				}
			}
		}

		// Use this function if you have to return the presense of a string
		/*if(j == needle.length())
	        {
	            return true;
	        }*/

		return -1;
	}

	/**
	 * Compute temporary array to maintain size of suffix which is same as prefix
	 * Time/space complexity is O(size of pattern). 
	 * This array tells me that what is the longest suffix at every point which is also the prefix.
	 */
	// https://www.youtube.com/watch?v=KG44VoDtsAA
	private static int[] computeTemporaryArray(String pattern)
	{
		int [] lps = new int[pattern.length()];
		
		// First point is always 0
		int j =0;

		// Note that there is no i++ here in this for
		for(int i=1; i < pattern.length();)
		{
			// Match is found
			if(pattern.charAt(i) == pattern.charAt(j))
			{
				lps[i] = j + 1;
				j++;
				i++;
			}

			// Match is not found
			else
			{
				// If j is not at zero, move back and do not increase i
				if(j != 0)
				{
					j = lps[j-1];
				}
				// If j is at zero, there is no other option but to proceed further and mark that cell as zero
				else
				{
					lps[i] =0;
					i++;
				}
			}
		}
		return lps;
	}

}
