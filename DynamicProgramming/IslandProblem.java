
public class IslandProblem {

	public static void main(String[] args) {

		int[][] mat= {  {1, 1, 0, 0, 0},
				        {0, 1, 0, 0, 1},
				        {1, 0, 0, 1, 1},
				        {0, 0, 0, 0, 0},
				        {1, 0, 1, 0, 1}
		    };
		
		System.out.println(countIslands(mat));

	}
	
	public static int ROW;
	public static int COL;
	
	/* This is the main function which will start with [0][0] 
	 * and for each cell it will send a call to DFS() to each of its 8 neighbors which will mark nodes as visited.
	 * */
	
	public static int countIslands(int[][] mat)
	{
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
				if(mat[i][j] == 1 && !visited[i][j])
				{
					DFS(mat, i, j, visited);
					count++;
				}
			}
		}
		
		return count;
	}
	
	public static void DFS(int[][] mat, int row, int col, boolean[][] visited)
	{
		int[] rowNbr = {-1, -1, -1, 0, 0, 1, 1, 1};
		int[] colNbr = {-1, 0, 1, -1, 1, -1, 0, 1};
		
		visited[row][col] = true;
		
		for (int i = 0; i < 8; i++) 
		{
			if (ifSafe(mat, row + rowNbr[i], col + colNbr[i], visited) )
	            DFS(mat, row + rowNbr[i], col + colNbr[i], visited);
		}
		
	}
	
	public static boolean ifSafe(int[][] mat, int row, int col, boolean[][] visited)
	{
		return (row >= 0) && (row < ROW) &&     // row number is in range
		           (col >= 0) && (col < COL) &&     // column number is in range
		           (mat[row][col] == 1 && !visited[row][col]); // value is 1 and not yet visited
	}
	
	
	

}
