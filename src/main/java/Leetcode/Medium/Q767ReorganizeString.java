package Leetcode.Medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Q767ReorganizeString {
    public static void main(String[] args) {
        Q767ReorganizeString obj = new Q767ReorganizeString();
        System.out.println(obj.reorganizeString("aaab"));
    }

    // Algorithm
    // We want to separate the most frequently occurring characters first
    // Sometimes the most frequent character is occurring more than half of the times, we won't be able to generate a string in that case

    public String reorganizeString(String S) {
        int[] frequencyMap = new int[26];

        // Put the frequency in an array
        for (int i = 0; i < S.length(); i++) {
            frequencyMap[S.charAt(i) - 'a']++;
        }

        int max = 0, letter = 0;
        for (int i=0; i < frequencyMap.length; i++) {
            if (frequencyMap[i] > max) {
                max = frequencyMap[i];
                letter = i;
            }
        }

        // One letter occurs so many times that its impossible to separate
        // abaaaba - 7
        if (max > (S.length() + 1) / 2) {
             return "";
        }

        char[] res = new char[S.length()];
        int idx = 0;

        // Put max occurring character in alternate places
        while (frequencyMap[letter] > 0) {
            res[idx] = (char) (letter + 'a');
            idx += 2;
            frequencyMap[letter]--;
        }

        // Put remaining characters from the hash to alternate places
        // We can continue with the idx
        for (int i = 0; i < frequencyMap.length; i++) {
            while (frequencyMap[i] > 0) {

                // If idx has reached the end, then we'll start with the odd numbers
                if (idx >= res.length) {
                    idx = 1;
                }
                res[idx] = (char) (i + 'a');
                idx += 2;
                frequencyMap[i]--;
            }
        }
        return String.valueOf(res);
    }

    // Solution using PriorityQueue
    public String reorganizeString2(String S) {
        if (S == null || S.length() == 0) {
            return "";
        }

        /* store char-frequency pair into map */
        Map<Character, Integer> map = new HashMap<>();
        for (char c : S.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // push all map entry into priority element, by sorting from high frequency to low frequency
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
                (a, b) -> (b.getValue() - a.getValue())
        );

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.offer(entry);
        }


        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {

            // store character with highest frequency in cache
            Map.Entry<Character, Integer> cache = pq.poll();

            // StringBuilder appends at the end, so make sure if if the last character is different
            if (sb.length() == 0 || cache.getKey() != sb.charAt(sb.length() - 1)) {
                sb.append(cache.getKey());
                cache.setValue(cache.getValue() - 1);

                // if current character still have more quota left, push back to queue
                if (cache.getValue() != 0) {
                    pq.offer(cache);
                }
            }

            // if character in cache is same as tail character in current string
            // we need to try the character with second highest frequency
            else {
                Map.Entry<Character, Integer> cache2 = pq.poll();
                // corner case: if no more elements in queue, the input string should be invalid
                // because we do not have any other characters that different with current string tail
                if (cache2 == null) {
                    return "";
                }
                sb.append(cache2.getKey());
                cache2.setValue(cache2.getValue() - 1);

                // if current character still have more quota left, push back to queue
                if (cache2.getValue() != 0) {
                    pq.offer(cache2);
                }
                // DO NOT FORGET to push top frequency entry into queue as well
                pq.offer(cache);
            }
        }
        return sb.toString();
    }
}
