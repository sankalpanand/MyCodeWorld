package Leetcode.Medium;

import java.util.*;

public class DesignLogStorageSystem {
    public static void main(String[] args) {
        LogSystem obj = new LogSystem();
        obj.put(1, "2017:01:01:23:59:59");
        obj.put(2, "2017:01:01:22:59:59");
        obj.put(3, "2016:01:01:00:00:00");


        List<Integer> param_2 = obj.retrieve("2016:01:01:01:01:01", "2017:01:01:23:00:00", "Year");
        List<Integer> param_3 = obj.retrieve("2016:01:01:01:01:01", "2017:01:01:23:00:00", "Hour");
    }
}

class LogSystem {
    private String min, max;
    private HashMap<String, Integer> map;

    // Because String implements interface called Comparable which compares two strings according to their lexicographical order.
    // Moreover, you can't put an object as a key into a TreeMap structure if a class of that object doesn't implement Comparable interface
    private TreeMap<String, LinkedList<Integer>> logs;

    public LogSystem() {
        min = "2000:01:01:00:00:00";
        max = "2017:12:31:23:59:59";

        map = new HashMap<>();
        map.put("Year", 4);
        map.put("Month", 7);
        map.put("Day", 10);
        map.put("Hour", 13);
        map.put("Minute", 16);
        map.put("Second", 19);

        // what is 4,7,10,13,16,19 in the above program?
        // I believe they are the indices of the ':' after each time granularity (Year, or Month or Day),
        // so that we could use this index to cut off part of the timestamp to make up the real start and ending boundary.

        logs = new TreeMap<>();
    }

    public void put(int id, String timestamp)
    {
        if(!logs.containsKey(timestamp))
            logs.put(timestamp, new LinkedList<>());

        logs.get(timestamp).add(id);
    }

    public List<Integer> retrieve(String s, String e, String gra)
    {
        int index = map.get(gra);
        String start = s.substring(0, index) + min.substring(index);
        String end = e.substring(0, index) + max.substring(index);

        return retrieve(start, end);
    }

    private List<Integer> retrieve(String start, String end) {
        List<Integer> allIds = new ArrayList<>();

        for (String timestamp: logs.keySet()) {
            if (timestamp.compareTo(start) >= 0 && timestamp.compareTo(end) <= 0) {
                allIds.addAll(logs.get(timestamp));
            }
        }

        return allIds;
    }
}
