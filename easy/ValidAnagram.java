package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ValidAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isAnagram1("nagaram", "anagram"));

	}
	
	// Step 1: Make an integer array of 26 size
	// Step 2: While parsing array 1, if any character appears, increase the count of it by 1
	// Step 3: While parsing array 2, if any character appears, decrease the count of it by 1
	// Step 4: If integer array has any value that is not zero, Strings are not anagrams
	public static boolean isAnagram1(String s, String t) 
	{
		int[] count = new int[26];
        for(int i=0; i<s.length(); i++) count[s.charAt(i) - 'a']++;
        for(int i=0; i<t.length(); i++) count[t.charAt(i) - 'a']--;
        for(int x : count) if(x!=0) return false;
        return true;
	}

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

		List<Character> listS = new ArrayList();
		for(char c : sArr)
		{
			listS.add(c);
		}

		List<Character> listT = new ArrayList();
		for(char c : tArr)
		{
			listT.add(c);
		}

		Collections.sort(listS);
		Collections.sort(listT);

		boolean flag = true;

		for(int i=0; i<= s.length() - 1; i++)
		{
			if(listS.get(i) != listT.get(i))
			{
				return false;
			}
		}

		return flag;
	}

}
