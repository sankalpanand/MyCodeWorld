package Leetcode.Medium;
import Leetcode.ParentClasses.StringManipulation;

import java.util.*;

public class Q438FindAllAnagrams extends StringManipulation {

	public static void main(String[] args) {
		Q438FindAllAnagrams obj = new Q438FindAllAnagrams();

		System.out.println(Arrays.toString(obj.findAnagrams_best("cbaebabacd", "abc").toArray()));


	}

	// Leetcode - https://leetcode.com/problems/find-all-anagrams-in-a-string/
	// Took reference from a comment on this post - https://leetcode.com/problems/find-all-anagrams-in-a-string/solutions/92007/sliding-window-algorithm-template-to-solve-all-the-leetcode-substring-search-problem/
	// #TODO Also, this solution has a template for similar problems
	public List<Integer> findAnagrams(String s, String targetStr) {
		List<Integer> ans = new ArrayList<>();

		// Generate frequency map for the target string
		Map<Character, Integer> targetMap = new HashMap<>();
		for(int i=0; i < targetStr.length(); i++)
			targetMap.put(targetStr.charAt(i), targetMap.getOrDefault(targetStr.charAt(i),0)+1);

		Map<Character, Integer> slidingWindowMap = new HashMap<>(); //slidingWindowMap to cache the chars in sliding window
		int left=0, right=0, match=0;

		// This while loop works in two sections- EXPAND and SHRINK
		while(right < s.length()) {

			// EXPAND
			// Agar right character targetMap mein exist karta hai, then slidingWindowMap mein iski freq badhao
			// and check karo ki targetMap se match ho rahi hai ya nahi
			char rightChar = s.charAt(right);
			if(targetMap.containsKey(rightChar)) {
				slidingWindowMap.put(rightChar, slidingWindowMap.getOrDefault(rightChar,0)+1);
				if(slidingWindowMap.get(rightChar).equals(targetMap.get(rightChar)))
					match++;
			}

			// Agar matchCount badhane ke baad uska size targetMap ke barabar ho gaya, then iska matlab result mil gaya hai
			// Result add karne ke baad ek kaam aur karna hai
			// Left se shrink karte jaana hai jab tak ki match mismatch na ho jaaye
			while(match == targetMap.size()) {

				// Result mein daalo and ab left pointer ko aage badha ke sliding window shrink karo
				if(right-left+1 == targetStr.length())
					ans.add(left);

				// SHRINK
				// Now we prepare to shrink, so decrement slidingWindowMap value and match counter
				char leftChar = s.charAt(left);
				if(targetMap.containsKey(leftChar)) {
					slidingWindowMap.put(leftChar, slidingWindowMap.get(leftChar)-1);
					if(slidingWindowMap.get(leftChar) < targetMap.get(leftChar))
						match--;
				}
				left++;
			}

			right++;
		}
		return ans;
	}

	// Neetcode's program is complicated. Use this instead. Very very clear.
	// Leetcode - https://leetcode.com/problems/find-all-anagrams-in-a-string/
	// Techdose - https://www.youtube.com/watch?v=fYgU6Bi2fRg
	public List<Integer> findAnagrams_best(String s, String p) {
		List<Integer> ans = new ArrayList<>();
		int[] hash = new int[26];
		int[] phash = new int[26];
		int window = p.length();
		int lenS = s.length();

		if (lenS < window) {
			return ans;
		}

		int left = 0, right = 0;

		// We need to create a hash first for the smaller string... otherwise we'll keep matching 1 for 1, 2 for 2
		// until get all the characters in the smaller string.
		while (right < window) {
			phash[p.charAt(right) - 'a'] += 1;
			hash[s.charAt(right) - 'a'] += 1;
			right++;
		}

		// We need to decrement r otherwise it'll result in a window of size +1
		right--;

		while (right < lenS) {
			if (matches(phash, hash)) {
				ans.add(left);
			}

			// Increment right pointer and increase its freq
			right++;
			if (right < lenS) {
				hash[s.charAt(right) - 'a'] += 1;
			}

			// Increment left pointer and decrement its freq
			hash[s.charAt(left) - 'a'] -= 1;
			left++;
		}

		return ans;
	}

	private boolean matches(int[] phash, int[] hash) {
		for (int i = 0; i < 26; i++) {
			if (phash[i] != hash[i]) {
				return false;
			}
		}
		return true;
	}
}
