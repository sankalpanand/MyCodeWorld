package Leetcode.Hard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadder2 {


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	Map<String,List<String>> map;
	List<List<String>> results;

	public List<List<String>> findLadders(String start, String end, Set<String> dict) 
	{     
		results = new ArrayList<List<String>>();

		if (dict.size() == 0)
			return results;

		int min = Integer.MAX_VALUE;

		Queue<String> queue= new ArrayDeque<String>();
		queue.add(start);
		
		// This dictionary contains every word that can be reached from the key word by replacing one letter
		map = new HashMap<String,List<String>>();


		// Prepare a ladder by putting all the values in the dictionary AND the starting value
		// Set all the distances to infinite as per Dijkstra algorithm
		Map<String,Integer> ladder = new HashMap<String,Integer>();        
		for (String string : dict)
			ladder.put(string, Integer.MAX_VALUE);        
		ladder.put(start, 0);

		// Add end to the dictionary.
		dict.add(end);


		//BFS: Dijisktra search
		// Queue starts with just 1 element, which is start
		while (!queue.isEmpty()) 
		{
			String word = queue.poll();

			//'step' indicates how many steps are needed to travel to one word.
			// We are adding 1 because we picked one word from the queue, 
			// and we are going to replace each letter and 
			// then verify if that letter exists in the dictionary or not.
			// Since each new letter formed will be one more step ahead than the nummber of 
			// steps required to reach the current woord in the queue, we add 1 to it.
			int step = ladder.get(word) + 1;

			if (step > min) break;

			// Iterate over each letter of the currently processed word
			for (int i = 0; i < word.length(); i++)
			{
				// Convert word into stringbuilder
				StringBuilder builder = new StringBuilder(word);
				
				// Iterate over the character set from A-Z
				for (char ch='a';  ch <= 'z'; ch++)
				{
					// Change the character at i'th place
					builder.setCharAt(i,ch);
					String new_word=builder.toString();             
					
					// Now since the new word is formed, check if it is present in the ladder or now.
					// Right now, the ladder contains only the dictionary and the start word
					if (ladder.containsKey(new_word)) 
					{
						// Check the number of steps needed to reach that word if it has already been reached.
						// If the steps (+1) required to reach this new word exceeds the value already set to it, don't change anything.
						// We will stick to the current value as it is shorter.
						if (step > ladder.get(new_word))
							continue;
						
						// If the steps (+1) required to reach this new word is less than the value already set for it
						// Update this with the new value. 
						// In this process all the infinite values will be set.
						else if (step < ladder.get(new_word))
						{
							// Also, add that word in the queue because we will try to explore further from this point in the next iteration.
							queue.add(new_word);
							ladder.put(new_word, step);
						}
						else;
						// It is a KEY line. If one word already appeared in one ladder,
						// Do not insert the same word inside the queue twice. Otherwise it gets TLE.

						// Till this point, we have updated the distances in the ladder
						// Now add the new word to the list of possible word for the current key word in the queue 
						if (map.containsKey(new_word)) 
							map.get(new_word).add(word);
						else
						{
							List<String> list= new LinkedList<String>();
							list.add(word);
							map.put(new_word,list);							
						}
						
						// If, the new word reaches the end, then update the min
						if (new_word.equals(end))
							min = step;

					}//End if dict contains new_word
				}//End:Iteration from 'a' to 'z'
			}//End:Iteration from the first to the last
		}//End While. At this point, queue is empty

		//BackTracking
		LinkedList<String> result = new LinkedList<String>();
		backTrace(end, start, result);

		return results;        
	}

	private void backTrace(String word, String start, List<String> list)
	{
		if (word.equals(start))
		{
			list.add(0,start);
			results.add(new ArrayList<String>(list));
			list.remove(0);
			return;
		}
		
		// While going back, the word is not the start, so add it to the list. 
		list.add(0, word);
		
		// Find all the words that can be reached from the 'word' by 1 letter change.
		// Each word will be passed recursively in this function.
		// At any point, if the start word is reached, the list is added to the result
		// Therefore, every possible path will be explored while reaching to the start.
		if (map.get(word) != null)
			for (String s: map.get(word))
				backTrace(s, start, list);
		
		list.remove(0);
	}
}