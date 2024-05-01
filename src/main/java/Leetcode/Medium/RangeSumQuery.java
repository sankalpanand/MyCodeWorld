package Leetcode.Medium;

public class RangeSumQuery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private int[][] dp;

	// https://leetcode.com/discuss/69424/clean-c-solution-and-explaination-o-mn-space-with-o-1-time
	public RangeSumQuery(int[][] matrix) 
	{
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0 )
			return;   

		int m = matrix.length;
		int n = matrix[0].length;

		// sums[i+1][j+1] represents the sum of area from matrix[0][0] to matrix[i][j]
		dp = new int[m + 1][n + 1];
		
		for(int i = 1; i <= m; i++)
		{
			for(int j = 1; j <= n; j++)
			{
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i - 1][j - 1] ;
			}
		}
	}

	public int sumRegion(int row1, int col1, int row2, int col2) 
	{
		int iMin = Math.min(row1, row2);
		int iMax = Math.max(row1, row2);

		int jMin = Math.min(col1, col2);
		int jMax = Math.max(col1, col2);

		return dp[iMax + 1][jMax + 1] - dp[iMax + 1][jMin] - dp[iMin][jMax + 1] + dp[iMin][jMin];    
	}

}
