package Leetcode.Easy;

import java.util.HashMap;
import java.util.Map;

public class Q359LoggerRateLimiter2 {
    public static void main(String[] args) {
        Q359LoggerRateLimiter2 obj = new Q359LoggerRateLimiter2();
        System.out.println(obj.shouldPrintMessage(1, "foo"));;
        System.out.println(obj.shouldPrintMessage(2, "bar"));
        System.out.println(obj.shouldPrintMessage(3, "foo"));
        System.out.println(obj.shouldPrintMessage(8, "bar"));
        System.out.println(obj.shouldPrintMessage(10, "foo"));
        System.out.println(obj.shouldPrintMessage(11, "foo"));

//        System.out.println(obj.shouldPrintMessage(100, "bug"));;
//        System.out.println(obj.shouldPrintMessage(110, "bug"));


    }
    private Map<String, Integer> cacheOld;
    private Map<String, Integer> cacheNew;
    private int latest;

    /** Initialize your data structure here. */
    public Q359LoggerRateLimiter2() {
        this.cacheNew = new HashMap<String, Integer>();
        this.latest = 0;
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(timestamp >= latest + 10) {
            cacheNew.clear();
            latest = timestamp;
        }

        if(cacheNew.containsKey(message))
            return false;

        cacheNew.put(message, timestamp);
        return true;
    }
}
