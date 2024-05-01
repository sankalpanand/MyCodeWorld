import java.util.Scanner;

public class Routing {

	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		String line = in.nextLine().trim();
		int R = Integer.parseInt(line.split(" ")[0]);
		int C = Integer.parseInt(line.split(" ")[1]);

		int[][] mat = new int[R][C];
		for (int i = 0; i < R; i++) 
		{
			String[] split = in.nextLine().split(" ");
			for (int j = 0; j < split.length; j++) 
			{
				mat[i][j] = Integer.parseInt(split[j]);
			}
		}
		in.close();

		int[][] sol = new int[R][C];
		helper(mat, 0, 0, sol, 0);
		System.out.println(paths);
		System.out.println(totalSteps);

	}

	static int paths = 0;
	static int totalSteps = 0;

	public static boolean helper(int[][] maze, int x, int y, int[][] sol, int steps)
	{
		int N = maze.length;

		// Reached destination, so return true
		if(x == N-1 && y == N-1)
		{
			sol[x][y] = 1;
			paths++;
			totalSteps = steps+1;
			return true;
		}

		// Check if maze[x][y] is valid
		if(isSafe(maze, x, y) == true)
		{
			// mark x,y as part of solution path
			sol[x][y] = 1;

			// Check in up direction
			if (helper(maze, x-1, y, sol, steps+1) == true)
				return true;

			// Check in down direction
			if (helper(maze, x+1, y, sol, steps+1) == true)
				return true;

			// Check in right direction
			if (helper(maze, x, y+1, sol, steps+1) == true)
				return true;

			// Check in left direction
			if (helper(maze, x, y-1, sol, steps+1) == true)
				return true;

			// None of the movement worked. So backtrack.
			sol[x][y] = 0;
			return false;
		}   

		return false;
	}

	static boolean isSafe(int[][] maze, int x, int y)
	{
		// if (x,y outside maze) return false
		if(x >= 0 && x < maze.length && y >= 0 && y < maze.length && maze[x][y] == 1)
			return true;

		return false;
	}


}

