package Leetcode.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q1002FindCommonCharacters {
    public static void main(String[] args) {

    }

    public List<String> commonChars(String[] A) {
        List<String> ans = new ArrayList<>();
        int[] count = new int[26];
        Arrays.fill(count, Integer.MAX_VALUE);

        for (String str : A) {
            // Store char frequency in the current word in a local array
            int[] cnt = new int[26];
            str.chars().forEach(c -> cnt[c - 'a']++);

            // Update the global map with the min freq for the same character
            for (int i = 0; i < 26; ++i) {              // update minimum frequency.
                count[i] = Math.min(cnt[i], count[i]);
            }
        }

        for (char c = 'a'; c <= 'z'; ++c) {
            while (count[c - 'a']-- > 0)
                ans.add("" + c);
        }
        return ans;
    }
}
