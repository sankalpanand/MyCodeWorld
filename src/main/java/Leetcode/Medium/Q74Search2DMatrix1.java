package Leetcode.Medium;

public class Q74Search2DMatrix1 {

	public static void main(String[] args) {
        Q74Search2DMatrix1 obj = new Q74Search2DMatrix1();
		int[][] mat = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
		System.out.println(obj.searchMatrix(mat, 23));
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

	// Leetcode - https://leetcode.com/problems/search-a-2d-matrix/description/
    // Neetcode - https://www.youtube.com/watch?v=Ber2pi2C0j0
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        int top = 0;
        int bot = ROWS - 1;

        while (top <= bot) {
            int row = (top + bot) / 2;

            if (target > matrix[row][COLS - 1]) {   // Target is greater than the last element in this row, which means we should check the bottom half
                top = row + 1;
            } else if (target < matrix[row][0]) {   // Target is smaller than the first element in this row, which means we should check the upper half
                bot = row - 1;
            } else {    // The element is going to be in this row
                break;
            }
        }

        if (!(top <= bot)) {
            return false;
        }

        int row = (top + bot) / 2;
        int l = 0;
        int r = COLS - 1;

        while (l <= r) {
            int m = (l + r) / 2;
            if (target > matrix[row][m]) {
                l = m + 1;
            } else if (target < matrix[row][m]) {
                r = m - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}


