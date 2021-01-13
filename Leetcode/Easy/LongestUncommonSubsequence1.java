package Leetcode.Easy;

public class LongestUncommonSubsequence1 {
    public static void main(String[] args) {

    }

    // https://leetcode.com/problems/longest-uncommon-subsequence-i/description/
    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }

}
