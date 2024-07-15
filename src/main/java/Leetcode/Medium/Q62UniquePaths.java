package Leetcode.Medium;

import java.util.Arrays;

public class Q62UniquePaths {

	public static void main(String[] args) {
		Q62UniquePaths obj = new Q62UniquePaths();
		System.out.println(obj.uniquePaths(4,4));
	}

	// Neetcode - https://www.youtube.com/watch?v=IlEsdxuD4lY
	// Leetcode - https://leetcode.com/problems/unique-paths/

	// Neetcode follows bottom up, but we can also solve it by top-down approach.
	// https://leetcode.com/problems/unique-paths/solutions/22954/c-dp/
	public int uniquePaths1(int m, int n) {

		int[][] path = new int[m][n];

		// For every cell in the first column, there will be only one unique path
		for(int i=0; i<m; i++) {
			path[i][0] = 1;
		}

		// For every cell in the first row, there will be only one unique path
		for(int i=0; i<n; i++) {
			path[0][i] = 1;
		}


		for(int i=1; i<m; i++) {
			for(int j=1; j<n; j++) {
				path[i][j] = path[i-1][j] + path[i][j-1];
			}

		}

		return path[m-1][n-1];
	}

	// Using just one row and one column
	public int uniquePaths(int cols, int rows) {
		int[] cur = new int[cols];
		int[] pre = new int[cols];

		for(int i=0;i<cols;i++){
			pre[i] = 1;
			cur[i] = 1;
		}

		for(int i=1;i<rows;i++){
			for(int j=1;j<cols;j++)
				cur[j] = cur[j-1] + pre[j];

			pre = cur;
		}

		return cur[cols-1];
	}



}
