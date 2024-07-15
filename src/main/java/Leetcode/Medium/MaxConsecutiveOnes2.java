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

    // From the editorial
    public static int findMaxConsecutiveOnes(int[] nums) {
        int left=0, right=0, numZeroes=0;

        // While our window is in bounds
        while (right < nums.length) {

            // Increase numZeroes if the rightmost element is 0
            if (nums[right] == 0) {
                numZeroes++;
            }

            //If our window is invalid, contract our window
            if(numZeroes>1) {
                if (nums[left] == 0) {
                    numZeroes--;
                }
                left++;
            }

            // Expand our window
            right++;
        }

        return right-left;
    }

    public int longestOnes3(int[] nums, int k) {
        int left=0, right=0, numZeroes=0;

        while (right < nums.length) {
            if (nums[right] == 0){
                numZeroes++;
            }


            if(numZeroes > k) {
                if (nums[left] == 0){
                    numZeroes--;
                }
                left++;
            }

            right++;
        }
        return right-left;
    }
}
