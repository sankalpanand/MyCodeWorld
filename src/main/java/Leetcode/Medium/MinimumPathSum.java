package Leetcode.Medium;

public class MinimumPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// Above logic can be merged into single for loop
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] cost = new int[m][n];
        
        // Start from top left and go till bottom right and fill these
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(i==0 && j==0)
                    cost[i][j] = grid[i][j];
                
                else if(i==0 && j!= 0)
                    cost[i][j] = cost[i][j-1] + grid[i][j];
                
                else if(j==0 && i!= 0)
                    cost[i][j] = cost[i-1][j] + grid[i][j];
                
                else
                    cost[i][j] = grid[i][j] + Math.min(cost[i-1][j], cost[i][j-1]);
            }
        }
        
        return cost[m-1][n-1];
        
    }
    
	public int minPathSum3(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] cost = new int[m][n];
        
        // Initialize first Column
        for(int i=1; i<m; i++)
        {
            cost[i][0] = cost[i-1][0] + grid[i][0];
        }
        
        // Initialize first Row
        for(int i=1; i<n; i++)
        {
            cost[0][i] = cost[0][i-1] + grid[0][i];
        }
        
        // Start from top left and go till bottom right and fill these
        for(int i=1; i<m; i++)
        {
            for(int j=1; j<m; j++)
            {
                cost[i][j] = cost[i][j] + Math.min(cost[i-1][j], cost[i][j-1]);
            }
        }
        
        return cost[m-1][n-1];
        
    }
	
	// Above logic can be merged into single for loop
    public int minPathSum2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] cost = new int[m][n];
        
        // Initialize first Column
        for(int i=1; i<m; i++)
        {
            cost[i][0] = cost[i-1][0] + grid[i][0];
        }
        
        // Initialize first Row
        for(int i=1; i<n; i++)
        {
            cost[0][i] = cost[0][i-1] + grid[0][i];
        }
        
        // Start from top left and go till bottom right and fill these
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(i==0 && j==0)
                    cost[i][j] = 0;
                
                else if(i==0 && j!= 0)
                    cost[i][j] = cost[0][j-1] + grid[i][j];
                
                else if(j==0 && i!= 0)
                    cost[i][j] = cost[i-1][j] + grid[i][j];
                
                else
                    cost[i][j] = cost[i][j] + Math.min(cost[i-1][j], cost[i][j-1]);
            }
        }
        
        return cost[m-1][n-1];
        
    }

}
