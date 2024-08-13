package Leetcode.Medium;

import java.util.Arrays;

public class Q279PerfectSquares {
    public static void main(String[] args) {

    }

    // Leetcode - https://leetcode.com/problems/perfect-squares/description/
    // Neetcode - https://www.youtube.com/watch?v=HLZLwjzIVGo
    // Similar to coin change problem
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n); // Initialize dp array with a large value
        dp[0] = 0;

        for (int target = 1; target <= n; target++) {
            for (int s = 1; s * s <= target; s++) {
                int square = s * s;
                int rem = target - square;
                dp[target] = Math.min(dp[target], 1 + dp[rem]);
            }
        }

        return dp[n];
    }
}
