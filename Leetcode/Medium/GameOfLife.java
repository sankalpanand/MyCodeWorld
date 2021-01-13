package Leetcode.Medium;

public class GameOfLife {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void gameOfLife2(int[][] board) 
	{
		int m = board.length; 
		int n = m != 0 ? board[0].length : 0;

		for (int i=0; i<m; ++i) 
		{
			for (int j=0; j<n; ++j) 
			{
				int count = 0;
				for (int I= Math.max(i-1, 0); I< Math.min(i+2, m); ++I)
					for (int J= Math.max(j-1, 0); J< Math.min(j+2, n); ++J)
						count += board[I][J] & 1;

				if (count == 3 || count - board[i][j] == 3)
					board[i][j] |= 2;
			}
		}
		for (int i=0; i<m; ++i)
			for (int j=0; j<n; ++j)
				board[i][j] >>= 1;
	}


	public void gameOfLife(int[][] board) 
	{
		int[] Px = {1, 1, 1, 0, 0, -1, -1, -1};
		int[] Py = {-1, 0, 1, -1, 1, -1, 0, 1};

		// State transitions
		//  0 : dead to dead
		//  1 : live to live
		//  2 : live to dead
		//  3 : dead to live

		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<board[0].length;j++)
			{
				int live = 0;

				// For the current cell (i,j), run a check on all of its 8 neighbors
				for(int k=0; k<8; k++)
				{
					int Nx = Px[k] + i;
					int Ny = Py[k] + j;

					// Check if Px is going out of the board || is Py going out of the board
					if(Nx < 0 || Nx >=board.length || Ny < 0 || Ny >= board[0].length) 
						continue;

					if(board[Nx][Ny] == 1 || board[Nx][Ny] == 2) 
						live++;
				}

				// 4- Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction
				if(board[i][j] == 0 && live==3) 
					board[i][j]=3;

				// 1- Any live cell with fewer than two live neighbors dies, as if caused by under-population
				// 3- Any live cell with more than three live neighbors dies, as if by over-population..
				if(board[i][j]==1 && (live<2 || live>3)) 
					board[i][j]=2;
			}
		}

		for(int i=0;i<board.length;i++)
			for(int j=0;j<board[0].length;j++)
				board[i][j] %=2;
	}

}
