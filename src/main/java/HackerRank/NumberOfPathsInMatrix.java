
public class NumberOfPathsInMatrix {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int a = (int) Math.pow(10, 9);
		System.out.println(a);

	}
	
	public int numberOfPaths(int [][]a, int m, int n) 
	{
		
		int[][] path = new int[m][n];

		for (int i = 0; i < m; i++) 
		{
			//on the first column, if there is an obstacle, the rest are blocked. 
			//no need to continue.
			if (a[i][0] == 0)  
			{
				path[i][0] = 1;				
				break;  
			} 
			
			else
				// Otherwise, there is one way to reach all these blocks in the first column
				path[i][0] = 0;
		}

		for (int j = 0; j < n; j++) 
		{
			//on the first column, if there is an obstacle, the rest are blocked. 
			//no need to continue.
			if (a[0][j] == 0)  
			{
				path[0][j] = 1;				
				break; 
			} 
			else
				path[0][j] = 0;
		}

		for (int i = 1; i < m; i++) 
		{
			for (int j = 1; j < n; j++) 
			{
				if (a[i][j] == 0) 
					path[i][j] = 1;
				else
					path[i][j] = path[i-1][j] + path[i][j-1];
			}
		}
		
		int ans = path[m-1][n-1];
		ans = ans % ((int) Math.pow(10, 9) + 7);
		
		return ans;

	}

}
