package LeetcodeMedium;

import java.util.Arrays;
/*
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
 * */
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms2 {

	public static void main(String[] args) 
	{
		Interval i1 = new Interval(0, 30);
		Interval i2 = new Interval(15, 20);
		Interval i3 = new Interval(5, 10);

		Interval[] input = {i1, i2, i3};

		System.out.println(minMeetingRooms(input));
		
		int arr[] = {900, 940, 950, 1100, 1500, 1800};
	    int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
	    System.out.println(platforms(arr, dep));
	    
	}

	/* Approach- Sorted array par walk karo. Agar non oveerlapping meetings dikhti hain, unka end time merge kar do
	 * Agar overlapping meetings hain, to ye wali meeting bhi heap pe daal do
	 * */
	public static int minMeetingRooms(Interval[] intervals) 
	{
		if(intervals == null)
			return 0;

		Arrays.sort(intervals, new Comparator<Interval>()
				{
					public int compare(Interval a, Interval b) {return a.start - b.start;}
				}
		);
		
		PriorityQueue<Interval> heap = new PriorityQueue<Interval>(intervals.length, 
				new Comparator<Interval>()
				{
					public int compare(Interval a, Interval b) {return a.end - b.end;}
				}
		);

		// Start with the first meeting
		heap.offer(intervals[0]);
		
		
		for(int i=1; i<intervals.length; i++)
		{
			// Get the meeting room that finishes earliest
			Interval prev = heap.poll();
			
			// If the current meeting starts after the end time of the prev meeting, 
			// There is no need for a room. Merge the interval.
			if(intervals[i].start >= prev.end) 
				prev.end = intervals[i].end;
			
			// Else, there is a need for a meeting room
			else
				heap.offer(intervals[i]);
			
			
			// Don't forget to put the prev back
			heap.offer(prev);
			
		}

		return heap.size();
	}
	
	// http://tech-queries.blogspot.com/2009/05/number-of-bus-stations.html
	public static int platforms(int[] startTimes, int[] endTimes) 
	{
		Arrays.sort(startTimes);
		Arrays.sort(endTimes);
		
		int i=0, j=0, k=0, count=0, max = 0;
		
		while(i<startTimes.length && j<endTimes.length)
		{
			if(startTimes[i] < endTimes[j])
			{
				i++;
				count++;
				max = Math.max(max, count);
			}
			else
			{
				j++;
				count--;
			}
			k++;
		}

		return max;
	}

}


class Interval
{
	int start;
	int end;

	public Interval(int s, int e) 
	{
		start = s;
		end = e;
	}


	public String toString()
	{
		return "(" + start + "," + end + ")"; 
	}
}
