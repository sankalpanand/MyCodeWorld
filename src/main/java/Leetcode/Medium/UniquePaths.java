package Leetcode.Medium;

import java.util.Arrays;

public class UniquePaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		uniquePaths(4,4);

	}

	/*
	A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
	The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
	How many possible unique paths are there?
	 */

	// Using just 1d array- Discard previous row results
	public static int uniquePaths(int m, int n) 
	{
		if (m == 0 || n == 0) 
		{
			return 0;
		}
		
		if (m == 1 || n == 1) 
		{
			return 1;
		}

		int[] dp = new int[n];
		
		for (int i = 0; i < n; i++) 
		{
			dp[i] = 1;
		}
		
		System.out.println(Arrays.toString(dp));
		
		// In this approach, we are overwriting over the 1st row while calculating 2nd row.
		for (int i = 1; i < m; i++) 
		{
			// This is independent of outer loop. It means do this process (m-1) times.
			for (int j = 1; j < n; j++) 
			{
				// Add prev and curr values (n-1) times
				dp[j] += dp[j - 1];
			}
			System.out.println(Arrays.toString(dp));
		}
		return dp[n - 1];
	}

	// Using 2d array
	public int uniquePaths1(int m, int n) 
	{
		// https://leetcode.com/discuss/38353/0ms-5-lines-dp-solution-in-c-with-explanations
		int[][] path = new int[m][n];

		// For every cell in the first column, there will be only one unique path
		for(int i=0; i<m; i++)
		{
			path[i][0] = 1;
		}

		// For every cell in the first row, there will be only one unique path
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

}
