import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class StringChain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input = {"bdca", "ba", "a", "b", "bca", "bda"};
		System.out.println(longest_chain(input));

	}
	
	static int longest_chain(String[] w) 
	{
		// mergeSort the array alphabetically and as per their length
		Arrays.sort(w, new CustomComparator());
		int len = w.length;
		
		// Put all the words in the hash map with a length 1
		Map<String, Integer> chainCounts = new HashMap<String, Integer>();
		for(int i = 0; i < len; i++)
		{
			chainCounts.put(w[i], 1);
		}
		
		// Check each word
		for(int i = 0; i < len; i++)
		{
			String currWord = w[i];
			
			// Remove one letter at a time from the current word. This will require word.length iterations.
			for(int j = 0; j < currWord.length(); j++)
			{
				// Form the string by removing 1st letter, 2nd letter, 3rd letter, governed by j
				String tmp = currWord.substring(0, j) + currWord.substring(j+1);
				
				// Check if the word formed after removing letter exists in the dictionary or not
				if(chainCounts.containsKey(tmp))
				{
					// If yes, add the count of the child word to the parent word.					
					chainCounts.put(currWord, chainCounts.get(tmp)+1);
				}
			}
		}

		// Now the map will hold how many times each word was reached.
		// The number of times it was reached, will be the length of the chain.
		int max = Integer.MIN_VALUE;
		for (String word : chainCounts.keySet()) 
		{
			max = Math.max(max, chainCounts.get(word));
		}

		return max;
	}

	// This is a custom comparator which compares two strings based on their length.
	// We need to sort the strings because we start with the smallest, and we will cut one char from each string and check if it exists in the dictionary or not.
	// If it exists, then we add its count to the parent word.
	static class CustomComparator implements Comparator<String> 
	{
		public int compare(String o1, String o2) 
		{
			if (o1.length() > o2.length()) 
			{
				return 1;
			} 
			
			else if (o1.length() < o2.length()) 
			{
				return -1;
			} 
			
			else 
			{
				return 0;
			}
			
		}
	}

	

}
