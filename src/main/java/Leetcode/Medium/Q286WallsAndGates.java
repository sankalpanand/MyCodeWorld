package Leetcode.Medium;

import java.util.LinkedList;
import java.util.Queue;

public class Q286WallsAndGates {
    public static void main(String[] args) {

    }

    // Neetcode - https://www.youtube.com/watch?v=e69C6xhiSQE
    // Leetcode - https://leetcode.com/problems/walls-and-gates/description/

    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0 || rooms[0].length == 0)
            return;

        Queue<int[]> queue = new LinkedList<>();

        // Put all the gates coordinates in a queue
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0)
                    queue.add(new int[]{i, j});
            }
        }

        while (!queue.isEmpty()) {
            int[] top = queue.remove();
            int row = top[0], col = top[1];

            // Check the top row - if its max distance, then update the distance on it and add that position in the queue
            if (row > 0 && rooms[row - 1][col] == Integer.MAX_VALUE) {
                rooms[row - 1][col] = rooms[row][col] + 1;
                queue.add(new int[]{row - 1, col});
            }

            // Check the bottom cell - if its max distance, then update the distance on it and add that position in the queue
            if (row < rooms.length - 1 && rooms[row + 1][col] == Integer.MAX_VALUE) {
                rooms[row + 1][col] = rooms[row][col] + 1;
                queue.add(new int[]{row + 1, col});
            }

            // Check the left cell - if its max distance, then update the distance on it and add that position in the queue
            if (col > 0 && rooms[row][col - 1] == Integer.MAX_VALUE) {
                rooms[row][col - 1] = rooms[row][col] + 1;
                queue.add(new int[]{row, col - 1});
            }

            // Check the right cell
            if (col < rooms[0].length - 1 && rooms[row][col + 1] == Integer.MAX_VALUE) {
                rooms[row][col + 1] = rooms[row][col] + 1;
                queue.add(new int[]{row, col + 1});
            }
        }
    }

}
