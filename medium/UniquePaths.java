package medium;

public class UniquePaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int uniquePaths1(int m, int n) {

		// https://leetcode.com/discuss/38353/0ms-5-lines-dp-solution-in-c-with-explanations
		int[][] path = new int[m][n];
		for(int i=0; i<m; i++)
		{
			path[i][0] = 1;
		}

		for(int i=0; i<n; i++)
		{
			path[0][i] = 1;
		}

		for(int i=1; i<m; i++)
		{
			for(int j=1; j<n; j++)
			{
				path[i][j] = path[i-1][j] + path[i][j-1];
			}

		}

		return path[m-1][n-1];

	}

	// Using just 1d array
	public int uniquePaths(int m, int n) {
		if (m == 0 || n == 0) {
			return 0;
		}
		if (m == 1 || n == 1) {
			return 1;
		}

		int[] dp = new int[n];
		for (int i = 0; i < n; i++) {
			dp[i] = 1;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[j] += dp[j - 1];
			}
		}
		return dp[n - 1];
	}

}
