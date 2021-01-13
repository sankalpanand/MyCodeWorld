package Leetcode.Easy;

public class ReshapeMatrix {
    public static void main(String[] args) {
        // int[][] nums = {{1,2}, {4,4}};
        int[][] nums = {{1,2}, {3, 4}};
        matrixReshape(nums, 2, 4);
    }

    /*
        00 -> 00
        01 -> 01
        02 -> 10
        10 -> 11
        11 -> 20
        12 -> 22
    */

    public static int[][] matrixReshape(int[][] nums, int r, int c) {

        // Handle the erroneous case
        int m = nums.length;
        int n = nums[0].length;


        if(r*c != m*n) {
            return nums;
        }

        int[][] result = new int[r][c];
        int k = 0, l = 0;

        for(int i=0; i < m; i++) {
            for(int j=0; j < n; j++) {

                // Whenever col2 reaches the upper bound, it flips back to zero and the row is incremented by 1
                if(l >= c) {
                    l = 0;
                    k++;
                }

                // Assignment happens here
                result[k][l] = nums[i][j];

                // Only the col2 increments, row2 increments when col2 hits the ceiling
                l++;
            }
        }
        return result;
    }

    public int[][] matrixReshape_concise(int[][] nums, int r, int c) {
        int n = nums.length, m = nums[0].length;
        if (r*c != n*m) return nums;

        int[][] res = new int[r][c];

        for (int i=0; i<r*c; i++)
            res[i/c][i%c] = nums[i/m][i%m];

        return res;
    }
}
