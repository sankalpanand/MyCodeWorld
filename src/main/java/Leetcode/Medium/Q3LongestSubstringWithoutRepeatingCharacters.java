package Leetcode.Medium;

import java.util.HashMap;
import java.util.HashSet;

public class Q3LongestSubstringWithoutRepeatingCharacters {

	
	public static void main(String[] args) {
        Q3LongestSubstringWithoutRepeatingCharacters obj = new Q3LongestSubstringWithoutRepeatingCharacters();
		System.out.println(obj.lengthOfLongestSubstring("abcabcbb"));

	}

	// Neetcode - https://www.youtube.com/watch?v=wiGpQwVHdE0
    // Leetcode - https://leetcode.com/problems/longest-substring-without-repeating-characters/
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> charSet = new HashSet<>();
        int l = 0;
        int res = 0;

        for (int r = 0; r < s.length(); r++) {
            while (charSet.contains(s.charAt(r))) {
                charSet.remove(s.charAt(l));
                l++;
            }
            charSet.add(s.charAt(r));
            res = Math.max(res, r - l + 1);
        }
        return res;
    }

}
