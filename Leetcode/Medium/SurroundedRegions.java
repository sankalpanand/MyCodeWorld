package Leetcode.Medium;
import java.util.Stack;


// It is a variant of flood fill problem
// http://www.geeksforgeeks.org/given-matrix-o-x-replace-o-x-surrounded-x/


public class SurroundedRegions 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		char[][] board = {	
				{'X','O', 'X','X'},
				{'O','X', 'O','X'},
				{'X','O', 'X','O'},
				{'O','X', 'O','X'},
				{'X','O', 'X','O'},
				{'O','X', 'O','X'},
		};
		solve(board);

		System.out.println("Done !!");
	}

	public static int M = 0;
	public static int N = 0;

	// We'll try to implement DFS here by maintaining a stack.
	public static void solve(char[][] board) 
	{
		if(board == null || board.length == 0) 
			return;

		M = board.length;
		N = board[0].length;

		// Step 1: Replace all 'O' with '-'
		for(int i=0; i<M; i++)
		{
			for(int j=0; j<N; j++)
			{
				if(board[i][j] == 'O') 
					board[i][j] = '-';
			}

		}

		// Step 2: Call helper() for reverting all '-' lying on the edges to 'O'. 
		// This helper will go deeper to check and convert - back to 0.
		// Helper is a recursive function which starts from the given node and make DFS traversals using stack
		// If I use recursion instead of a stack, I will run into StackOverflow issues

		// Top
		for(int i=0; i<N; i++)
			if(board[0][i] == '-') helper(board, 0, i, '-');

		// Right    
		for(int i=0; i<M; i++)
			if(board[i][N-1] == '-') helper(board, i, N-1, '-'); 

		// Bottom
		for(int i=0; i<N; i++)
			if(board[M-1][i] == '-') helper(board, M-1, i, '-');  

		// Left
		for(int i=0; i<M; i++)
			if(board[i][0] == '-') helper(board, i, 0, '-'); 


		// Step 3: Capture - Change the interior '-' to X as is required
		for(int i=0; i<M; i++)
		{
			for(int j=0; j<N; j++)
			{
				if(board[i][j] == '-') 
					board[i][j] = 'X';
			}
		}

	}

	// This method will convert - to 0 and dig deeper
	public static void helper(char[][] board, int row, int col, char prevVal)
	{	
		Stack<Pair> stack = new Stack<Pair>();
		stack.push(new Pair(row, col));

		while(!stack.isEmpty())
		{
			Pair p = stack.pop();
			
			int newRow = p.row;
			int newCol = p.col;

			board[newRow][newCol] = 'O';

			// Now, send a recursive call to all its neighbors
			// In an ideal island problem, there are 8 neighbors. But here in leetcode, we are considering only 4 neighbors.
			// top | left | right | bottom
			int[] rowNbr = {-1, 0, 0, 1};
			int[] colNbr = {0, -1, 1, 0};

			for (int i = 0; i < 4; i++) 
			{
				// Predict adjacent nodes
				int r = newRow + rowNbr[i];
				int c = newCol + colNbr[i];

				if(!(r < 0 || r >= M || c < 0 || c >=N) // Agar boundary ke andar hai 
						&& board[r][c] == '-') 			// Aur valid "-" hai, to stack par push kar do
					stack.push(new Pair(r, c));
				
			}      			
		}
	}
}

class Pair 
{
	public int row;
	public int col;
	public Pair(int r, int c) 
	{
		row = r;
		col = c;
	}
}
