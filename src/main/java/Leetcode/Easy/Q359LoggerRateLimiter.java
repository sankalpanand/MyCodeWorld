package Leetcode.Easy;

import java.util.HashMap;
import java.util.Map;

public class Q359LoggerRateLimiter {

    public static void main(String[] args) {
        Q359LoggerRateLimiter obj = new Q359LoggerRateLimiter();
//        System.out.println(obj.shouldPrintMessage(1, "foo"));;
//        System.out.println(obj.shouldPrintMessage(2, "bar"));
//        System.out.println(obj.shouldPrintMessage(3, "foo"));
//        System.out.println(obj.shouldPrintMessage(8, "bar"));
//        System.out.println(obj.shouldPrintMessage(10, "foo"));
//        System.out.println(obj.shouldPrintMessage(11, "foo"));

        System.out.println(obj.shouldPrintMessage(0, "foo"));;
        System.out.println(obj.shouldPrintMessage(1, "foo"));;
        System.out.println(obj.shouldPrintMessage(3, "foo"));
//        System.out.println(obj.shouldPrintMessage(10, "foo"));
        System.out.println(obj.shouldPrintMessage(11, "foo"));
    }
    private Map<String, Integer> ok = new HashMap<>();

    // Disadvantage - Hashmap keeps growing
    public boolean shouldPrintMessage2(int timestamp, String message) {
        if (timestamp < ok.getOrDefault(message, 0))
            return false;

        ok.put(message, timestamp + 10);

        return true;
    }

    private Map<String, Integer> cacheOld;
    private Map<String, Integer> cacheNew;
    private int latest;

    /** Initialize your data structure here. */
    public Q359LoggerRateLimiter() {
        this.cacheOld = new HashMap<String, Integer>();
        this.cacheNew = new HashMap<String, Integer>();

        this.latest = 0;
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(timestamp >= latest + 20) {
            cacheOld.clear();
            cacheNew.clear();
            latest = timestamp;
        }

        else if(timestamp >= latest + 10) {
            cacheOld = new HashMap<>(cacheNew);
            cacheNew.clear();
            latest = timestamp;
        }

        // If you receive a message already in current cache, you can return false
        if(cacheNew.containsKey(message))
            return false;

        // If the message is in the prev cache, you ask the question - has 10s passed since this message was printed?
        if(cacheOld.containsKey(message)){
            int last = cacheOld.get(message);
            if(last + 10 > timestamp)
                return false;
        }

        // otherwise, you can print this message so store it in current cache and return true
        cacheNew.put(message, timestamp);
        return true;
    }
}
