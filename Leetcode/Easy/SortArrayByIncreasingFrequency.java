package Leetcode.Easy;

import java.util.*;

public class SortArrayByIncreasingFrequency {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Map.Entry is a key and its value combined into one class.
        // This allows you to iterate over Map.entrySet() instead of having to iterate over Map.keySet(), then getting the value for each key
        List<Map.Entry<Integer, Integer>> list = new ArrayList(map.entrySet());

        // Map's key will be number, value will be frequency
        // Smaller frequency should come first, if frequency is same then larger value should come first
        Collections.sort(list, (a, b) -> a.getValue() == b.getValue() ? b.getKey() - a.getKey() : a.getValue() - b.getValue());

        int index = 0;
        int[] res = new int[nums.length];

        for (Map.Entry<Integer, Integer> entry : list) {

            int frequency = entry.getValue();
            int number = entry.getKey();

            for (int i=0; i < frequency; i++) {
                res[index++] = number;
            }
        }
        return res;
    }
}
