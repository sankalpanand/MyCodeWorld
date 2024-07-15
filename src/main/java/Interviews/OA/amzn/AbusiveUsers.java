package Interviews.OA.amzn;

import java.util.*;

public class AbusiveUsers {
    // https://leetcode.com/discuss/interview-question/5089031/Amazon-OA
    public static void main(String[] args) {
        AbusiveUsers obj = new AbusiveUsers();

        String[] logs = {"1 2 50", "1 7 70", "1 3 20", "2 2 17"};
        int threshold = 2;
        obj.fetchAbusiveUsers(logs, threshold);

        logs = new String[]{"9 7 50", "22 7 20", "33 7 50", "22 7 30"};
        threshold = 3;
        obj.fetchAbusiveUsers(logs, threshold);
    }

    public int[] fetchAbusiveUsers(String[] logs, int threshold) {
        Map<String, Integer> freq = new HashMap<>();
        for (String log : logs) {
            String sender = log.split(" ")[0];
            String receiver = log.split(" ")[1];

            freq.put(sender, freq.getOrDefault(sender, 0) + 1);
            if(!receiver.equals(sender))
                freq.put(receiver, freq.getOrDefault(receiver, 0) + 1);
        }

        Map<String, Integer> sortedMap = sortByValue(freq);

        List<String> res = new ArrayList<>();
        sortedMap.forEach((key, value) -> {
            if (value >= threshold) {
                res.add(key);
            }
        });

        return null;
    }

    public Map<String, Integer> sortByValue(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());

        Map<String, Integer> result = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }
}
