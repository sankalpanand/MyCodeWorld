package Leetcode.Medium;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q378KthSmallestElementInSortedMatrix {
    public static void main(String[] args) {
        Q378KthSmallestElementInSortedMatrix obj = new Q378KthSmallestElementInSortedMatrix();
        int[][] mat = {
                {1,3,7},
                {5,10,12},
                {6,10,15}
        };

        System.out.println(obj.kthSmallest(mat, 8));
    }

    // Leetcode - https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/
    // https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/solutions/1322101/c-java-python-maxheap-minheap-binary-search-picture-explain-clean-concise/
    // Time: O(K * logK)
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length, ans = -1; // For general, the matrix need not be a square

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));

        // We'll store {first element, row index, curr col idx (0 initially)} for each row in the priority queue
        // The min heap will be sorted as per the first element, so we'll always have the first element available
        for (int r = 0; r < Math.min(m, k); ++r)
            minHeap.offer(new int[]{matrix[r][0], r, 0});

        for (int i = 1; i <= k; ++i) {
            int[] top = minHeap.poll();
            int rowIdx = top[1];
            int colIdx = top[2];
            ans = top[0];

            if (colIdx + 1 < n)
                minHeap.offer(new int[]{matrix[rowIdx][colIdx + 1], rowIdx, colIdx + 1});
        }
        return ans;
    }

    // Most optimized solution - Binary Search over a range
    // Illustration - https://www.youtube.com/watch?v=gQuH27Xz5mk
    // Explanation - https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/solutions/167784/java-binary-search-with-explanations/

    // N log N log (Range)
    public int kthSmallest_binarySearch(int[][] matrix, int k) {
        int n = matrix.length, lo = matrix[0][0], hi = matrix[n - 1][n - 1];

        // Our main goal in each iteration of the while loop is to count how many numbers we found that were smaller than our mid.
        while (lo <= hi) {
            int mi = lo + ((hi - lo) >> 1);
            int count = countNonBigger(mi, matrix);
            if (count < k) {
                lo = mi + 1;
            } else {
                hi = mi - 1;
            }
        }

        return lo;
    }

    // Check the explanation by Yuvraj Joshi to see why it works
    // https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/solutions/167784/java-binary-search-with-explanations/
    private static int countNonBigger(int target, int[][] matrix) {
        int n = matrix.length, i = n - 1, j = 0, cnt = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] > target) {
                i--;
            } else {
                cnt += i + 1;
                j++;
            }
        }

        return cnt;
    }
}
