package Leetcode.Medium;

public class Q516LongestPalindromicSubsequence {

    // https://www.youtube.com/watch?v=_nCsPn7_OgI&t=57s
    // https://leetcode.com/problems/longest-palindromic-subsequence/solutions/3414715/easy-solutions-in-java-python-and-c-look-at-once-with-exaplanation/
    public static void main(String[] args) {
        Q516LongestPalindromicSubsequence obj = new Q516LongestPalindromicSubsequence();
        int res = obj.longestPalindromeSubseq("bbbab");
        System.out.println(res);
    }

    // Exactly similar to Q1143 longest common subsequence
    public int longestPalindromeSubseq(String text1) {
        String text2 = new StringBuilder(text1).reverse().toString();

        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = text1.length() - 1; i >= 0; i--) {
            for (int j = text2.length() - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j))
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                else
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
            }
        }
        return dp[0][0];
    }


}
