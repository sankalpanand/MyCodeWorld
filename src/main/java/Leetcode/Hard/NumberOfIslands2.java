package Leetcode.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfIslands2 {

    /*
        This is how the indices will look like in a 9*9 matrix
        00  01  02  03  04  05  06  07  08
        10  11  12  13  14  15  16  17  18
        20  21  22  23  24  25  26  27  28
        30  31 (32)  33  34  35  36  37  38
        40  41  42  43  44  45  46  47  48
        50  51  52  53  54  55  56  57  58
        60  61  62  63  64  65  66  67  68
        70  71  72  73  74  75  76  77  78
        80  81  82  83  84  85  86  87  88



        0  1  2     3  4  5  6  7  8
        9  10 11    12 13 14 15 16 17
        18 19 20    21 22 23 24 25 26
        27 28 (29)  30 31 32 33 34 35
    */

    public static void main(String[] args) {
        NumberOfIslands2 obj = new NumberOfIslands2();
        int[][] positions = new int[][] {{0,0},{0,1},{1,2},{2,1}};
        System.out.println(obj.numIslands2(3, 3, positions));
    }

    // Leetcode - https://leetcode.com/problems/number-of-islands-ii/description/
    // Solution taken from - https://leetcode.com/problems/number-of-islands-ii/solutions/75470/easiest-java-solution-with-explanations/
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        Integer[] parent = new Integer[m*n];
        Integer[] rank = new Integer[m*n];
        Arrays.fill(parent, -1);
        Arrays.fill(rank, 0);

        List<Integer> result = new ArrayList<>();
        if (m == 0 || n == 0 || positions == null || positions.length == 0 || positions[0].length == 0) {
            return result;
        }

        int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int count = 0;
        for (int[] position : positions) {
            int x = position[0];
            int y = position[1];
            int positionIndex = x * n + y;

            if (parent[positionIndex] != -1) {   // duplicate position
                result.add(count);
                continue;
            }

            parent[positionIndex] = positionIndex;

            // With every position, we increase the count by 1
            // Whenever we perform union operation, we decrement the count by 1
            count++;
            for (int[] dir : DIRS) {
                int r = x + dir[0];
                int c = y + dir[1];
                if (isValid(parent, m, n, r, c)) {

                    int neighborIndex = r * n + c;
                    if (union(positionIndex, neighborIndex, parent, rank)) {
                        count--;
                    }
                }
            }
            result.add(count);
        }
        return result;
    }

    public boolean union(int positionIndex, int neighborIndex, Integer[] parent, Integer[] rank) {
        int pRoot = find(positionIndex, parent);
        int qRoot = find(neighborIndex, parent);
        if (pRoot == qRoot) {
            return false;
        }
        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[pRoot] > rank[qRoot]) {
            parent[qRoot] = pRoot;
        } else {
            parent[qRoot] = pRoot;
            rank[pRoot]++;
        }
        return true;
    }

    public int find(int index, Integer[] parent) {
        while (index != parent[index]) {
            parent[index] = parent[parent[index]];
            index = parent[index];
        }
        return index;
    }

    private boolean isValid(Integer[] parent, int m, int n, int r, int c) {
        if (r < 0 || c < 0 || r >= m || c >= n || parent[r * n + c] == -1) {
            return false;
        }
        return true;
    }
}
