package Leetcode.Medium;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

	public static void main(String[][] args) {
		// TODO Auto-generated method stub
        char [][] board = {
                            {'5','3','.','.','7','.','.','.','.'}
                            ,{'6','.','.','1','9','5','.','.','.'}
                            ,{'.','9','8','.','.','.','.','6','.'}
                            ,{'8','.','.','.','6','.','.','.','3'}
                            ,{'4','.','.','8','.','3','.','.','1'}
                            ,{'7','.','.','.','2','.','.','.','6'}
                            ,{'.','6','.','.','.','.','2','8','.'}
                            ,{'.','.','.','4','1','9','.','.','5'}
                            ,{'.','.','.','.','8','.','.','7','9'}
        };
	}

    // Stephen Ponchoman
    public boolean isValidSudoku3(char[][] board) {
        Set seen = new HashSet();
        for (int i=0; i<9; ++i) {
            for (int j=0; j<9; ++j) {
                char number = board[i][j];
                if (number != '.')
                    if (!seen.add(number + " in row " + i) ||
                            !seen.add(number + " in column " + j) ||
                            !seen.add(number + " in block " + i/3 + "-" + j/3))
                        // Consider 9*9 as a matrix of 3*3
                        // The above trick will spit out indices of a 3 * 3 matrix for all 81 values.
                        return false;
            }
        }
        return true;
    }

    // https://leetcode.com/problems/valid-sudoku/discuss/15450/Shared-my-concise-Java-code
    /*

        This is how the indices will look like in a 9*9 matrix
        00  01  02  03  04  05  06  07  08
        10  11  12  13  14  15  16  17  18
        20  21  22  23  24  25  26  27  28
        30  31  32  33  34  35  36  37  38
        40  41  42  43  44  45  46  47  48
        50  51  52  53  54  55  56  57  58
        60  61  62  63  64  65  66  67  68
        70  71  72  73  74  75  76  77  78
        80  81  82  83  84  85  86  87  88

         */

    public boolean isValidSudoku2(char[][] board) {

        // traversing cube i
        for(int i = 0; i<9; i++) {

            HashSet<Character> rows = new HashSet<Character>();
            HashSet<Character> columns = new HashSet<Character>();
            HashSet<Character> cube = new HashSet<Character>();

            // traversing entry j of cube i
            for (int j = 0; j < 9;j++) {

                // Traversing rows and columns -
                // Fix i and move j from 0-8. If you'll form an getCellIndex such like [i][j] and [j][i],
                // you'll get the whole row and column meeting at [i][i]. Try it on paper or look at the matrix above.

                // If this element already exists in the map, it means this number has been used before,
                // then putting it in map will return true, it means the check failed.
                if(board[i][j] != '.' && !rows.add(board[i][j]))
                    return false;

                // We reverse i-j to j-i to move across columns
                if(board[j][i] != '.' && !columns.add(board[j][i]))
                    return false;

                // Now we'll have to use some pattern matching to come up with the first getCellIndex of all the nine cubes.
                // i=0, first getCellIndex will be at 00
                // i=1, first getCellIndex will be at 03
                // i=2, first getCellIndex will be at 06
                // i=3, first getCellIndex will be at 30
                // i=4, first getCellIndex will be at 33
                // i=5, first getCellIndex will be at 36
                // i=6, first getCellIndex will be at 60
                // i=7, first getCellIndex will be at 63
                // i=8, first getCellIndex will be at 66

                // i getCellIndex - Evaluate by dividing getCellIndex by 3
                // 0/3=0, 1/3=0, 2/3=0, 3/3=1, 4/3=1, 5/3=1, 6/3=2, 7/3=2, 8/3=2
                // This gives us 0,0,0... 1,1,1..., 2,2,2
                // Multiply this by 3 to get - 0, 0, 0... 3, 3, 3..., 6, 6, 6

                // j getCellIndex - Evaluate reminder of getCellIndex by 3
                // 0%3=0, 1%3=1, 2%3=2, 3%3=0, 4%3=1, 5%3=2, 6%3=0, 7%3=1, 8%3=2
                // This gives us recurring getCellIndex - 0,1,2... 0,1,2... 0,1,2
                // Multiply this by 3 to get - 0, 3, 6... 0, 3, 6... 0, 3, 6...

                int iStartBlock = 3 * (i/3);
                int jStartBlock = 3 * (i%3);

                // So far you've only got the first getCellIndex of the block. If you'll add these positions to the starting getCellIndex,
                // you'll get the rest. How to come up with relative position? Use the same % and / trick.
                // j        j/3     j%3     position in the cube relative to the starting getCellIndex
                // 0        0/3=0   0%3=0               00
                // 1        1/3=0   1%3=1               01
                // 2        2/3=0   2%3=2               02
                // 3        3/3=1   3%3=0               10
                // 4        4/3=1   4%3=1               11
                // 5        5/3=1   5%3=2               12
                // 6        6/3=2   6%3=0               20
                // 7        7/3=2   7%3=1               21
                // 8        8/3=2   8%3=2               22

                // Add these relative position to the indices of the first cell
                // and you'll get all nine positions within this cube

                int iNext = iStartBlock + j/3;
                int jNext = jStartBlock + j%3;

                if(board[iNext][jNext] != '.' && !cube.add(board[iNext][jNext]))
                    return false;
            }
        }
        return true;
    }



	public boolean isValidSudoku(char[][] board) 
	{
		int x1, x2, y1, y2;

		// Check Rows and columns
		for(int i=0; i<9; i++)
		{
			// Check column 00 to 70, 01 to 71, 02 to 72 and so on..
			if(!checkColumns(board, 0, 8, i, i)) return false;

			// Check row 00 to 07, 10 to 17, 20 to 27 and so on..
			if(!checkColumns(board, i, i, 0, 8)) return false;
		}

		// Check cubes
		for(int i=0; i<=3; i++)
		{
			x1 = 3 * i;
			x2 = 3 * (i+1) - 1; // add +1, -1 to the above 

			for(int j=0; j<=3; j++)
			{
				y1 = 3 * j;
				y2 = 3 * (j+1) - 1; // add +1, -1 to the above

				if(!checkColumns(board, x1, x2, y1, y2)) return false;
			}
		}

		return true;
	}

	public boolean checkColumns(char[][] board, int x1, int x2, int y1, int y2)
	{
		Set<Character> map = new HashSet<Character>();

		for(int i=x1; i<=x2; i++)
		{
			for(int j=y1; j<=y2; j++)
			{
				if(board[i][j] != '.')
				{
					if(!map.add(board[i][j])) return false;
				}
			}
		}
		return true;
	}



}
