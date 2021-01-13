package Leetcode.Hard;

public class SudokuSolver {

    // The time complexity should be 9 ^ m (m represents the number of blanks to be filled in), since each blank can have 9 choices.
    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0)
            return;
        solve(board);
    }

    public boolean solve(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {

                if(board[i][j] == '.') {

                    for(char c = '1'; c <= '9'; c++) {//trial. Try 1 through 9

                        if(isValid(board, i, j, c)) {
                            board[i][j] = c; // Put c for this cell

                            if(solve(board))
                                return true; //If it's the solution return true
                            else
                                board[i][j] = '.'; //Otherwise go back
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {

        for(int i = 0; i < 9; i++) {

            // Check column vertically
            if(board[i][col] != '.' && board[i][col] == c)
                return false;

            // Check row horizontally
            if(board[row][i] != '.' && board[row][i] == c)
                return false;

            // To get to the start or top-left corner of the block, you divide by three and multiply by three
            int iStartBlock = 3 * (row / 3);
            int jStartBlock = 3 * (col / 3);

            int iNext = iStartBlock + i/3;
            int jNext = jStartBlock + i%3;

            if(board[iNext][ jNext] != '.' && board[iNext][jNext] == c)
                return false; //check 3*3 block

        }

        return true;
    }
}
