package Leetcode.Medium;

import java.util.ArrayList;
import java.util.List;

public class Q54SpiralMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// https://leetcode.com/problems/spiral-matrix/discuss/20599/Super-Simple-and-Easy-to-Understand-Solution
    // Neetcode - https://www.youtube.com/watch?v=BJnMZNwUk1M
    // Leetcode - https://leetcode.com/problems/spiral-matrix/
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }

        int left = 0;
        int right = matrix[0].length;
        int top = 0;
        int bottom = matrix.length;

        while (left < right && top < bottom) {
            // Traverse from left to right
            for (int i = left; i < right; i++) {
                res.add(matrix[top][i]);
            }
            top++;

            // Traverse from top to bottom
            for (int i = top; i < bottom; i++) {
                res.add(matrix[i][right - 1]);
            }
            right--;

            // Ensure there is still a layer to process
            if (!(left < right && top < bottom)) {
                break;
            }

            // Traverse from right to left
            for (int i = right - 1; i >= left; i--) {
                res.add(matrix[bottom - 1][i]);
            }
            bottom--;

            // Traverse from bottom to top
            for (int i = bottom - 1; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            left++;
        }

        return res;
    }
}
