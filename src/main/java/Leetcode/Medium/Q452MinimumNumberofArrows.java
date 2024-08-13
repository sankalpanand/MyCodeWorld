package Leetcode.Medium;

import java.util.Arrays;

public class Q452MinimumNumberofArrows {
    // Leetcode - https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/description/
    // Neetcode - https://www.youtube.com/watch?v=lPmkKnvNPrw
    public int findMinArrowShots(int[][] points) {
        // Sort the points based on the first element of each interval
        Arrays.sort(points, (a, b) -> Integer.compare(a[0],b[0]));
        int res = points.length;
        int[] prev = points[0];

        for (int i = 1; i < points.length; i++) {
            int[] curr = points[i];
            if (curr[0] <= prev[1]) {
                res--;
                prev[1] = Math.min(curr[1], prev[1]);
            } else {
                prev = curr;
            }
        }

        return res;
    }
}
