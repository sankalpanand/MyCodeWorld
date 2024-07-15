package Leetcode.Hard;

public class EditDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// Neetcode - https://www.youtube.com/watch?v=XYi2-LPrwm4
    // Leetcode - https://leetcode.com/problems/edit-distance/
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        // Initialize dp array with infinity
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        // Base cases
        for (int j = 0; j <= n; j++) {
            dp[m][j] = n - j;
        }

        for (int i = 0; i <= m; i++) {
            dp[i][n] = m - i;
        }

        // Fill dp array
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i + 1][j], Math.min(dp[i][j + 1], dp[i + 1][j + 1]));
                }
            }
        }

        return dp[0][0];
    }
}
