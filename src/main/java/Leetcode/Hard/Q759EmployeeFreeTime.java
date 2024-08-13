package Leetcode.Hard;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Q759EmployeeFreeTime {
    public static void main(String[] args) {
        List<Interval> emp1 = new ArrayList<>(Arrays.asList(new Interval(1,2), new Interval(5,6)));
        List<Interval> emp2 = new ArrayList<>(Arrays.asList(new Interval(1,3)));
        List<Interval> emp3 = new ArrayList<>(Arrays.asList(new Interval(4,10)));
        List<List<Interval>> schedule = new ArrayList<>(Arrays.asList(emp1, emp2, emp3));

        Q759EmployeeFreeTime obj = new Q759EmployeeFreeTime();
        System.out.println(obj.employeeFreeTime(schedule));


    }

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        // minHeap sorted with start time
        PriorityQueue<EmployeeInterval> minHeap = new PriorityQueue<EmployeeInterval>((a, b) -> a.interval.start - b.interval.start);

        // Add first interval (EmployeeInterval) of every employee in minheap
        for(int i=0; i<schedule.size(); i++){
            List<Interval> employee = schedule.get(i);
            EmployeeInterval employeeInterval = new EmployeeInterval(employee.get(0), i, 0);
            minHeap.offer(employeeInterval);
        }

        List<Interval> freeIntervals = new ArrayList<>();
        EmployeeInterval prevEI = minHeap.peek();

        //Poll top in the heap, compare with previous, if overlaps, update prev, else, update free Interval.
        //Also, if next interval is present of currently polled employee, add his next interval
        while(!minHeap.isEmpty()) {
            EmployeeInterval currentEI = minHeap.poll();

            if(prevEI.interval.end >= currentEI.interval.start){
                prevEI.interval.end = Math.max(prevEI.interval.end, currentEI.interval.end);
            }
            else{
                if(prevEI != currentEI){
                    freeIntervals.add(new Interval(prevEI.interval.end, currentEI.interval.start));
                    prevEI = currentEI;
                }
            }

            if(hasNext(currentEI, schedule)){
                minHeap.offer(nextInterval(currentEI, schedule));
            }
        }
        return freeIntervals;
    }

    private boolean hasNext(EmployeeInterval ei, List<List<Interval>> schedule){
        return schedule.get(ei.EmployeeIndex).size() > ei.intervalIndex + 1;
    }

    private EmployeeInterval nextInterval(EmployeeInterval ei, List<List<Interval>> schedule){
        int employeeIndex = ei.EmployeeIndex;
        int intervalIndex = ei.intervalIndex + 1;
        Interval interval = schedule.get(employeeIndex).get(intervalIndex);

        return new EmployeeInterval(interval, employeeIndex, intervalIndex);
    }
}

class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
}

class EmployeeInterval {
    Interval interval;
    int EmployeeIndex;
    int intervalIndex;

    public EmployeeInterval(Interval i, int ei, int ii){
        this.interval = i;
        this.EmployeeIndex = ei;
        this.intervalIndex = ii;
    }

}
