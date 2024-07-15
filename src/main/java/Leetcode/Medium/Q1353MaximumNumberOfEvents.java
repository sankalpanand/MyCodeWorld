package Leetcode.Medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q1353MaximumNumberOfEvents {
    /*
    in TC: events= [[1,2],[2,3],[3,4],[1,2]], i can attend
[1,2] on Day 1,
[1,2] on Day 2, since the event has not ended and would only end on completion of Day 2
[2,3] on Day 3
[3,4] on Day 4
Hence Output = 4

Input: events= [[1,2],[2,3],[3,4],[1,2]]
Output: 4
     */

    public static void main(String[] args) {
        Q1353MaximumNumberOfEvents obj = new Q1353MaximumNumberOfEvents();
        int[][] events = {{1,2}, {2,3}, {3,4}, {1,2}};
        System.out.println(obj.maxEvents(events));
    }

    // https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/solutions/1304132/priority-queue-step-by-step-explanation/
    public int maxEvents(int[][]  events) {
        int n = events.length;

        //priority queue contains deadlines of all the events
        //that have already started but not ended
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        //sort by event start time
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        int ans=0;
        int i=0;

        for(int d=1; d<=100000; d++) {

            // remove all the events which are already over
            while(!pq.isEmpty() && pq.peek() < d)
            {
                pq.remove();
            }

            //insert deadlines of all events that start today
            while(i<n && events[i][0]==d  )
            {
                pq.offer(events[i][1]);
                i++;
            }

            //if there are any events we can attend today we
            //attend the event with smallest endtime
            if(!pq.isEmpty())
            {
                pq.remove();
                ans++;
            }

            //if all elements are processed then stop
            if(pq.isEmpty() && i==n)
                break;
        }
        return ans;
    }
}
