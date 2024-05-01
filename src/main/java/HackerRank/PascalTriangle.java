import java.util.Scanner;

public class PascalTriangle {

	public static void main(String args[] ) throws Exception {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT */
		Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine().trim());
		printFirstNRows(N);

	}

	public static void printFirstNRows(int n)
	{
		// i represents the line number.
		for (int i = 1; i <= n; i++)
		{
			// Every line starts from 1
			int sum = 1; 
			
			// j represents each integer in line
			for (int j = 1; j <= i; j++)  
			{
				System.out.print(sum + " ");
				
				// Calculate the next sum
				sum = sum * (i - j) / j;  
			}
			System.out.println();
		}
	}
}
