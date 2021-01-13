package Leetcode.Medium;

public class WordSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char[][] board = {
				{'a','s','s','a'},
				{'k','a','k','n'},
				{'l','n','a','l'},
				{'p','p','l','n'}
				
		};
		
		System.out.println(exist(board, "sankalp"));

	}
	
	public static boolean exist(char[][] board, String word) 
	{
        for(int i=0; i<board.length; i++)
        {
            for(int j=0; j<board[0].length; j++)
            {
                if(helper(board, word.toCharArray(), 0, i, j))
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static boolean helper(char[][] board, char[] word, int index, int x, int y)
    {
        if(index == word.length)
            return true;
            
        if(
            x < 0 ||
            y < 0 ||
            x >= board.length ||
            y >= board[0].length ||
            board[x][y] != word[index]
            )
            return false;
            
        // Mark this x,y as visited
        board[x][y] = '*';
        
        
        // Send recursive call alll around ;)
        boolean result = helper(board, word, index+1, x-1, y) ||
                            helper(board, word, index+1, x+1, y) ||
                            helper(board, word, index+1, x, y+1) ||
                            helper(board, word, index+1, x, y-1);
        
        // Mark this x,y as visited
        board[x][y] = word[index];
        
        return result;
        
    }

}
