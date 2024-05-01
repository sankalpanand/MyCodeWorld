package main.java.Leetcode.Medium;

public class Q2422MergeOperationsTurnArrayInPalind {

    // time = O(n), space = O(1)
    public int minimumOperations(int[] nums) {
        int n = nums.length, left = nums[0], right = nums[n - 1], cnt = 0;
        int i=0;
        int j = n-1;
        while (i < j) {
            // If elements at both ends are same, update the indices and the elements on the new indices
            if (left == right) {
                i++;
                j--;
                left = nums[i];
                right = nums[j];
            } else if (left < right) {
                i++;
                left += nums[i];
                cnt++;
            } else if (left > right) {
                j--;
                right += nums[j];
                cnt++;
            }
        }
        return cnt;
    }
}
