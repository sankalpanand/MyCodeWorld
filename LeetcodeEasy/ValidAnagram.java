package LeetcodeEasy;

import java.util.*;

public class ValidAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isAnagram1("nagaram", "anagram"));

	}
	
	// Time efficient- Hash Map
	public static boolean isAnagram1(String s, String t) 
	{
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(Character ch : s.toCharArray())
		{
			if(map.containsKey(ch))
				map.put(ch, map.get(ch)+1);
			else
				map.put(ch, 1);
		}
		
		for(Character ch : t.toCharArray())
		{
			if(map.containsKey(ch))
			{
				int count = map.get(ch);
				if(count == 1) map.remove(ch);
				else map.put(ch, count-1); 				
			}
			else
				return false;
		}
		
		return map.keySet().size() == 0;
	}
	
	// Space efficient- Array mein daal ke sort kar lo
	public static boolean isAnagram(String s, String t) 
	{
		if(s.length() != t.length())
		{
			return false;
		}
		
		if(s.length() == 0 && t.length() == 0)
		    return true;
		
		char[] sArr = s.toCharArray();
		char[] tArr = t.toCharArray();
		
		Arrays.sort(sArr);
		Arrays.sort(tArr);

		
		for(int i=0; i<= s.length() - 1; i++)
		{
			if(sArr[i] != tArr[i]) return false;
		}

		return true;
	}

}
