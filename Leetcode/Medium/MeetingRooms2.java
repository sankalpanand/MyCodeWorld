package Leetcode.Medium;

import java.util.Arrays;
/*
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
 * */
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms2 {

	public static void main(String[] args) 
	{
		int[][] input = {{1, 30}, {15, 20}, {5, 10}};

		System.out.println(minMeetingRooms(input));
		
		int arr[] = {900, 940, 950, 1100, 1500, 1800};
	    int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
	    System.out.println(platforms(arr, dep));
	    
	}

	// https://www.youtube.com/watch?v=PWgFnSygweI

	/* Approach- Sorted array par walk karo. Agar non overlapping meetings dikhti hain, unka end time merge kar do
	 * Agar overlapping meetings hain, to ye wali meeting bhi heap pe daal do
	 * */
	public static int minMeetingRooms(int[][] intervals)
	{
		if(intervals == null || intervals.length == 0)
			return 0;

		Arrays.sort(intervals, new Comparator<int[]>()
				{
					public int compare(int[] a, int[] b) {return a[0] - b[0];}
				}
		);

        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(intervals.length, (int[] a, int[] b) -> a[1] - b[1]);

		// Start with the first meeting
		heap.offer(intervals[0]);
		
		
		for(int i=1; i<intervals.length; i++)
		{
			// Get the meeting room that finishes earliest
			int[] prev = heap.poll();
			
			// If the current meeting starts after the end time of the prev meeting, 
			// There is no need for a room. Merge the interval.
			if(intervals[i][0] >= prev[1])
				prev[1] = intervals[i][1];
			
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
