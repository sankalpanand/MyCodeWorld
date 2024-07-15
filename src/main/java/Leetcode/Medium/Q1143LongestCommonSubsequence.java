package Leetcode.Medium;

public class Q1143LongestCommonSubsequence {

    public static void main(String[] args) {
        Q1143LongestCommonSubsequence obj = new Q1143LongestCommonSubsequence();
        int res = obj.longestCommonSubsequence_BottomUp("abcde", "ace");
        System.out.println(res);
    }

    // Neetcode - https://www.youtube.com/watch?v=Ua0GhsJSlWM
    // Leetcode - https://leetcode.com/problems/longest-common-subsequence/description/
    public int longestCommonSubsequence_BottomUp(String text1, String text2) {
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
