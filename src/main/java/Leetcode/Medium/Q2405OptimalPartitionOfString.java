package main.java.Leetcode.Medium;

import java.util.Arrays;

public class Q2405OptimalPartitionOfString {
    public static void main(String[] args) {
        Q2405OptimalPartitionOfString obj = new Q2405OptimalPartitionOfString();
        obj.partitionString("abacaba");
    }

    // Example, abacaba has a result of 4
    public int partitionString(String s) {
        int[] lastSeen = new int[26];
        Arrays.fill(lastSeen, -1);
        int count = 1, substringStart = 0;

        for (int i = 0; i < s.length(); i++) {
            if (lastSeen[s.charAt(i) - 'a'] >= substringStart) {
                count++;
                substringStart = i;
            }
            lastSeen[s.charAt(i) - 'a'] = i;
        }

        return count;
    }

    /*
    when we write shift = c - 'a', we get the values shift = 0 for 'a', 1 for 'b', and so on till 'z' = 25. When we do 1<<shift that is just to uniquely represent each character in the mask. Doing 1<<shift yields :
    For 'a' we have 00001,
    For 'b' we have 00010,
    For 'c' we have 00100 and so on.
    For a string s = "abda", we will have mask = 01011 for the first 3 characters.
    Now when we encounter 'a' (index=3) we see mask & (1<<shift) will be (01011 & 00001) = 1 indicating that 'a' was already encountered before
    hence we make a new substring from here.
     */
    public int partitionStringBM(String s) {
        int ans = 1;
        int mask = 0;
        for (char ch : s.toCharArray()) {
            int shift = ch - 'a';
            // If the character has been seen before, then increase the count and reset the mask
            if ((mask & (1 << shift)) > 0) {
                ans++;
                mask = 0;
            }

            // Update the current character seen/unseen on the mask
            mask = mask | (1<<shift);
        }
        return ans;
    }
}
