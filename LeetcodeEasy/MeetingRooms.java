package LeetcodeEasy;

import java.util.Arrays;

/*
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
 * */
public class MeetingRooms {

	public static void main(String[] args) 
	{
		Interval i1 = new Interval(0, 30);
		Interval i2 = new Interval(15, 20);
		Interval i3 = new Interval(5, 10);

		Interval[] input = {i1, i2, i3};

		System.out.println(canAttendMeetings(input));


	}

	public static boolean canAttendMeetings(Interval[] intervals) 
	{
		if(intervals == null)
			return false;

		Arrays.sort(intervals);

		for(int i=1; i<intervals.length; i++)
		{
			if(intervals[i].start < intervals[i-1].end) return false;
		}

		return true;
	}

}


class Interval  implements Comparable<Interval>
{
	int start;
	int end;

	public Interval(int s, int e) 
	{
		start = s;
		end = e;
	}

	@Override
	public int compareTo(Interval i) 
	{
		return this.start - i.start;
	}

	public String toString()
	{
		return "(" + start + "," + end + ")"; 
	}
}
