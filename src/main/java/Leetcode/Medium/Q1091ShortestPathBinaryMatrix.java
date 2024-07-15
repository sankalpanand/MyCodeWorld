package Leetcode.Medium;

import java.util.LinkedList;
import java.util.Queue;

public class Q1091ShortestPathBinaryMatrix {
    public static void main(String[] args) {

    }

    private int[][] dir = new int[][] {
            {0,1},  // one up
            {0,-1}, // one down
            {1,0},  // one right
            {-1,0}, // one left
            {1,-1}, // bottom right
            {-1,1}, // top left
            {-1,-1},// bottom left
            {1,1}   // top right
    };

    // https://leetcode.com/problems/shortest-path-in-binary-matrix/solutions/312706/java-bfs/
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if(grid[0][0]==1 || grid[m-1][n-1]==1) {
            return -1;
        }

        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});

        int ans=0;

        // As long as there are items in the queue
        while (!queue.isEmpty()) {

            // Iterate the for loop for the number of items at this instant, not pull the ones we enqueue along the way
            int size = queue.size();
            for(int i=0;i<size;i++) {

                int[] pop = queue.remove();
                if(pop[0]==m-1 && pop[1]==n-1) {
                    return ans+1;
                }

                // Iterate over all possible 8 neighbors and mark them visited
                for (int k=0; k<8; k++) {
                    // Get the x and y coordinates of the neighbor
                    int nextX = dir[k][0] + pop[0];
                    int nextY = dir[k][1] + pop[1];

                    if(nextX>=0 && nextX<m && nextY>=0 && nextY<n && !visited[nextX][nextY] && grid[nextX][nextY]==0) {
                        queue.add(new int[]{nextX,nextY});
                        visited[nextX][nextY]=true;
                    }

                }
            }
            ans++;
        }

        return -1;
    }
}
