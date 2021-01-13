package Leetcode.Medium;

public class NumberOfIslands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int ROW;
	public static int COL;
	
    // A group of connected 1s is called an island
    // https://www.youtube.com/watch?v=o8S2bO3pmO4
    public static int numIslands(char[][] mat) {
        
        if(mat.length == 0 || mat[0].length == 0)
        	return 0;

        ROW = mat.length;
		COL = mat[0].length;

		// Make a boolean matrix that will keep track whether a cell is visited or not
		boolean[][] visited = new boolean[ROW][COL];
		
		// We start counting the total number of DFS calls.
		int count = 0;

		for (int i = 0; i < ROW; i++) 
		{
			for (int j = 0; j < COL; j++) 
			{
				// If the cell is unvisited and is Land (1) check its neighbors by calling DFS()
				// This cell will be marked as visited in this process.
				// This cell will make a recursive call to each of their own 8 neighbors.	
				// The base case of that recursion will be when all nodes of the subgraph have been visited
				if(mat[i][j] == '1' && !visited[i][j])
				{
					DFS(mat, i, j, visited);

					// After the above call is finished, a lot more 1s would've been converted into 0s.
					// Now the next time the above condition will be true will be when there is a disconnected 1 found.
					count++;
				}
			}
		}
		
		return count;
    }
    
    public static void DFS(char[][] mat, int row, int col, boolean[][] visited)
	{
	    // In an ideal island problem, there are 8 neighbors. But here in leetcode, we are considering only 4 neighbors.
		int[] rowNbr = {-1, 0, 0, 1};
		int[] colNbr = {0, -1, 1, 0};
		
		// Mark the row as visited
		visited[row][col] = true;
		
		for (int i = 0; i < 4; i++) 
		{
			if (ifSafe(mat, row + rowNbr[i], col + colNbr[i], visited))
				DFS(mat, row + rowNbr[i], col + colNbr[i], visited);
		}
	}
	
	public static boolean ifSafe(char[][] mat, int row, int col, boolean[][] visited)
	{
	    // Perform 3 checks as follows-
	    
		return (row >= 0) && (row < ROW) &&     // row number is in range
		           (col >= 0) && (col < COL) &&     // column number is in range
		           (mat[row][col] == '1' && !visited[row][col]); // value is 1 and not yet visited
	}

}
