package easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isValidSudoku(char[][] board) {
        int x1, x2, y1, y2;
        
        // Check Rows and columns
        for(int i=0; i<9; i++)
        {
            if(!checkColumns(board, 0, 8, i, i)) return false;
            if(!checkColumns(board, i, i, 0, 8)) return false;
        }
        
        // Check cubes
        for(int i=0; i<=3; i++)
        {
            x1 = 3 * i;
            x2 = 3 * (i+1) - 1;
            
            for(int j=0; j<=3; j++)
            {
                y1 = 3 * j;
                y2 = 3 * (j+1) - 1;
                
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
