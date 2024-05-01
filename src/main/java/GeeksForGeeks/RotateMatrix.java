
public class RotateMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question6_4();

	}

	// Simplest approach
	public static void Question6() 
	{
		char[][] image = {{'a','b','c','d'},{'e', 'f', 'g', 'h'},{'i', 'j', 'k', 'l'},{'m', 'n', 'o', 'p'}};
		StringBuffer sb = new StringBuffer();

		for(int i=0; i<4; i++)
		{
			for(int j=0; j<4; j++)
			{
				sb.append(image[i][j]);
			}			
		}

		int k = 15;
		for(int i=0; i < 4; i++)
		{
			for(int j=3; j >= 0; j--)
			{
				image[j][i] = sb.charAt(k);
				k--;
			}			
		}

		// For display
		for(int i=0; i<4; i++)
		{
			for(int j=0; j<4; j++)
			{
				System.out.print(image[i][j]);
			}
			System.out.println();
		}

		// System.out.println(sb.toString());
	}

	// GeeksForGeeks - In place
	public static void Question6_4() // Leet code
	{
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		int m = matrix.length;
		int n = matrix[0].length;

		int[][] result = new int[m][n];

		for(int i=0; i<m; i++)
		{
			for(int j=0; j<n; j++)
			{
				result[j][m-1-i] = matrix[i][j];
			}
		} 


		for(int i=0; i<4; i++)
		{
			for(int j=0; j<4; j++)
			{
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}			
	}

	public static void Question6_2() 
	{
		int n = 4;
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};

		for (int layer = 0; layer < n/2; layer++) // will run for 0, 1
		{
			int first = layer;			// 0, 
			int last = n - 1 - layer;	// 3

			for(int i = first; i < last; ++i) 	// (0,1,2) and ()
			{
				int offset = i - first;
				int top = matrix[first][i]; // save top

				// left -> top
				matrix[first][i] = matrix[last-offset][first];          

				// bottom -> left
				matrix[last-offset][first] = matrix[last][last - offset]; 

				// right -> bottom
				matrix[last][last - offset] = matrix[i][last]; 

				// top -> right
				matrix[i][last] = top; // right <- saved top
			}
		}

		// For display
		for(int i=0; i<4; i++)
		{
			for(int j=0; j<4; j++)
			{
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}				
	}

	public static void Question6_3() // Leet code
	{
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		int m = matrix.length;

		int[][] result = new int[m][m];

		for(int i=0; i<m; i++){
			for(int j=0; j<m; j++){
				result[j][m-1-i] = matrix[i][j];
			}
		} 

		for(int i=0; i<m; i++){
			for(int j=0; j<m; j++){
				matrix[i][j] = result[i][j];
			}
		} 

		for(int i=0; i<4; i++){
			for(int j=0; j<4; j++){
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}			
	}


}
