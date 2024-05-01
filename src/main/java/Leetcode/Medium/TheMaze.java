package Leetcode.Medium;

import java.util.LinkedList;
import java.util.Queue;

public class TheMaze {
    public static void main(String[] args) {

    }

    // https://leetcode.com/articles/the-maze/
    // DFS - TLE
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return dfs(maze, start, destination, visited);
    }

    public boolean dfs(int[][] maze, int[] start, int[] destination, boolean[][] visited) {

        // If this node is already visited, return
        if (visited[start[0]][start[1]])
            return false;

        // We reached!
        if (start[0] == destination[0] && start[1] == destination[1])
            return true;

        visited[start[0]][start[1]] = true;

        // Calculate neighbors
        int r = start[1] + 1;
        int l = start[1] - 1;
        int u = start[0] - 1;
        int d = start[0] + 1;

        // right mein badhte chalo
        while (r < maze[0].length && maze[start[0]][r] == 0)
            r++;

        // Poora right mein jaane ke baad wo cell recursive function mein bhejo
        if (dfs(maze, new int[] {start[0], r - 1}, destination, visited))
            return true;

        // left mein badhte chalo
        while (l >= 0 && maze[start[0]][l] == 0)
            l--;

        // Poora left mein jaane ke baad wo cell recursive function mein bhejo
        if (dfs(maze, new int[] {start[0], l + 1}, destination, visited))
            return true;

        // Upar mein badhte chalo
        while(u >= 0 && maze[u][start[1]] == 0)
            u--;

        // Poora up mein jaane ke baad wo cell recursive function mein bhejo
        if (dfs(maze, new int[] {u + 1, start[1]}, destination, visited))
            return true;

        // Neeche badhte chalo
        while (d < maze.length && maze[d][start[1]] == 0) //down
            d++;

        // Poora niche jaane ke baad wo cell recursive function mein bhejo
        if(dfs(maze, new int[] {d - 1, start[1]}, destination, visited))
            return true;

        // Sab direction explore karne ke baad agar koi path hota, to ab tak mil jaana chahiye tha.
        // Agar nahi mila hai, it means you're trapped bitch!
        return false;
    }

    // BFS
    public boolean hasPath2(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}}; // {Down, Up, Left, Right}
        Queue< int[] > queue = new LinkedList< >();
        queue.add(start);
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            // Remove the item from the queue to evaluate its neighbors
            int[] s = queue.remove();

            // Agar ye item hi destination hai, return true
            if (s[0] == destination[0] && s[1] == destination[1])
                return true;

            // Ek baar Down badho all the way, ek baar Up, ek baar L aur ek baar right
            for (int[] dir: dirs) {

                // Calculate possible coordinates of neighbor
                int x = s[0] + dir[0];
                int y = s[1] + dir[1];

                // If the possible coordinates are within bounds, usi direction mein badhte chalo
                while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                }

                // x aur y badhne ke baad limit has been reached. Step back by 1.
                // Agar last cell visit nahi huyi hai,
                if (!visited[x - dir[0]][y - dir[1]]) {

                    // to use queue mein daal do
                    queue.add(new int[] {x - dir[0], y - dir[1]});

                    // Aur visited True kar do
                    visited[x - dir[0]][y - dir[1]] = true;
                }
            }
        }
        return false;
    }
}
