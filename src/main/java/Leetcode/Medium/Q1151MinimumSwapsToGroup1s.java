package main.java.Leetcode.Medium;

public class Q1151MinimumSwapsToGroup1s {
    public static void main(String[] args) {
        Q1151MinimumSwapsToGroup1s obj = new Q1151MinimumSwapsToGroup1s();
        int[] nums = {1,0,1,0,1};
        nums = new int[]{1,0,1,0,1,0,0,1,1,0,1};
        System.out.println(obj.minSwaps(nums));
    }

    // https://www.geeksforgeeks.org/minimum-swaps-required-group-1s-together/

    // the final result we want is a window with length of n (total number of the 1s)
    // Check all the window with the same length n, find the one which contains the most 1s, lets sat max 1.
    // All we need to do is to swap the rest: n-max.

    // A simple solution is to first count total number of 1’s in the array.
    // Suppose this count is x, now we need to find the subarray of length x of this array with maximum number of 1’s.
    // And minimum swaps required will be the number of 0’s in the subarray of length x with maximum number of 1’s.
    public int minSwaps(int[] data) {
        int totalOnes = 0;
        for (int i : data) {
            if (i == 1)
                totalOnes++;
        }

        int slow = 0;
        int fast = 0;
        int maxOnes = 0;
        int curOnes = 0;

        while (fast < data.length) {

            if (fast - slow < totalOnes) { // window limit mein hai. Index difference agar 5 hoga to total elements 6 cover ho rahe honge.
                if (data[fast] == 1) {
                    curOnes++;
                    maxOnes = Math.max(maxOnes, curOnes);
                }
                fast++;
            } else { // window badi ho gayi hai, slow ko badhane ka time aa gaya hai
                if (data[slow] == 1) {
                    curOnes--;
                }
                slow++;
            }
        }

        return totalOnes - maxOnes;
    }

    public int minSwaps2(int[] data) {
        int cnt = 0;
        for (int num : data) if (num == 1) cnt++;
        if (cnt == 0) return 0;
        int left = 0, zeros = 0, min = data.length;

        for (int right = 0; right < data.length; right++){
            if (data[right] == 0)
                zeros++;

            // if window size larger than number of 1s move left pointer
            if (right - left + 1 > cnt){
                if (data[left] == 0)
                    zeros--;
                left++;
            }
            //for every correct window size we record the number of zeros which is the number of switch
            if (right - left + 1 == cnt)
                min = Math.min(min, zeros);
        }
        return min;
    }
}
