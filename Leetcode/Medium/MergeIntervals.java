package Leetcode.Medium;

import java.util.*;

public class MergeIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        MergeIntervals obj = new MergeIntervals();

        System.out.println(Arrays.toString(obj.merge(intervals)));
	}

	// Video explanation - https://www.youtube.com/watch?v=qKczfGUrFY4
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;

        // mergeSort by ascending starting point
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        List<int[]> result = new ArrayList<>();
        int[] currInterval = intervals[0];
        result.add(currInterval);

        for (int[] interval : intervals) {

            int current_begin = currInterval[0];
            int current_end = currInterval[1];
            int next_begin = interval[0];
            int next_end = interval[1];

            // Next interval's beginning is smaller than the current interval's end 
            if (next_begin <= current_end) {
                // then you update the current interval's end. This will be updated in place.
                current_end = Math.max(current_end, next_end);
            }

            // Next interval's beginning is greater than current interval's end, meaning these are disjoint.
            else
            {
                // Add this interval to the list and make this one as the current interval.
                currInterval = interval;
                result.add(interval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}

