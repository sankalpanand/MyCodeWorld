package easy;

public class ZigZagConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ZigZagConversion Obj = new ZigZagConversion();
		String result = Obj.convert("ABC", 2);
		System.out.println(result);
	}



	// This is my code, this doesn't work for the corner case "A", 1
	// public int[][] matrix;
	public String convert(String s, int numRows) {

		char[] c = s.toCharArray();
		int len = c.length;

		// Create an array of StringBuffers for each row
		StringBuffer[] sb = new StringBuffer[numRows];

		// Initialize a SB for each SB reference
		for (int i = 0; i < sb.length; i++) 
			sb[i] = new StringBuffer();

		
		int i = 0;
		while (i < len)
		{
			// Now, these two loops will continue until whole string is finished
			// Down, Diagonal, Down, Diagonal as long as i<len
			// Rows will be tracked using 'row'
			for (int row = 0; row < numRows && i < len; row++) // vertically down
			{
				sb[row].append(c[i]);
				i++;
			}
			
			// idx = numRows-2 because idx++ from the previous for loop has taken it outside the index boundary
			// Moreover, it starts from the penultimate row. That's why -2.
			for (int row = numRows-2; row >= 1 && i < len; row--) // obliquely up
			{
				sb[row].append(c[i]);
				i++;
			}
		}


		for (int idx = 1; idx < sb.length; idx++)
			sb[0].append(sb[idx]);

		return sb[0].toString();
	}

	/* int x = s.length()/numRows;
		int y = Math.max(1, x * (numRows-1));
		initMatrix(numRows, y);
		int start = 0, row = 0, col = 0;

		printDown(s, start, row, col);

		StringBuilder sb = new StringBuilder();
		for(int i=0; i<matrix.length; i++)
		{
			for(int j=0; j<matrix[0].length; j++)
			{
				if(matrix[i][j] != 0)
					sb.append((char)matrix[i][j]);
			}
		}

		return sb.toString();
	}

	public void initMatrix(int x, int y)
	{
		matrix = new int[x][y];
	}

	public void printDown(String str, int index, int row, int col)
	{
		while(row < matrix.length)
		{
			if(str.length() == index)
				return;

			matrix[row][col] = str.charAt(index);
			index++;
			row++;
		}

		printDiagonal(str, index, row-2, col+1);
	}

	public void printDiagonal(String str, int index, int row, int col)
	{
		while(row >= 0)
		{
			if(str.length() == index)
				return;

			matrix[row][col] = str.charAt(index);
			index++;
			row--;
			col++;
		}

		printDown(str, index, row+2, col-1);
	}*/

}
