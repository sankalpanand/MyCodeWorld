package Leetcode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q57InsertIntervals {

    // Neetcode - https://www.youtube.com/watch?v=A8NUOmlwOlM
    // Leetcode - https://leetcode.com/problems/insert-interval/description/
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            // New interval end is smaller than current interval's start - means we can simply add it at the beginning
            if (newInterval[1] < intervals[i][0]) {
                res.add(newInterval);
                res.addAll(Arrays.asList(Arrays.copyOfRange(intervals, i, intervals.length)));
                return res.toArray(new int[res.size()][]);
            }

            // New interval start is greater than current interval's end
            // Add it to the result but don't merge it yet, there could be overlap in future intervals
            else if (newInterval[0] > intervals[i][1]) {
                res.add(intervals[i]);
            }

            // There's an overlap, so merge it this time
            else {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }
        res.add(newInterval);
        return res.toArray(new int[res.size()][]);
    }
}
