package Leetcode.Medium;

import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinctIslands {

    int[][] dirs= new int[][]{{1,0},{0,1},{-1,0},{0,-1}};

    /*
    Basic idea is... we track the neighbors in a deterministic manner. So stringbuilder construction will also have the same signature.
     */
    public int numDistinctIslands(int[][] grid) {
        Set<String> set= new HashSet<>();

        for(int i=0; i < grid.length; i++) {
            for(int j=0; j < grid[0].length; j++) {

                // If there is an island,
                if(grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();

                    helper(grid, i, j,0,0, sb);

                    String s = sb.toString();

                    set.add(s);
                }
            }
        }

        return set.size();
    }

    public void helper(int[][] grid, int i, int j, int xpos, int ypos, StringBuilder sb) {
        grid[i][j] = 0;
        sb.append(xpos + "" + ypos);

        for(int[] dir : dirs) {
            int x = i+dir[0];
            int y = j+dir[1];

            // Agar aas paas 0 hai, to skip kar do
            if(x<0 || y<0 || x>=grid.length || y>=grid[0].length || grid[x][y]==0)
                continue;

            helper(grid, x, y,xpos+dir[0],ypos + dir[1], sb);
        }
    }

    // Another solution that doesn't modify the input matrix.
    // We can use direction string instead of using number string in set.
    public int numDistinctIslands2(int[][] grid) {
        Set<String> set = new HashSet<>();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] != 0) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, sb, "o"); // origin
                    grid[i][j] = 0;
                    set.add(sb.toString());
                }
            }
        }
        return set.size();
    }
    private void dfs(int[][] grid, int i, int j, StringBuilder sb, String dir) {
        if(i < 0 || i == grid.length || j < 0 || j == grid[i].length
                || grid[i][j] == 0) return;
        sb.append(dir);
        grid[i][j] = 0;
        dfs(grid, i-1, j, sb, "u");
        dfs(grid, i+1, j, sb, "d");
        dfs(grid, i, j-1, sb, "l");
        dfs(grid, i, j+1, sb, "r");
        sb.append("b"); // back
    }
}
