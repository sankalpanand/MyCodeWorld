package Leetcode.Medium;

public class Q424LongestRepeatingCharacterReplacement {

    // Neetcode - https://www.youtube.com/watch?v=gqXU1UyA8pk
    // Nick White - https://www.youtube.com/watch?v=00FmUN1pkGE

    public static void main(String[] args) {
        Q424LongestRepeatingCharacterReplacement obj = new Q424LongestRepeatingCharacterReplacement();
        System.out.println(obj.characterReplacement("ABAB", 2));
        System.out.println(obj.characterReplacement("AABABBA", 1 ));

        // A A B A B B A
        // 0 1 2 3 4 5 6, start=2, end=6, len=5, end-start+1 = 5
    }

    public int characterReplacement(String s, int k) {
        int len = s.length();
        int[] count = new int[26];
        int start = 0;
        int maxCount = 0;       // Max count of letters in a sliding window
        int maxLength = 0;

        for (int end = 0; end < len; end++) {
            // Increase the char count of the current character
            count[s.charAt(end) - 'A']++;

            // Maybe this character may have updated the max count in the sliding window, so update that variable
            maxCount = Math.max(maxCount, count[s.charAt(end) - 'A']);

            // While number of non-max characters remain greater than k, keep shrinking the window
            while (end - start + 1 - maxCount > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }

            // Until this we have shrank the window to bring back into the k limit
            // Now update the max length
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}
