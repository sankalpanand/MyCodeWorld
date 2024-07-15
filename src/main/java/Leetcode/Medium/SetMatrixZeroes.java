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
	// Neetcode - https://www.youtube.com/watch?v=T41rL0L3Pnw
	// Leetcode - https://leetcode.com/problems/set-matrix-zeroes/
	// Solution without using extra space
	public static void setZeroes(int[][] matrix) {
		int col0 = 1;
		int rows = matrix.length;
		int cols = matrix[0].length;

		for(int i=0; i<rows; i++) {
			// We will not start j with 0. Instead we'll track the status of the first column with a variable col0
			if(matrix[i][0] == 0)
				col0 = 0;

			for(int j=1; j<cols; j++) {
				if(matrix[i][j] == 0) {
					matrix[0][j] = 0;	// Set the cell in the first row to zero
					matrix[i][0] = 0;	// Set the cell in the first column to zero

				}
			}
		}

		for(int i=rows-1; i>=0; i--) {
			for(int j=cols-1; j>=1; j--) {
				if(matrix[i][0] == 0 || matrix[0][j] == 0)	// Check the first cell in each row and first cell in each column
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
