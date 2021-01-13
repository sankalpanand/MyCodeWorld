package Leetcode.Medium;

public class SetMatrixZeroes {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat = {
				{0,0,0,5},
				{4,3,1,4},
				{0,1,1,4},
				{1,2,1,3},
				{0,0,1,1}
		};
		
		setZeroes(mat);
	}

	/* Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place. */
	// Leetcode.Easy.Hard - Without using any auxiliary array
	public static void setZeroes(int[][] matrix) 
	{
		int col0 = 1;
		int rows = matrix.length;
		int cols = matrix[0].length;

		for(int i=0; i<rows; i++)
		{
			if(matrix[i][0] == 0)
				col0 = 0;

			for(int j=1; j<cols; j++)
			{
				if(matrix[i][j] == 0)
				{
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		for(int i=rows-1; i>=0; i--)
		{
			for(int j=cols-1; j>=1; j--)
			{
				if(matrix[i][0] == 0 || matrix[0][j] == 0)
					matrix[i][j] = 0;

			}
			if(col0 == 0)
				matrix[i][0] = 0;
		}
	}
	
	// Leetcode.Easy - With auxiliary array
	public void setZeroes2(int[][] matrix) 
	{
	    int rows = matrix.length;
		int cols = matrix[0].length;
		
		boolean[] rowStatus = new boolean[rows];
		boolean[] colStatus = new boolean[cols];
		
		for(int i=0; i<rows; i++)
		{
			for(int j=0; j<cols; j++)
			{
			    if(matrix[i][j] == 0)
				    {
				        rowStatus[i] = true;
				        colStatus[j] = true;
				    }
			}
		}
		
		for(int i=0; i<rows; i++)
		{
			for(int j=0; j<cols; j++)
			{
			    if(rowStatus[i] == true || colStatus[j] == true)
			    {
			        matrix[i][j] = 0;
			    }
			}
		}
	}
	
	
	
	public static void print(int[][] matrix)
	{
		System.out.println();
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		for(int i=0; i<rows; i++)
		{
			for(int j=0; j<cols; j++)
			{
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		
	}

}
