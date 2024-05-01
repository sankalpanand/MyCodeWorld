
public class MazeProblem 
{

	public static void main(String[] args) 
	{

		int[][] maze  =  
			{ 
					{1, 0, 0, 0},
					{1, 1, 0, 1},
					{0, 1, 0, 0},
					{1, 1, 1, 1}
			};

		solveMaze(maze);
	}

	/* This function solves the Maze problem using Backtracking.  It mainly uses
	solveMazeUtil() to solve the problem. It returns false if no path is possible,
	otherwise return true and prints the path in the form of 1s. Please note that
	there may be more than one solutions, this function prints one of the feasible
	solutions.*/
	public static boolean solveMaze(int[][] maze)
	{
		int[][] sol = 
			{ 
					{0, 0, 0, 0},
					{0, 0, 0, 0},
					{0, 0, 0, 0},
					{0, 0, 0, 0}
			};

		if(helper(maze, 0, 0, sol) == false)
		{
			System.out.println("Solution doesn't exist");
			return false;
		}

		printSolution(sol);
		return true;
	}
	
	/* A recursive utility function to solve Maze problem */
	public static boolean helper(int[][] maze, int x, int y, int[][] sol)
	{
		int N = maze.length;

		// Reached destination, so return true
		if(x == N-1 && y == N-1)
		{
			sol[x][y] = 1;
			return true;
		}

		// Check if maze[x][y] is valid
		if(isSafe(maze, x, y) == true)
		{
			// mark x,y as part of solution path
			sol[x][y] = 1;

			/* Move forward in x direction */
			if (helper(maze, x+1, y, sol) == true)
				return true;

			/* If moving in x direction doesn't give solution then
	           Move down in y direction  */
			if (helper(maze, x, y+1, sol) == true)
				return true;

			/* If none of the above movements work then BACKTRACK: 
	            unmark x,y as part of solution path */
			sol[x][y] = 0;
			return false;
		}   

		return false;
	}

	/* A utility function to check if x,y is valid getCellIndex for N*N maze */
	static boolean isSafe(int[][] maze, int x, int y)
	{
		// if (x,y outside maze) return false
		if(x >= 0 && x < maze.length && y >= 0 && y < maze.length && maze[x][y] == 1)
			return true;

		return false;
	}

	public static void printSolution(int[][] maze)
	{
		for(int i=0; i<maze.length; i++)
		{
			for(int j=0; j<maze.length; j++)
			{
				System.out.print(maze[i][j] + " ");
			}
			System.out.println();
		}
	}

}
