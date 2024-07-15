package Leetcode.Medium;

import java.util.PriorityQueue;

public class Q2599PrefixSumNonNegative {
    public static void main(String[] args) {
        Q2599PrefixSumNonNegative obj = new Q2599PrefixSumNonNegative();
        int[] nums = {2,3,-5,4};
        System.out.println(obj.makePrefSumNonNegative(nums));

        nums = new int[]{3,-5,-2,6};
        System.out.println(obj.makePrefSumNonNegative(nums));

    }

    /*
    We can scan left to right, moving the minimum integer scanned so far to the end each time the sum of scanned integers goes negative.
     */

    public int makePrefSumNonNegative(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long prefixSum = 0;
        int res = 0;
        for (int num : nums) {
            prefixSum += num;
            pq.add(num);
            if (prefixSum < 0) {
                res++;
                prefixSum -= pq.poll();
            }
        }
        return res;
    }
}
