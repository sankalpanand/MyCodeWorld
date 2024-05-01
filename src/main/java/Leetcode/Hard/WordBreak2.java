package Leetcode.Hard;

import java.util.*;

public class WordBreak2 {

	/*
	Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

	Return all such possible sentences.
	
	For example, given
	s = "catsanddog",
	dict = ["cat", "cats", "and", "sand", "dog"].
	
	A solution is ["cats and dog", "cat sand dog"].
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> dict = new HashSet<String>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");

		List<String> result = wordBreak("catsanddog", dict); 
		System.out.println(result);

	}

	// https://leetcode.com/discuss/23770/slightly-modified-dp-java-solution
	private static final Map<String, List<String>> cache = new HashMap<>();

    private static boolean containsSuffix(Set<String> dict, String right) 
    {
        for (int i = 0; i < right.length(); i++)
        {
            if (dict.contains(right.substring(i))) 
            	return true;
        }
        return false;
    }

    public static List<String> wordBreak(String s, Set<String> dict) 
    {
        if (cache.containsKey(s)) 
        	return cache.get(s);
        
        List<String> result = new LinkedList<>();
        if (dict.contains(s)) 
        	result.add(s);
        
        for (int i = 1; i < s.length(); i++) 
        {
            String left = s.substring(0,i);
            String right = s.substring(i);
            
            if (dict.contains(left) && containsSuffix(dict, right)) 
            {
                for (String ss : wordBreak(right, dict)) 
                {
                    result.add(left + " " + ss);
                }
            }
        }
        
        cache.put(s, result);
        return result;
    }

}
