package Leetcode.Medium;

import java.util.*;
/*
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
 * */

public class Q253MeetingRooms2 {


	public static void main(String[] args) {
		Q253MeetingRooms2 obj = new Q253MeetingRooms2();
		Interval[] input = {new Interval(0, 30), new Interval(15, 20), new Interval(5, 10)};

		System.out.println(obj.minMeetingRooms(input));


	}

	// https://leetcode.com/problems/meeting-rooms-ii/
	// https://www.youtube.com/watch?v=PWgFnSygweI

	/* Approach- Sorted array par walk karo. Agar non overlapping meetings dikhti hain, unka end time merge kar do
	 * Agar overlapping meetings hain, to ye wali meeting bhi heap pe daal do
	 * */
	public int minMeetingRooms(Interval[] intervals) {
		if(intervals == null || intervals.length == 0)
			return 0;
		Arrays.sort(intervals,(a,b)->a.start-b.start);

		// Size of the PQ represents the total rooms needed
		PriorityQueue<Interval> pq = new PriorityQueue<>((a,b)->a.end-b.end);
		pq.add(intervals[0]);

		for(int i=1; i<intervals.length; i++) {

			// If you find a meeting that starts after the soonest ending meeting, then we can use that room.
			// Remove one room from the PQ.
			if(intervals[i].start >= pq.peek().end) {
				pq.poll();
			}

			// Add this room to the PQ irrespective of overlap or not.
			// So if there was an overlap, then this room would've been added without the poll.
			pq.offer(intervals[i]);
		}
		return pq.size();
	}

	// Better solution using vertical line method
	public int minMeetingRooms2(Interval[] intervals) {
		Map<Integer, Integer> map = new TreeMap<>();
		for (Interval itl : intervals) {
			map.put(itl.start, map.getOrDefault(itl.start, 0) + 1);
			map.put(itl.end, map.getOrDefault(itl.end, 0) - 1);
		}
		int room = 0, k = 0;
		for (int v : map.values())
			k = Math.max(k, room += v);

		return k;
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
