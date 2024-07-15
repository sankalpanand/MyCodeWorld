package Leetcode.Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q3030SubstringWithConcatenationOfAllWords {
    // Leetcode - https://leetcode.com/problems/substring-with-concatenation-of-all-words/description/
    //

    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || words == null || s.length() == 0 || words.length == 0) {
            return new ArrayList<>();
        }
        Map<String, Integer> freqCount = new HashMap<>();
        for (String word : words) {
            freqCount.put(word, freqCount.getOrDefault(word, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        int sLen = s.length();
        int num = words.length;
        int wordLen = words[0].length();

        // We don't need to take i to the sLen because the window is num * wordLen
        for (int i = 0; i < sLen - num * wordLen + 1; i++) {
            String sub = s.substring(i, i + num * wordLen);
            if (isConcat(sub, freqCount, wordLen)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean isConcat(String sub, Map<String, Integer> counts, int wordLen) {
        Map<String, Integer> seen = new HashMap<>();
        for (int i = 0; i < sub.length(); i += wordLen) {
            String sWord = sub.substring(i, i + wordLen);
            seen.put(sWord, seen.getOrDefault(sWord, 0) + 1);
        }
        return seen.equals(counts);
    }
}
