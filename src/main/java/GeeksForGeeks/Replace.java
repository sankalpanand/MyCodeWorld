import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Replace {

	public static void main(String[] args) 
	{
		String haystack = "mississippissip";
		String needle = "issip";
		String needle2 = "sankalp";
	
		List<Integer> res = search(haystack, needle);
		
		System.out.println(haystack.substring(0,4) + needle2 + haystack.substring(4+needle.length()));
		System.out.println(Arrays.asList(res));
		

	}

	
	// List<Integer> result = new ArrayList<Integer>()
	// Returns all getCellIndex
	public static List<Integer> search(String haystack, String needle)
	{
		List<Integer> result = new ArrayList<Integer>();
		if(needle.length() == 0) return result;
		if(haystack.length() == 0) return result;
		

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
				{
					result.add(i-j);	
					j=0;					
				}
			}

			// If a mismatch occurs
			else
			{
				if(j != 0) // Move back and take the new getCellIndex from there
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
		return result;
	}
	
	/**
	 * Compute temporary array to maintain size of suffix which is same as prefix
	 * Time/space complexity is O(size of pattern). 
	 * This array tells me that what is the longest suffix at every point which is also the prefix.
	 */
	// https://www.youtube.com/watch?v=KG44VoDtsAA
	private static int[] computeTemporaryArray(String pattern)
	{
		// Temp array is of the same size of the pattern.
		// Every point tells us what is the longest suffix length which is also the prefix in this temp array.
		int [] lps = new int[pattern.length()];
		
		// First point is always 0
		int j =0;

		// Note that there is no i++ here in this for()
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
