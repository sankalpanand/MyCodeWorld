package Leetcode.Medium;

import java.util.HashMap;
import java.util.Map;

public class Q2958LengthOfLongestSubarrayWithAtMostKFrequency {
    // Neetcode - https://www.youtube.com/watch?v=W_KYZGp2QzU
    // Leetcode - https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency/description/
    public int maxSubarrayLength(int[] nums, int k) {
        int res = 0;
        Map<Integer, Integer> count = new HashMap<>();
        int l = 0;

        for (int r = 0; r < nums.length; r++) {
            count.put(nums[r], count.getOrDefault(nums[r], 0) + 1);

            while (count.get(nums[r]) > k) {
                count.put(nums[l], count.get(nums[l]) - 1);
                l++;
            }
            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
