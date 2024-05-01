package Leetcode.Easy;

import java.util.Arrays;
import java.util.Comparator;

/*
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
 * */
public class MeetingRooms {

	public static void main(String[] args) 
	{


	}

    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals == null) {
            return false;
        }

//        Arrays.sort(intervals, new Comparator<int[]>(){
//            public int compare(int[] i1, int[] i2){
//                return i1[0]-i2[0];
//            }
//        });

        Arrays.sort(intervals, (int a[], int b[]) -> a[0]-b[0]);

        for(int i=0; i<intervals.length-1; i++) {
            // If next start is less than current end time
            if(intervals[i+1][0]<intervals[i][1]) {
                return false;
            }
        }
        return true;
    }

	// The idea here is to sort the meetings by starting time.
	// Then, go through the meetings one by one and make sure
	// that each meeting ends before the next one starts.

	// Interval i1 = new Interval(0, 4); i=0, compare 95 & 96
	// Interval i2 = new Interval(5, 10); i=1, compare 96 & 97
	// Interval i3 = new Interval(15, 20); i=2, compare 97 & 98
	// Interval i4 = new Interval(21, 25); i=3, compare 98 & 99
	// Interval i5 = new Interval(30, 35); i=4, compare 99 & 100

	// (0, 4) (5, 10) (15, 20) (21, 25) (30, 35) - No conflict
	// (0, 7) (5, 10) (15, 20) (21, 25) (30, 35) - CONFLICT



}



