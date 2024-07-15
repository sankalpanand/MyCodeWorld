package Leetcode.Medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q973KClosestPointsToOrigin {
    // Leetcode - https://leetcode.com/problems/k-closest-points-to-origin/description/
    // Neetcode - https://www.youtube.com/watch?v=rI2EBUEMfTk
    // O(NlogK)
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);
        for (int[] p : points) {
            pq.offer(p);
            if (pq.size() > K) {
                pq.poll();
            }
        }
        int[][] res = new int[K][2];
        while (K > 0) {
            res[--K] = pq.poll();
        }
        return res;
    }

    public int[][] kClosest_quickSelect(int[][] points, int K) {
        quickSort(points, 0, points.length - 1, K);
        return Arrays.copyOfRange(points, 0, K);
    }

    private void quickSort(int[][] points, int l, int r, int K) {
        if (l < r) {
            int p = partition(points, l, r);
            if (p == K) {
                return;
            } else if (p < K) {
                quickSort(points, p + 1, r, K);
            } else {
                quickSort(points, l, p - 1, K);
            }
        }
    }

    private int partition(int[][] points, int l, int r) {
        int[] pivot = points[r];
        int j = l;
        for (int i = l; i < r; i++) {
            if (compare(points[i], pivot) <= 0) {
                swap(points, j, i);
                j++;
            }
        }
        swap(points, j, r);
        return j;
    }

    private int compare(int[] point1, int[] point2) {
        return Integer.compare(distanceSquared(point1), distanceSquared(point2));
    }

    private int distanceSquared(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    private void swap(int[][] points, int i, int j) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }
}
