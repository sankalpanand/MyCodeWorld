package Leetcode.Medium;

import Leetcode.ParentClasses.PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class Q560SubarraySumEqualsK extends PrefixSum {
    /*
    Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
    A subarray is a contiguous non-empty sequence of elements within an array.
    Example 1:
    Input: nums = [1,1,1], k = 2
    Output: 2

    Example 2:
    Input: nums = [1,2,3], k = 3
    Output: 2

    Leetcode - https://leetcode.com/problems/subarray-sum-equals-k/description/
    Neetcode - https://www.youtube.com/watch?v=fFVZt-6sgyo
     */

    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int curSum = 0;
        Map<Integer, Integer> prefixSums = new HashMap<>();
        prefixSums.put(0, 1);

        for (int n : nums) {
            curSum += n;
            int diff = curSum - k;
            res += prefixSums.getOrDefault(diff, 0);
            prefixSums.put(curSum, prefixSums.getOrDefault(curSum, 0) + 1);
        }

        return res;
    }

}
