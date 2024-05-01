package Leetcode.Easy;

public class IslandPerimeter {

    public static void main(String[] args) {
        int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        System.out.println(islandPerimeter1(grid));
    }

    // My logic - If the neighbors are either 0 or on the edge, increase by 1
    public static int islandPerimeter(int[][] grid) {
        int sum = 0;
        int[][] neighbors = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

        for(int r=0; r < grid.length; r++) {
            for(int c=0; c < grid[0].length; c++) {
                if(grid[r][c] == 1) {
                    for (int i=0; i<4; i++) {
                        if((r+neighbors[i][0] < 0 || r+neighbors[i][0] >= grid.length) ||
                                (c+neighbors[i][1] < 0 || c+neighbors[i][1] >= grid[0].length) ||
                                (grid[r+neighbors[i][0]][c+neighbors[i][1]] == 0)) {
                            sum++;
                        }
                    }
                }
            }
        }

        return sum;
    }

    public int islandPerimeter3(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int count = 0;
        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    for(int[] d:  dir){
                        int x = i + d[0], y = j + d[1];
                        if(x < 0 || y < 0 || x == m || y == n || grid[x][y] == 0){
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    /*

    1. loop over the matrix and count the number of islands;
    2. if the current dot is an island, count if it has any right neighbour or down neighbour;
    3. the result is islands * 4 - neighbours * 2 since every adjacent islands made two sides disappeared.

     */
    public static int islandPerimeter1(int[][] grid) {
        int islands = 0, neighbours = 0;

        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[i].length; j++)
            {
                if (grid[i][j] == 1)
                {
                    // count islands
                    islands++;

                    // count down neighbours
                    if (i < grid.length - 1 && grid[i + 1][j] == 1)
                        neighbours++;

                    // count right neighbours
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1)
                        neighbours++;
                }
            }
        }

        return islands * 4 - neighbours * 2;
    }
}
