package Leetcode.Medium;

public class Q791CustomSortString {
    public static void main(String[] args) {
        Q791CustomSortString obj = new Q791CustomSortString();
        System.out.println(obj.customSortString("cba", "abcd"));
    }
    // Leetcode - https://leetcode.com/problems/custom-sort-string/description/
    public String customSortString(String S, String T) {
        int[] count = new int[26];
        for (char c : T.toCharArray()) {
            ++count[c - 'a'];  // count each char in T.
        }

        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            int freq = count[c - 'a'];
            count[c - 'a'] = 0;
            sb.append(String.valueOf(c).repeat(freq));
        }

        // Now put the remaining characters that were in T but not in S
        for (char c = 'a'; c <= 'z'; ++c) {
            int freq = count[c - 'a'];
            count[c - 'a'] = 0;
            sb.append(String.valueOf(c).repeat(freq));
        }
        return sb.toString();
    }
}
