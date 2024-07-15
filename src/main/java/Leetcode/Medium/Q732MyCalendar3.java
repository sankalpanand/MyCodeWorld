package Leetcode.Medium;

import java.util.Map;
import java.util.TreeMap;

public class Q732MyCalendar3 {

    private TreeMap<Integer, Integer> map = new TreeMap<>();

    public int book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);

        int ongoing = 0, k = 0;

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ongoing = ongoing + entry.getValue();
            k = Math.max(k, ongoing);
        }
        return k;
    }

}
