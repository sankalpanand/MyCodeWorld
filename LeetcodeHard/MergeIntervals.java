package LeetcodeHard;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Interval> merge(List<Interval> intervals) {
		if(intervals.size() <= 1) return intervals;

		// Sort by start time
		Collections.sort(intervals, new Comparator<Interval>()
		{
			@Override
			public int compare(Interval i1, Interval i2)
			{
				return Integer.compare(i1.start, i2.start);
			}
		}
				);


		List<Interval> result = new LinkedList<Interval>();

		int start = intervals.get(0).start;
		int end = intervals.get(0).end;

		for(Interval interval : intervals)
		{
			if(interval.start <= end) // It means overlap occurs
				end = Math.max(interval.end, end);

			else // No overlap occurred
			{
				result.add(new Interval(start, end));
				start = interval.start;
				end = interval.end;
			}
		}

		// Since in the loop, we are always adding the previous interval whenever there is no overlap.
		// Therefore, the last interval is missed. Add the last interval
		result.add(new Interval(start, end));

		return result;
	}

}

class Interval 
{
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
}