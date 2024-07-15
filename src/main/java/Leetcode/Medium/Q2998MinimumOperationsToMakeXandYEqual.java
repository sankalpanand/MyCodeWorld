package Leetcode.Medium;

import java.util.Arrays;

public class Q2998MinimumOperationsToMakeXandYEqual {
    public static void main(String[] args) {
        Q2998MinimumOperationsToMakeXandYEqual obj = new Q2998MinimumOperationsToMakeXandYEqual();
        System.out.println(obj.minimumOperationsToMakeEqual(26, 1));
    }

    // Best solution - https://leetcode.com/problems/minimum-number-of-operations-to-make-x-and-y-equal/solutions/4518333/c-java-simple-dp-very-easy-and-simple-to-understand/
    private int[] dp;

    public int solve(int x, int y) {
        if (x <= y)
            return y - x;

        if (dp[x] != -1)
            return dp[x];

        // Just abs diff of x & y can be ans. So initialise res = abs(x - y)
        int res = Math.abs(x - y);

        // We may go to multiple of 5 which is smaller than x.
        // This can be achieved by just subtracting x%5 from x and divide x by 5.
        // Here total operations = x%5 ( this many time decreament ) + 1( for division by 5).
        res = Math.min(res, 1 + x % 5 + solve(x / 5, y));

        // We may go to multiple of 5 which is larger than x.
        // This can be achieved by just adding (5 - x%5) to x and then divid x by 5.
        // Here total operations = 5 - x%5 (this many time increment ) + 1 ( for division by 5).
        res = Math.min(res, 1 + (5 - x % 5) + solve(x / 5 + 1, y));

        // Repeat the same thing with 11
        res = Math.min(res, 1 + x % 11 + solve(x / 11, y));
        res = Math.min(res, 1 + (11 - x % 11) + solve(x / 11 + 1, y));

        return dp[x] = res;
    }
    public int minimumOperationsToMakeEqual(int x, int y) {
        dp = new int[10011];
        Arrays.fill(dp, -1);
        return solve(x, y);
    }
}
