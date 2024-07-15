package Leetcode.Medium;

public class Q79WordSearch {

	public static void main(String[] args) {
        Q79WordSearch obj = new Q79WordSearch();
		
		char[][] board = {
				{'a','s','s','a'},
				{'k','a','k','n'},
				{'l','n','a','l'},
				{'p','p','l','n'}
				
		};
		
		System.out.println(obj.exist(board, "sankalp"));

	}

	// Neetcode - https://www.youtube.com/watch?v=pfiQ_PS1g8E
    // Leetcode - https://leetcode.com/problems/word-search/description/
    // Complexity - O (m x n x len(word))
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, 0, i, j, m, n)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int index, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != word.charAt(index)) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }

        char temp = board[i][j];
        board[i][j] = '#'; // Mark the cell as visited

        boolean found = dfs(board, word, index + 1, i - 1, j, m, n)
                || dfs(board, word, index + 1, i + 1, j, m, n)
                || dfs(board, word, index + 1, i, j - 1, m, n)
                || dfs(board, word, index + 1, i, j + 1, m, n);

        board[i][j] = temp; // Unmark the cell

        return found;
    }

}
