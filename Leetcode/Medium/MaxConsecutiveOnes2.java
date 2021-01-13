package Leetcode.Medium;

public class MaxConsecutiveOnes2 {
    public static void main(String[] args) {
        // int[] num = {1,1,0,1,1,1};
        // int[] num = {1,0,1,1,0};
        int[] num = {1,0,1,1,1,1,1,1,0,1,1,1,0};
        System.out.println(findMaxConsecutiveOnes(num));

    }

    /*
    Given a binary array, find the maximum number of consecutive 1s in this array if you can flip at most one 0.
    Example 1: Input: [1,0,1,1,0] Output: 4 Explanation: Flip the first zero will get the the maximum number of consecutive 1s.
    After flipping, the maximum number of consecutive 1s is 4.

    Note: The input array will only contain 0 and 1. The length of input array is a positive integer and will not exceed 10,000

    Input: [1,0,1,1,0]
    Output: 4
    Explanation: Flip the first zero will get the the maximum number of consecutive 1s. After flipping, the maximum number of consecutive 1s is 4.
     */

    public static int findMaxConsecutiveOnes(int[] nums) {
        int  maxConsecutive = 0;
        int onesToTheLeftIncluding = 0; // This will keep count of all the one's before this zero including this zero
        int runningCountOfOnes = 0; // This will keep count of all the one's before this zero including this zero

        for( int  i = 0; i < nums.length; ++i) {
            ++runningCountOfOnes;

            // As soon as you find zero,  
            if  (nums[i] == 0) {
                onesToTheLeftIncluding = runningCountOfOnes;
                runningCountOfOnes = 0;
            }
            maxConsecutive = Math.max(maxConsecutive, onesToTheLeftIncluding + runningCountOfOnes);
            System.out.println("nums[i]: " + nums[i] + "\trunningCountOfOnes: " + runningCountOfOnes + "\tonesToTheLeftIncluding: " + onesToTheLeftIncluding + "\tmaxConsecutive: " + maxConsecutive);
        }
        return   maxConsecutive;
    }
}
