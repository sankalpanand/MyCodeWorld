package Leetcode.Medium;

import java.util.Arrays;
import java.util.Comparator;

public class Q435NonOverlappingIntervals {
    public static void main(String[] args) {
        Q435NonOverlappingIntervals obj = new Q435NonOverlappingIntervals();
        int[][] intervals = {{1,3}, {2,6}, {8,10}, {15,18}};
        System.out.println(obj.eraseOverlapIntervals(intervals));
    }

    // Leetcode - https://leetcode.com/problems/non-overlapping-intervals/description/
    // Neetcode - https://www.youtube.com/watch?v=nONCGxWoUfM
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int prevEnd = intervals[0][1];
        int count = 0;

        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];

            if (start >= prevEnd) {
                prevEnd = intervals[i][1];

            }
            // If there's an overlap, count it and remove the interval with the larger end date
            else {
                count++;
                prevEnd = Math.min(intervals[i][1], prevEnd);
            }
        }

        return count;
    }
}
