package Leetcode.Medium;

public class RotateImage {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		RotateImage obj = new RotateImage();
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		obj.print(matrix);
		obj.rotate(matrix);
		System.out.println();
		obj.print(matrix);
	}

	/*
	 * The idea is to transpose a matrix, 
	 * then flip the matrix horizontally to rotate clockwise and vertically to rotate counter clockwise.
	 * 
 	1  2  3             
	4  5  6
	7  8  9

	[Transpose] => matrix[i][j] = matrix[j][i];

	1  4  7
	2  5  8
	3  6  9

	[Flip horizontally] => matrix[i][j] = matrix[i][matrix.length-1-j];

	7  4  1
	8  5  2
	9  6  3
	 * 
	 * */

	public void rotate(int[][] matrix) 
	{
		for(int i = 0; i<matrix.length; i++)
		{
			for(int j = i; j<matrix[0].length; j++)
			{
				swap(matrix, i,j,j,i);                
			}
		}

		for(int i =0 ; i<matrix.length; i++)
		{
			for(int j = 0; j<matrix.length/2; j++)
			{
				swap(matrix, i,j,i,matrix.length-1-j);                               
			}
		}
	}

	public void swap(int[][] matrix, int x1, int y1, int x2, int y2)
	{
		int temp = matrix[x1][y1];
		matrix[x1][y1] = matrix[x2][y2];
		matrix[x2][y2] = temp;		
	}
	
	// For display
	public void print(int[][] matrix)
	{
		for(int i=0; i<4; i++)
		{
			for(int j=0; j<4; j++)
			{
				System.out.print(matrix[i][j] + "\t");
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



	// Leet code
	public static void Question6_3() 
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

	// Using Stringbuilder
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

}
