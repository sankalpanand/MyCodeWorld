package Leetcode.Medium;

import java.util.*;

public class TopKFrequentWords {
    public static void main(String[] args) {
        TopKFrequentWords obj = new TopKFrequentWords();

//        int[] nums = {1,1,1,2,2,3};
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        System.out.println(obj.topKFrequent(words, 1));
    }

    public List<String> topKFrequent(String[] words, int k) {

        TreeSet<String>[] bucket = new TreeSet[words.length + 1];
        Map<String, Integer> frequencyMap = new HashMap<String, Integer>();

        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        for (String key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new TreeSet<>();
            }
            bucket[frequency].add(key);
        }

        List<String> res = new ArrayList<>();

        for (int pos = bucket.length - 1; pos >= 0; pos--) {
            if (bucket[pos] != null) {
                for(String word : bucket[pos]) {
                    res.add(word);
                    if(res.size() == k) {
                        return res;
                    }
                }
            }
        }

        return res;
    }
}
