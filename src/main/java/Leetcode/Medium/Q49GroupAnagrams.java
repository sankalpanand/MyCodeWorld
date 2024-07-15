package Leetcode.Medium;
import Leetcode.ParentClasses.StringManipulation;

import java.util.*;

public class Q49GroupAnagrams extends StringManipulation {

	public static void main(String[] args) {
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

		Q49GroupAnagrams obj = new Q49GroupAnagrams();
		System.out.println(obj.groupAnagrams(strs));
	}

	// Approach 1, sort each word and all anagrams will reduce to single word but it's complexity will be O (n log n) * m
	// Approach 2, keep a map of char freq for each word and group elements that way
	// https://www.youtube.com/watch?v=vzdNOK2oB2E
	// https://leetcode.com/problems/group-anagrams/description/
	public List<List<String>> groupAnagrams(String[] strs) {
		if (strs == null || strs.length == 0)
			return new ArrayList<>();

		Map<String, List<String>> map = new HashMap<>();

		for (String s : strs) {
			char[] ca = new char[26];
			for (char c : s.toCharArray())
				ca[c - 'a']++;

			String keyStr = String.valueOf(ca);
			if (!map.containsKey(keyStr))
				map.put(keyStr, new ArrayList<>());

			map.get(keyStr).add(s);
		}
		return new ArrayList<>(map.values());
	}

}
