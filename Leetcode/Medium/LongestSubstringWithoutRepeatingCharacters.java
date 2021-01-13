package Leetcode.Medium;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lengthOfLongestSubstring("abba"));

	}
	
	// https://leetcode.com/discuss/23883/11-line-simple-java-solution-o-n-with-explanation
	// https://leetcode.com/discuss/13336/shortest-o-n-dp-solution-with-explanations
	
	/*
	The basic idea is, keep a hashmap which stores the characters in string as keys and their positions as values, 
	and keep two pointers which define the max substring. 
	Move the right pointer to scan through the string , and meanwhile update the hashmap. 
	If the character is already in the hashmap, then move the left pointer to the left of the same character last found. 
	Note that the two pointers can only move forward.
	 * */
    public static int lengthOfLongestSubstring(String s) 
    {
    	if (s.length()==0) 
    		return 0;
    	
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int length = 0;
        int start = 0;
        
        for (int end=0; end < s.length(); end++)
        {
        	// When we have reached a repeated character, then the currently held string is potentially the largest string.
        	// If the character is there in the map, start needs to be changed. 
        	// If it is not there, start remains the same so that it can increase the count
            if (map.containsKey(s.charAt(end)))
            {
            	// Consider input as abba. For b[2], start < map.get(s.charAt(end)) + 1 
            	// For b[3], start > map.get(s.charAt(end)) + 1. It means, if the character has occured towards the beginning, we dont want the start to be modified.
            	start = Math.max(start, map.get(s.charAt(end)) + 1);
            }            
            
            map.put(s.charAt(end), end);
            
            // Why +1? Lets say start=2, end=5. Then the length will be 5-2=3. And, 3+1 = 4.
            length = Math.max(length, end-start+1);
            
        }
        return length;
    }

}
