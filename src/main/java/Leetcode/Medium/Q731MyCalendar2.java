package Leetcode.Medium;

import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class Q731MyCalendar2 {

    private TreeMap<Integer, Integer> map = new TreeMap<>();

    /*
    Think of this as "scanning" from left to right with a "vertical laser".
    Every endpoint (a start point, or an end point) is an event. A start point is +1, an end point is -1.
    The accumulated value "count" would be the number of "active" intervals which is cut by the vertical laser.
     */

    public boolean book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        int count = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            count += entry.getValue();
            if(count > 2) {
                map.put(start, map.get(start) - 1);
                if(map.get(start) == 0) {
                    map.remove(start);
                }
                map.put(end, map.get(end) + 1);
                if(map.get(end) == 0) {
                    map.remove(end);
                }
                return false;
            }
        }
        return true;
    }

}
