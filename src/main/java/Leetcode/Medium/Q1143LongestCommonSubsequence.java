package main.java.Leetcode.Medium;

public class Q1143LongestCommonSubsequence {

    public static void main(String[] args) {
        Q1143LongestCommonSubsequence obj = new Q1143LongestCommonSubsequence();
        int res = obj.longestCommonSubsequence_DP_BottomUp("abcde", "ace");
        System.out.println(res);
    }

    // https://leetcode.com/problems/longest-common-subsequence/solutions/590781/from-brute-force-to-dp/
    //
    // O(2^(m+n))
    public int longestCommonSubsequence_BruteForce(String text1, String text2) {
        return longestCommonSubsequence(text1, text2, 0, 0);
    }

    private int longestCommonSubsequence(String text1, String text2, int i, int j) {
        if (i == text1.length() || j == text2.length())
            return 0;
        if (text1.charAt(i) == text2.charAt(j))
            return 1 + longestCommonSubsequence(text1, text2, i + 1, j + 1);
        else
            return Math.max(
                    longestCommonSubsequence(text1, text2, i + 1, j),
                    longestCommonSubsequence(text1, text2, i, j + 1)
            );
    }

    //  while the rest are O(m*n)
    // https://leetcode.com/problems/longest-common-subsequence/solutions/348884/c-with-picture-o-nm
    public int longestCommonSubsequence_DP_BottomUp(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
