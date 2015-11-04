package easy;

import java.util.HashMap;

public class IsomorphicStrings {

	public static void main(String[] args) {
		String s1 = "apple";
		String s2 = "ellpa";
		System.out.println(isIsomorphic(s1, s2));
	}

	/*
    Store the last seen positions of current (i-th) characters in both strings. 
    If previously stored positions are different then we know that the fact they're occuring in the current i-th position simultaneously is a mistake. 
    */
    public static boolean isIsomorphic(String s, String t) {
        
		// We take twice the ascii character sized array
		int[] m = new int[512];

		for (int i = 0; i < s.length(); i++) 
		{
			if (m[s.charAt(i)] != m[t.charAt(i)+256]) 
				return false;

            // We are storing i+1 because the default value is zero. If we store zero, then it will always match even if it is a mismatch.
            // For example input = aa, ab. Second time check mein a par jo value hai, wahi b par bhi milni chahiye.
            // Ideally b zero hoga but a pe kuchh value store honi chahiye first time se.
            // But, since first time pe humne 0 hi store kiya tha, to ye test case capture nahi hoga. 
            // Isliye hum 0 store karne se bach rahe hain.
			m[s.charAt(i)] =  i+1;
			m[t.charAt(i)+256] = i+1;
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

