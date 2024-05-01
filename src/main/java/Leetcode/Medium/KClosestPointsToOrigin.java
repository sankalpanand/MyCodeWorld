package Leetcode.Medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    // https://leetcode.com/problems/k-closest-points-to-origin/discuss/220235/Java-Three-solutions-to-this-classical-K-th-problem.

    // Solution 1 - mergeSort based on distance and return top K
    // Complexity - O (N log N)
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, (p1, p2) -> p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1]);
        return Arrays.copyOfRange(points, 0, K);
    }

    // Solution 2 - Use Heap
    public int[][] kClosest2(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);
        for (int[] p : points) {

            pq.offer(p);

            if (pq.size() > K) {
                pq.poll();
            }
        }

        int[][] res = new int[K][2];

        while (K > 0) {
            K--; // Because index is less by 1
            res[K] = pq.poll();
        }

        return res;
    }

    // Solution 3 - Quick Select - https://youtu.be/hGK_5n81drs?t=610
    public int[][] kClosest3(int[][] points, int K) {
        if (points == null || points.length == 0 || K == 0)
            return new int[][] {{}};
        // shuffle?
        // randomize(points);
        int high = points.length-1;
        int low = 0;

        while (low < high) {
            int p = partition(points, low, high);

            if (p == K)
                break;
            else if (p < K) {  // k can be found in right partition of p
                low = p+1;
            } else if (p > K) {
                high = p-1;
            }
        }
        return Arrays.copyOfRange(points, 0, K);
    }

    public int partition(int[][] points, int low, int high) {
        // take points[high] as the pivot
        int pivot = dist(points[high]);
        int partitionIndex = low;

        // put points less than pivot to partitionIndex, and then
        // move partitionIndex right
        for (int i=low; i<high; i++) {
            if (dist(points[i]) < pivot) {
                swap(points, partitionIndex, i);
                partitionIndex++;
            }
        }
        // Put pivot in right place
        swap(points, partitionIndex, high);
        return partitionIndex;
    }

    private void swap(int[][] points, int i, int j) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }

    private int dist(int[] point) {
        return (point[0] * point[0]) + (point[1] * point[1]);
    }


}
