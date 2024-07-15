package Leetcode.Medium;

public class Q695MaxAreaOfIsland {

    // Neetcode - https://www.youtube.com/watch?v=iJGr1OtmH0c
    // Leetcode - https://leetcode.com/problems/max-area-of-island/description/

    private int ROWS, COLS;
    private boolean[][] visited;

    private int dfs(int[][] grid, int r, int c) {
        if (r < 0 || r == ROWS || c < 0 || c == COLS || grid[r][c] == 0 || visited[r][c]) {
            return 0;
        }
        visited[r][c] = true;
        return 1 + dfs(grid, r + 1, c) + dfs(grid, r - 1, c) + dfs(grid, r, c + 1) + dfs(grid, r, c - 1);
    }

    public int maxAreaOfIsland(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        visited = new boolean[ROWS][COLS];
        int maxArea = 0;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 1 && !visited[r][c]) {
                    maxArea = Math.max(maxArea, dfs(grid, r, c));
                }
            }
        }
        return maxArea;
    }
}
