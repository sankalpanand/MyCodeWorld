import java.util.Scanner;

public class InputTemplate {
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

	}
}
