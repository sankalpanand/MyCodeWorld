package Leetcode.Medium;

import java.util.*;

public class TopKFrequentElements {
    public static void main(String[] args) {
        TopKFrequentElements obj = new TopKFrequentElements();

//        int[] nums = {1,1,1,2,2,3};
        int[] nums = {1,2};
        System.out.println(Arrays.toString(obj.topKFrequent(nums, 2)));
    }

    public int[] topKFrequent(int[] nums, int k) {

        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        List<Integer> res = new ArrayList<>();

        for (int pos = bucket.length - 1; pos >= 0; pos--) {
            if (bucket[pos] != null) {
                res.addAll(bucket[pos]);

                if(res.size() == k) {
                    break;
                }
            }
        }

        return res.stream().mapToInt(i->i).toArray();
    }
}
