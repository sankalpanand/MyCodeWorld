package Leetcode.Medium;

public class Q395LongestSubstringWithAtLeastKRepeatingCharacters {
    public static void main(String[] args) {

    }

    // https://www.youtube.com/watch?v=bHZkCAcj3dc
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0)
            return 0;

        // record the frequency of each character
        char[] chars = new char[26];
        for (int i = 0; i < s.length(); i += 1)
            chars[s.charAt(i) - 'a'] += 1;

        // If all the characters are occurring k times, then the whole string is valid
        boolean flag = true;
        for (int i = 0; i < chars.length; i += 1) {
            if (0< chars[i] && chars[i] < k)
                flag = false;
        }

        // return the length of string if this string is a valid string
        if (flag == true)
            return s.length();


        int result = 0;
        int start = 0, cur = 0;

        // otherwise we use all the infrequent elements as splits
        while (cur < s.length()) {
            // If there are certain characters that occur less than k times, then none of the substring can include those characters
            if (chars[s.charAt(cur) - 'a'] < k) {
                // Current char can not be part of the result, so check for the left substring from start..cur
                result = Math.max(result, longestSubstring(s.substring(start, cur), k));

                // Update start to cur+1 for the next segment
                start = cur + 1;
            }
            cur++;
        }

        // Do it one last time
        result = Math.max(result, longestSubstring(s.substring(start), k));

        return result;
    }
}
