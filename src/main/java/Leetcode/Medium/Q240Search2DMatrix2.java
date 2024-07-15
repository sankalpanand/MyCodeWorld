package Leetcode.Medium;

public class Q240Search2DMatrix2 {

	public static void main(String[] args) {
		Q240Search2DMatrix2 obj = new Q240Search2DMatrix2();

		int[][] mat = {	{1, 4, 7, 11, 15},
				  		{2,   5,  8, 12, 19},
				  		{3,   6,  9, 16, 22},
				  		{10, 13, 14, 17, 24},
				  		{18, 21, 23, 26, 30}};

	}
	
	/*
	 * 
		00  01  02  03  04  05  06  07  08  
		10  11  12  13  14  15  16  17  18  
		20  21  22  23  24  25  26  27  28  
		30  31  32  33  34  35  36  37  38  
		40  41  42  43  44  45  46  47  48  
		50  51  52  53  54  55  56  57  58  
		60  61  62  63  64  65  66  67  68  
		70  71  72  73  74  75  76  77  78  
		80  81  82  83  84  85  86  87  88  
		
	 * */
	
	/*
	We start search the matrix from top right corner, initialize the current position to top right corner,
	if the target is greater than the value in current position, then the target can not be in entire row of current position because the row is sorted,
	if the target is less than the value in current position, then the target can not in the entire column because the column is sorted too.
	We can rule out one row or one column each time, so the time complexity is O(m+n).
	 */

	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix == null || matrix.length < 1 || matrix[0].length <1) {
			return false;
		}
		int col = matrix[0].length - 1;
		int row = 0;

		while(col >= 0 && row <= matrix.length-1) {
			if(target == matrix[row][col]) {
				return true;
			} else if(target < matrix[row][col]) {
				col--;
			} else if(target > matrix[row][col]) {
				row++;
			}
		}
		return false;
	}
}


