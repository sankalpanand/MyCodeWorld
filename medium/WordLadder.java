package medium;

import java.util.HashSet;
import java.util.Set;

public class WordLadder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> wordDict = new HashSet<>();
		wordDict.add("hot");
		wordDict.add("dog");
		// wordDict.add("c");
		System.out.println(ladderLength("hot", "dog", wordDict));

	}


	/*
	 * Dijkstra solution: We put the first word in the set added. 
	 * We try to replace each letter of the word by every 26 letters.
	 * If a word is matched, we remove that word from the dictionary and add it into our added dictionary.
	 *  
	 * */
	public static int ladderLength1(String beginWord, String endWord, Set<String> wordDict) {
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


	public static int ladderLength(String start, String end, Set<String> dict) {
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
