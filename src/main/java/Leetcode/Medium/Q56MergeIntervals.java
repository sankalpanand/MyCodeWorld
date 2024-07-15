package Leetcode.Medium;

import java.util.*;

public class Q56MergeIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        Q56MergeIntervals obj = new Q56MergeIntervals();

        System.out.println(Arrays.toString(obj.merge(intervals)));
	}

	// Video explanation - https://www.youtube.com/watch?v=qKczfGUrFY4
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if (intervals.length <= 1)
            return intervals;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int start = intervals[0][0];
        int lastEnd = intervals[0][1];

        for(int i=1; i< intervals.length; i++) {
            // Check if the beginning of the next interval is less than the ending of current interval
            // Means there is potential of overlap, which means updating the current lastEnd
            if(intervals[i][0] <= lastEnd) {
                lastEnd = Math.max(lastEnd, intervals[i][1]);
            }

            // Check if the beginning of the next interval is greater than the ending of current interval
            // It means the interval we are tracking with start and lastEnd, its time to seal that
            else {
                res.add(new int[]{start, lastEnd});

                // Update the start and lastEnd to the current interval
                start = intervals[i][0];
                lastEnd = intervals[i][1];
            }
        }

        // Add the last non-overlapping interval
        res.add(new int[]{start, lastEnd});

        return res.toArray(new int[res.size()][]);
    }

    public List<Interval> merge(List<Interval> intervals) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (Interval itl : intervals) {
            map.put(itl.start, map.getOrDefault(itl.start, 0) + 1);
            map.put(itl.end, map.getOrDefault(itl.end, 0) - 1);
        }
        List<Interval> list = new LinkedList<>();
        int start = 0, cnt = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (cnt == 0) start = e.getKey();
            // if cnt is 0, that means a full interval has been completed.
            if ((cnt += e.getValue()) == 0)
                list.add(new Interval(start, e.getKey()));
        }
        return list;
    }
}

