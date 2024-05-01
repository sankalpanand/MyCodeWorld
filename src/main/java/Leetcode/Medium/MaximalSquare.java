package Leetcode.Medium;

public class MaximalSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// http://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/
	public int maximalSquare(char[][] a) 
	{
		if (a == null || a.length == 0 || a[0].length == 0)
			return 0;

		int max = 0;
		int n = a.length;
		int m = a[0].length;

		// dp(i, j) represents the length of the square whose lower-right corner ends at (i, j)
		// dp(i, j) = min{ dp(i-1, j-1), dp(i-1, j), dp(i, j-1) }
		int[][] dp = new int[n + 1][m + 1];

		for (int i = 1; i <= n; i++) 
		{
			for (int j = 1; j <= m; j++) 
			{
				// If zero, do nothing
				if (a[i - 1][j - 1] == '1') 
				{
					int top = dp[i - 1][j];
					int left = dp[i][j - 1];
					int topLeft = dp[i - 1][j - 1];
					
					dp[i][j] = Math.min(topLeft, Math.min(top, left)) + 1;
					
					// This is calculating max on the fly
					max = Math.max(max, dp[i][j]);
				}
			}
		}

		// return the area
		return max * max;
	}

}
