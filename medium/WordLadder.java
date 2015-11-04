package medium;

import java.util.HashSet;
import java.util.Set;

public class WordLadder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> wordDict = new HashSet<>();
		wordDict.add("hot");
		//wordDict.add("dot");
		wordDict.add("dog");
		wordDict.add("dbg");
		//wordDict.add("lot");
		//wordDict.add("log");

		//System.out.println(ladderLength("hit", "cog", wordDict));
		System.out.println(ladderLength("hot", "dog", wordDict));

	}

	// BFS, two-end method - 37 ms
	// Traverse the path simultaneously from start node and end node, and merge in the middle
	// the speed will increase (logN/2)^2 times compared with one-end method
	public static int ladderLength(String beginWord, String endWord, Set<String> wordDict) 
	{
		int len = 1;
		Set<String> beginSet = new HashSet<>();
		Set<String> endSet = new HashSet<>();
		Set<String> visited = new HashSet<>();

		beginSet.add(beginWord);
		endSet.add(endWord);

		visited.add(beginWord);
		visited.add(endWord);

		while (!beginSet.isEmpty() && !endSet.isEmpty()) 
		{
			// add new words to smaller set to achieve better performance
			boolean isBeginSetSmall = beginSet.size() < endSet.size();
			Set<String> small = isBeginSetSmall ? beginSet : endSet;
			Set<String> big = isBeginSetSmall ? endSet : beginSet;


			Set<String> next = new HashSet<>();

			// Ye wala while() iteration ek word dhoondh nikaalega. Isliye len badha do.
			// Agar ye iteration mein ek bhi word na mila, iska matlab ladder nahi ban sakti.
			len++;

			// Iterate over each word in smaller set
			for (String str : small) 
			{
				// Iterate over each character of the each word in the smaller set
				for (int i = 0; i < str.length(); i++) 
				{
					// Generate letters from a to z
					for (char ch = 'a'; ch <= 'z'; ch++) 
					{
						// Copy the word so that we can form a new word out of it
						StringBuilder sb = new StringBuilder(str);

						// Set the char a-z at 0th index, then 1st index and so on
						sb.setCharAt(i, ch);
						String word = sb.toString();

						// If the big set has this word, it means the ladder is complete. Return length.
						// Remember we are iterating over "small" set. So here we check for "big"
						if (big.contains(word)) 
						{
							return len;
						}

						// Ladder not complete. Check if the newly formed word exists in the dictionary
						// To avoid going back, check if it is not there in the visited.
						if (wordDict.contains(word) && !visited.contains(word)) 
						{
							// Mark the word as visited
							visited.add(word);

							// Add that word to "next"
							next.add(word);
						}
					} // All A-Z characters replaced
				} // All character positions replaced
			} // All small set words checked


			// This is necessary for those input sets where there is no ladder formation.
			// If there was no match, then it is necessary for the while() loop to break.
			// If we don't reset these sets, they will always have some elements and will never terminate
			if (isBeginSetSmall) 
			{
				beginSet = next;
			} 
			else 
			{
				endSet = next;
			}
		}
		return 0;
	}


	/*
	 * Dijkstra solution: We put the first word in the set added. 
	 * We try to replace each letter of the word by every 26 letters.
	 * If a word is matched, we remove that word from the dictionary and add it into our added dictionary.
	 *  
	 * */
	public static int ladderLength2(String beginWord, String endWord, Set<String> wordDict) {
		Set<String> added = new HashSet<String>(); // Set to add all the found words
		Set<String> remaining = wordDict; // The original dictionary

		added.add(beginWord); // Add the start word in the added set to begin with

		// Add the end word in the dictionary and increment the distance
		remaining.add(endWord);		
		int distance = 1;

		while(!added.contains(endWord))
		{
			// Add the words that are found while generating. 
			Set<String> toAdd = new HashSet<String>();

			// Iterate over each word in the set
			for(String word : added)
			{
				// Iterate over entire length of each word. We need an index to replace characters.
				for (int i = 0; i < word.length(); i++) 
				{
					char[] chWord = word.toCharArray();

					// Generate letters from a to z
					for(char ch = 'a'; ch <= 'z'; ch++)
					{
						// Replace the letter at i'th position and check if it exists there in the dictionary?
						chWord[i] = ch;
						String strWord = new String(chWord);
						if(remaining.contains(strWord))
						{
							// If it's there, remove it from the dictionary and add it to added
							toAdd.add(strWord);
							remaining.remove(strWord);
						}
					}
				}				
			}

			// Increase the distance after you are done with all the words in the 
			distance++;

			// If there was no word that could be generated, it means the given word is secluded and can not go any further
			if(toAdd.size() == 0) return 0;

			// Update the reached words for the next iteration
			added = toAdd;
		}

		return distance;
	}


	public static int ladderLength3(String start, String end, Set<String> dict) {
		Set<String> set1 = new HashSet<String>();
		Set<String> set2 = new HashSet<String>();

		set1.add(start);
		set2.add(end);

		return helper(dict, set1, set2, 1);
	}

	public static int helper(Set<String> dict, Set<String> set1, Set<String> set2, int level) {
		if (set1.isEmpty()) 
			return 0;

		// If I remove this line, then also the solution will be accepted. 
		// However, since we try combinations for each word, if we go with the set with less number of words, it will increase performance.
		if (set1.size() > set2.size()) 
			return helper(dict, set2, set1, level);

		// remove words from both ends
		for (String word : set1) 
			dict.remove(word);
		for (String word : set2) 
			dict.remove(word); 

		// the set for next level
		Set<String> set = new HashSet<String>();

		// for each string in the current level
		for (String str : set1) 
		{
			char[] charStr = str.toCharArray();

			// For each character in the word
			for (int i = 0; i < str.length(); i++) 
			{
				char[] chars =  charStr.clone();

				// change letter at every position
				for (char ch = 'a'; ch <= 'z'; ch++) 
				{
					chars[i] = ch;
					String word = new String(chars);

					// found the word in other end(set)
					if (set2.contains(word)) 
					{
						// Whatever is the existing level, if we add one more transformation, it will be the count.
						return level + 1;
					}

					// if not, add to the next level
					if (dict.contains(word)) 
					{
						set.add(word);
					}
				}
			}
		}

		// Till this point, you have created a set which can be reached through the start node.
		// For next iteration, make this new set as destination and make the set2 as starting set
		return helper(dict, set2, set, level + 1);
	}

}
