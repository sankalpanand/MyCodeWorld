package Leetcode.Medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class TheMaze2 {

    // https://leetcode.com/articles/the-maze-ii/
    public static void main(String[] args) {

    }

    // Approach 1 - DFS
    public int shortestDistance(int[][] maze, int[] start, int[] dest) {

        // Distance Matrix. This will record the distance to reach the cell i, j on distance[i][j].
        int[][] distance = new int[maze.length][maze[0].length];

        // Fill all the cells with infinity
        for (int[] row: distance)
            Arrays.fill(row, Integer.MAX_VALUE);

        // Initialize the starting cell with zero
        distance[start[0]][start[1]] = 0;

        dfs(maze, start, distance);

        return distance[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : distance[dest[0]][dest[1]];
    }

    public void dfs(int[][] maze, int[] start, int[][] distance) {
        int[][] dirs={{0,1}, {0,-1}, {-1,0}, {1,0}}; // {Left, Right, Up, Down}

        for (int[] dir: dirs) {
            int x = start[0] + dir[0];
            int y = start[1] + dir[1];
            int count = 0;

            // jaate jaao, this will be equivalent to the ball rolling to one side
            while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                x += dir[0];
                y += dir[1];
                count++;
            }

            // distance[x - dir[0]][y - dir[1]] = Wo waali cell jahan par ball ruk gayi
            int xNew = x - dir[0];
            int yNew = y - dir[1];

            // Ho sakta hai ki pahle bhi ye cell reach ho chuki hai kisi aur direction se
            // Agar abhi wala distance chhota hai, then ab hum yahan se aage explore karenge
            if (distance[start[0]][start[1]] + count < distance[xNew][yNew]) {
                // Current path is shorter, update that cell
                distance[xNew][yNew] = distance[start[0]][start[1]] + count;

                // Further, now we need to try to reach the destination, dest, from the end position (i,j)(i,j),
                // since this could lead to a shorter path to destdest.
                // Thus, we again call the same function dfs but with the position (i,j)(i,j) acting as the current position.
                int[] newStartPosition = new int[]{xNew, yNew};
                dfs(maze, newStartPosition, distance);
            }
        }
    }


    public int shortestDistance_BFS(int[][] maze, int[] start, int[] dest) {
        int[][] distance = new int[maze.length][maze[0].length];

        for (int[] row: distance)
            Arrays.fill(row, Integer.MAX_VALUE);

        distance[start[0]][start[1]] = 0;
        int[][] dirs={{0, 1} ,{0, -1}, {-1, 0}, {1, 0}};

        Queue <int[]> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int[] currentCandidate = queue.remove();
            for (int[] dir: dirs) {
                int x = currentCandidate[0] + dir[0];
                int y = currentCandidate[1] + dir[1];
                int count = 0;

                while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                    count++;
                }

                // Only add those items to the queue that can potentially make your distance shorter
                if (distance[currentCandidate[0]][currentCandidate[1]] + count < distance[x - dir[0]][y - dir[1]]) {
                    distance[x - dir[0]][y - dir[1]] = distance[currentCandidate[0]][currentCandidate[1]] + count;
                    queue.add(new int[] {x - dir[0], y - dir[1]});
                }
            }
        }
        return distance[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : distance[dest[0]][dest[1]];
    }

    public int shortestDistance_Dijkstra(int[][] maze, int[] start, int[] dest) {
        int[][] distance = new int[maze.length][maze[0].length];
        boolean[][] visited = new boolean[maze.length][maze[0].length];

        // Initialize all the initial distances to Infinity
        for (int[] row : distance)
            Arrays.fill(row, Integer.MAX_VALUE);

        // Initialize the first cell distance with zero
        distance[start[0]][start[1]] = 0;

        dijkstra(maze, distance, visited);
        return distance[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : distance[dest[0]][dest[1]];
    }

    // This method reads the matrix. Returns the coordinates of the cell at least non visited distance
    public int[] minDistance(int[][] distance, boolean[][] visited) {
        int[] min={-1,-1};
        int min_val = Integer.MAX_VALUE;
        for (int i = 0; i < distance.length; i++) {
            for (int j = 0; j < distance[0].length; j++) {
                if (!visited[i][j] && distance[i][j] < min_val) {
                    min = new int[] {i, j};
                    min_val = distance[i][j];
                }
            }
        }
        return min;
    }

    public void dijkstra(int[][] maze, int[][] distance, boolean[][] visited) {

        int[][] dirs={{0,1},{0,-1},{-1,0},{1,0}};

        while (true) {

            // At every step, we choose a position which hasn't been marked as visited and which is at the shortest
            // distance from the startstart position to be the current position.
            int[] cheapest = minDistance(distance, visited);

            // If minimum was not found (-1), then break.
            if (cheapest[0] < 0)
                break;

            // We mark this position as visited so that we don't consider this position as the current position again.
            visited[cheapest[0]][cheapest[1]] = true;

            /*
            Start evaluating this current cheapest position. Eventually this list will exhaust.
            From the current position, we determine the number of steps required to reach all the positions possible travelling from the current position(in all the four directions possible till hitting a wall/boundary).
            If it is possible to reach any position through the current route with a lesser number of steps than the earlier routes considered, we update the corresponding distancedistance entry.
            We continue the same process for the other directions as well for the current position.
            */
            for (int[] dir: dirs) {
                int x = cheapest[0] + dir[0];
                int y = cheapest[1] + dir[1];
                int count = 0;

                while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                    count++;
                }

                if (distance[cheapest[0]][cheapest[1]] + count < distance[x - dir[0]][y - dir[1]]) {
                    distance[x - dir[0]][y - dir[1]] = distance[cheapest[0]][cheapest[1]] + count;
                }
            }
        }
    }

    public int shortestDistance_PQ(int[][] maze, int[] start, int[] dest) {
        int[][] distance = new int[maze.length][maze[0].length];
        for (int[] row: distance)
            Arrays.fill(row, Integer.MAX_VALUE);
        distance[start[0]][start[1]] = 0;
        dijkstra_PQ(maze, start, distance);
        return distance[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : distance[dest[0]][dest[1]];
    }

    public void dijkstra_PQ(int[][] maze, int[] start, int[][] distance) {
        int[][] dirs={{0,1},{0,-1},{-1,0},{1,0}};
        PriorityQueue< int[] > queue = new PriorityQueue <> ((a, b) -> a[2] - b[2]);

        // We put the element coordinates and the distance in the queue
        queue.offer(new int[]{start[0], start[1], 0});

        while (!queue.isEmpty()) {
            int[] s = queue.poll();

            // If the distance of the cell at front of the queue is less than the distance stored at the 2nd getCellIndex
            if(distance[s[0]][s[1]] < s[2])
                continue;

            for (int[] dir: dirs) {
                int x = s[0] + dir[0];
                int y = s[1] + dir[1];
                int count = 0;

                while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                    count++;
                }

                if (distance[s[0]][s[1]] + count < distance[x - dir[0]][y - dir[1]]) {
                    distance[x - dir[0]][y - dir[1]] = distance[s[0]][s[1]] + count;
                    queue.offer(new int[]{x - dir[0], y - dir[1], distance[x - dir[0]][y - dir[1]]});
                }
            }
        }
    }
}
