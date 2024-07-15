package Leetcode.Medium;

import java.util.HashMap;

public class Q76MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";

        Q76MinimumWindowSubstring obj = new Q76MinimumWindowSubstring();
        System.out.println(obj.minWindow(s, t));
    }

    // Neetcode - https://www.youtube.com/watch?v=jSto0O4AJbM
    // Leetcode - https://leetcode.com/problems/minimum-window-substring/description/
    public String minWindow(String s, String t) {
        if (t.isEmpty()) return "";

        HashMap<Character, Integer> targetMap = new HashMap<>();
        HashMap<Character, Integer> windowMap = new HashMap<>();

        for (char c : t.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        int have = 0, need = targetMap.size();
        int[] res = {-1, -1};
        int resLen = Integer.MAX_VALUE;
        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);

            // If the char count for this character is the same in both the maps, increase the counter
            if (targetMap.containsKey(c) && windowMap.get(c).equals(targetMap.get(c))) {
                have++;
            }

            // If we found the characters in this sliding window, we need to store the index and the minimum.
            // It is possible that we may find a shorter window in the future
            while (have == need) {
                if (r - l + 1 < resLen) {
                    res[0] = l;
                    res[1] = r;
                    resLen = r - l + 1;
                }

                // Now its time to shrink the window. Move the left pointer by 1. Decrease the freq.
                windowMap.put(s.charAt(l), windowMap.get(s.charAt(l)) - 1);

                // If the counter falls below what's needed, then reduce have count.
                if (targetMap.containsKey(s.charAt(l)) && windowMap.get(s.charAt(l)) < targetMap.get(s.charAt(l))) {
                    have--;
                }
                l++;
            }
        }

        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }

}
