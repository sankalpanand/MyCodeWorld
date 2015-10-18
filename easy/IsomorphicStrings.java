package easy;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

public class IsomorphicStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "apple";
		String s2 = "ellpa";
		System.out.println(isIsomorphic(s1, s2));
	}

	public static boolean isIsomorphic(String s, String t) 
	{
		// We take twice the ascii character sized array
		int[] m = new int[512];

		for (int i = 0; i < s.length(); i++) 
		{
			if (m[s.charAt(i)] != m[t.charAt(i)+256]) 
				return false;

			m[s.charAt(i)] = m[t.charAt(i)+256] = i+1;
		}
		return true;
	}

	public boolean isIsomorphic1(String s, String t) 
	{
		if(s == null || s.length() <= 1) 
			return true;

		HashMap<Character, Character> map = new HashMap<Character, Character>();
		
		// Iterate through each and every character
		// We will put <char a, char b> in the hash map whereever char a occurs
		for(int i = 0 ; i< s.length(); i++)
		{
			char a = s.charAt(i);
			char b = t.charAt(i);

			// Check whether char a has char b as the value?
			if(map.containsKey(a))
			{
				// If yes, continue with the next value
				if(map.get(a).equals(b))
					continue;
				
				// Else, break the loop. Test failed.
				else
					return false;
			}

			// a is not there in the map. Add it.
			else
			{
				if(!map.containsValue(b))
					map.put(a,b);
				else 
					return false;

			}
		}
		return true;
	}
}

