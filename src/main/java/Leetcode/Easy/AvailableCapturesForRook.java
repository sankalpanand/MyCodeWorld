package Leetcode.Easy;

public class AvailableCapturesForRook {
    public static void main(String[] args) {

    }

    public int numRookCaptures(char[][] b) {
        for (int i = 0; i < b.length; ++i)
            for (int j = 0; j < b[i].length; ++j)
                if (b[i][j] == 'R')
                    return cap(b, i, j,0,1) +
                            cap(b, i, j,0,-1) +
                            cap(b, i, j,1,0) +
                            cap(b, i, j,-1,0);
        return 0;
    }

    int cap(char[][] b, int x, int y, int dx, int dy) {
        while (x >= 0 && x < b.length && y >= 0 && y < b[x].length && b[x][y] != 'B') {

            // If pawn is found, return 1
            if (b[x][y] == 'p')
                return 1;

            // Else, increase the right coordinate
            x += dx;
            y += dy;
        }

        return 0;
    }

    public int numRookCapturesMySolution(char[][] board) {

        int count=0;

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j] == 'R') {
                    // System.out.println("Rook found at " + i + " and " + j);
                    // Check up
                    for(int k=i-1; k>=0; k--) {
                        if(board[k][j] == 'p') {
                            count++;
                            break;
                        } else if(board[k][j] == 'B') {
                            break;
                        }
                    }

                    // Check down
                    for(int k=i+1; k<board.length; k++) {
                        if(board[k][j] == 'p') {
                            count++;
                            break;
                        } else if(board[k][j] == 'B') {
                            break;
                        }
                    }

                    // Check left
                    for(int k=j-1; k>=0; k--) {
                        if(board[i][k] == 'p') {
                            count++;
                            break;
                        } else if(board[i][k] == 'B') {
                            break;
                        }
                    }

                    // Check right
                    for(int k=j+1; k<board[0].length; k++) {
                        if(board[i][k] == 'p') {
                            count++;
                            break;
                        } else if(board[i][k] == 'B') {
                            break;
                        }
                    }

                }
            }
        }
        return count;
    }
}
