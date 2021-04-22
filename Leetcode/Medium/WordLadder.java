package Leetcode.Medium;

import java.util.*;

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
//		System.out.println(ladderLength("hot", "dog", wordDict));

	}

	// Video explanation - https://www.youtube.com/watch?v=M9cVl4d0v04
    // https://leetcode.com/problems/word-ladder/discuss/40707/C%2B%2B-BFS
	public int ladderLength(String beginWord, String endWord, List<String> wordList) 
	{
		Set<String> dict = new HashSet<>(wordList);
		Set<String> visited = new HashSet<>();
		Queue<String> queue = new LinkedList<>();
		queue.offer(beginWord);

		int level = 1;

		// Do this for as long as there are elements in the queue
		while (!queue.isEmpty())
		{
		    // Its BFS, so we finish all the elements in the queue at this point
			for (int i = queue.size(); i > 0; i--)
			{
				String w = queue.poll();

				// If the word on the queue is same as the end word, return level
				if (w.equals(endWord))
				    return level;

				// Otherwise, loop through each letters of this word
				for (int j = 0; j < w.length(); j++) 
				{
					char[] ch = w.toCharArray();

					// Loop through A -> Z
					for (char c = 'a'; c <= 'z'; c++) 
					{
					    // Skip the same character
						if (c == w.charAt(j)) 
						    continue;
						
						ch[j] = c;
						String newWord = String.valueOf(ch);

						// Add the new word on to the queue if 1) this new word is a valid word, 2) it has not been visited.
						if (dict.contains(newWord) && visited.add(newWord))
						    queue.offer(newWord);
					}
				}
			}

			level++;
		}
		return 0;
	}

}
