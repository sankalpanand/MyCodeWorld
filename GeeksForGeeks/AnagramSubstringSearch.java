
public class AnagramSubstringSearch {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		String large = "BACDGABCDA";
		String pattern = "ABCD";
		search(large, pattern);

	}
	
	public static void search(String large, String pattern)
	{
		int lenString = large.length();
		int lenPattern = pattern.length();
		
		// Make two strings to maintain frequencies of letters
		int[] countString = new int[256];
		int[] countPattern = new int[256];
		
		// Update frequencies of pattern as well as original string till pattern's length
		for(int i=0; i<lenPattern; i++)
		{
			countString[large.charAt(i)]++;
			countPattern[pattern.charAt(i)]++;
		}
		
		// Take off with the remaining length of original string from i=lenPattern with the large string
		for(int i=lenPattern; i<lenString; i++)
		{
			if(compare(countString, countPattern))
				System.out.println("Found anagram at " + (i-lenPattern));
			
			// Add the i'th character to the window
			countString[large.charAt(i)]++;
			
			// Remove a character from the back
			countString[large.charAt(i-lenPattern)]--;
		}
		
		// Since for each i'th value we are checking window which ends at (i-1)th getCellIndex.
		// After this loop, last window is left.
		if(compare(countString, countPattern))
			System.out.println("Found anagram at " + (lenString - lenPattern));
		
		
	}
	
	public static boolean compare(int[] countString, int[] countPattern)
	{
		for (int i = 0; i < 255; i++)
		{
			if(countString[i] != countPattern[i])
				return false;
		}
		
		return true;
	}

}
