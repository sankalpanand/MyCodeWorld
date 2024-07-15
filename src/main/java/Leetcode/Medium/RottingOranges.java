package Leetcode.Medium;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public static void main(String[] args) {
        RottingOranges obj = new RottingOranges();
        int[][] grid = {{2,1,1}, {1,1,0}, {0,1,1}};
        obj.orangesRotting(grid);
    }

    // Leetcode - https://leetcode.com/problems/rotting-oranges/description/
    // Neetcode - https://www.youtube.com/watch?v=y704fEOx0s0

    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        int count_fresh = 0;

        // Put the position of all rotten oranges in queue. Count the number of fresh oranges.
        for(int i = 0 ; i < rows ; i++) {
            for(int j = 0 ; j < cols ; j++) {
                // If its rotten, put it in the queue
                if(grid[i][j] == 2) {
                    queue.offer(new int[]{i , j});
                }
                else if(grid[i][j] == 1) {
                    count_fresh++;
                }
            }
        }

        // If count of fresh oranges is zero --> return 0
        if(count_fresh == 0)
            return 0;

        int countMinutes = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}}; // Down, Up, Right, Left

        // BFS starting from initially rotten oranges
        while(!queue.isEmpty()) {
            countMinutes++;
            int queueSize = queue.size();

            // Operate on initial members of the queue only, not on the freshly added ones.
            for(int i = 0 ; i < queueSize ; i++) {

                int[] point = queue.poll();

                // Check each of the four adjacent cells
                for(int dir[] : dirs) {
                    // Calculate coordinates of new cell
                    int x = point[0] + dir[0];
                    int y = point[1] + dir[1];

                    //if x or y is out of bound
                    //or the orange at (x , y) is already rotten
                    //or the cell at (x , y) is empty
                    //we do nothing
                    if(x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == 0 || grid[x][y] == 2)
                        continue;

                    // Mark the orange at (x , y) as rotten
                    grid[x][y] = 2;

                    // Put the new rotten orange at (x , y) in queue
                    queue.offer(new int[]{x , y});

                    // Decrease the count of fresh oranges by 1
                    count_fresh--;
                }
            }
        }

        if(count_fresh == 0)
            return countMinutes-1; // Why -1, see below.
        else // Impossible
            return -1;

        // after you added last level of nodes into the queue, all the oranges are marked as rotten,
        // and you incremented step count 1, which is exactly what we need to return.
        // But since queue is not empty (last level in BFS tree),
        // you have one more iteration to go through, which will make step count 1 larger than it should be.
    }

    /*
    [2,1,1],
    [1,1,0],
    [0,1,1]

    [2,2,1],
    [2,1,0],
    [0,1,1]

    [2,2,2],
    [2,2,0],
    [0,1,1]

    [2,2,2],
    [2,2,0],
    [0,2,1]

    [2,2,2],
    [2,2,0],
    [0,2,2]
     */
}
