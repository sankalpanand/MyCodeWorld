import java.util.Scanner;

public class ValidFlag {

	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		String line = in.nextLine().trim();
		int T = Integer.parseInt(line);

		// Go through each test case
		for(int i=1; i<=T; i++)
		{
			line = in.nextLine().trim();
			
			int N = Integer.parseInt(line.split(" ")[0]);			
			int M = Integer.parseInt(line.split(" ")[1]);
			
			String[] rows = new String[N];

			Boolean result = true;
			
			// Parse rows of one test case
			for(int j=0; j<N; j++)
			{
				// result = true;

				rows[j] = in.nextLine().trim();
				if(! checkRow(rows[j]))
				{
					// System.out.println("NO");
					result = false;
					// break;
				}

				if(j>0 && rows[j].equals(rows[j-1]))
				{
					// System.out.println("NO");
					result = false;
					// break;
				}

			}
			
			if(result == true)
				System.out.println("YES");
			else
				System.out.println("NO");
		}

		in.close();

	}

	public static boolean checkRow(String row)
	{
		char[] r = row.toCharArray();
		for(int i=1; i<r.length; i++)
		{
			if(r[i] != r[i-1])
			{
				return false;
			}
		}
		return true;
	}
}
