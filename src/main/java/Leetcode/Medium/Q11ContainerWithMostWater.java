package Leetcode.Medium;

public class Q11ContainerWithMostWater {
    // Leetcode - https://leetcode.com/problems/container-with-most-water/
    // Neetcode - https://www.youtube.com/watch?v=UuiTKBwPgAo
    public int maxArea(int[] heights) {
        int l = 0, r = heights.length - 1;
        int res = 0;

        while (l < r) {
            res = Math.max(res, Math.min(heights[l], heights[r]) * (r - l));
            if (heights[l] < heights[r]) {
                l++;
            } else {
                r--;
            }
        }

        return res;
    }
}
