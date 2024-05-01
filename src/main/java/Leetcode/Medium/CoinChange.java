package Leetcode.Medium;

import java.util.Arrays;

public class CoinChange {

    // https://www.youtube.com/watch?v=jgiZlGzXMBw
    public int coinChange(int[] coins, int amount) {
        if(coins == null)
            return 0;

        // Fill the cell with some invalid value because default value of 0 is a legit value
        long[] dp = new long[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=0;

        for(int i=0; i < coins.length; i++) {
            for(int amt = 1; amt < dp.length; amt++) {
                // If the coin is greater than the amount, then pass.
                if(amt-coins[i] >= 0)
                    dp[amt] = Math.min(dp[amt], 1 + dp[amt-coins[i]]); // Why +1 : Because you're using this coin
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : (int) dp[amount];
    }

}
