package Leetcode.Medium;

import Leetcode.ParentClasses.PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class Q523ContinuousSubarraySum extends PrefixSum {
    // Neetcode - https://www.youtube.com/watch?v=OKcrLfR-8mE
    // Leetcode - https://leetcode.com/problems/continuous-subarray-sum/description/

    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> remainder = new HashMap<>();
        remainder.put(0, -1); // map remainder -> end index
        int total = 0;

        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            int r = total % k;
            if (!remainder.containsKey(r)) {
                remainder.put(r, i);
            } else if (i - remainder.get(r) > 1) {
                return true;
            }
        }

        return false;
    }
}
