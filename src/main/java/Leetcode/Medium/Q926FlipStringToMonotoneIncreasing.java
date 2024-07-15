package Leetcode.Medium;

import java.util.Arrays;

public class Q926FlipStringToMonotoneIncreasing {
    // Leetcode - https://leetcode.com/problems/flip-string-to-monotone-increasing/description/
    // Neetcode - https://www.youtube.com/watch?v=tMq9z5k3umQ
    // Neetcode's solution is complex.
    // Much better solution is from here - https://leetcode.com/problems/flip-string-to-monotone-increasing/solutions/1269957/two-concepts-four-implementation-with-explanation-for-beginners/
    public static void main(String[] args) {
        Q926FlipStringToMonotoneIncreasing obj = new Q926FlipStringToMonotoneIncreasing();
        obj.minFlipsMonoIncr("00110");
    }

    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int[] ones = new int[n];
        int[] zeros = new int[n];

        // Calculate the number of ones up to each position
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                ones[i] = (i == 0 ? 0 : ones[i - 1]) + 1;
            } else {
                ones[i] = (i == 0 ? 0 : ones[i - 1]);
            }
        }

        // Calculate the number of zeros from each position to the end
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                zeros[i] = (i == n - 1 ? 0 : zeros[i + 1]) + 1;
            } else {
                zeros[i] = (i == n - 1 ? 0 : zeros[i + 1]);
            }
        }

        System.out.println(Arrays.toString(zeros));


        int minFlips = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            int currFlips = (i == 0 ? 0 : ones[i - 1]);     // If we flip all the ones on the left to zeros
            currFlips += (i == n ? 0 : zeros[i]);           // Add the zero -> one flips to the right

            minFlips = Math.min(minFlips, currFlips);
        }

        return minFlips;
    }

    // DP
    /*
    Suppose we know that s[0...i - 1] is a monotone increasing array,
    if s[i] is 1 then we maintain the monotone increasing property and don't have to do anything.
    if s[i] is 0, we have two choice,
        - we can either do flip that element or
        - flips every 1 in s[0...i].
    Both of these action maintain the monotone increasing property.
     */
    public int minFlipsMonoIncr_DP(String s) {
        int n = s.length();
        int oneCounts = 0;
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            if (s.charAt(i - 1) == '1') {
                dp[i] = dp[i - 1];
                oneCounts++;
            } else {
                dp[i] = Math.min(dp[i - 1] + 1, oneCounts);
            }
        }

        return dp[n];
    }


}
