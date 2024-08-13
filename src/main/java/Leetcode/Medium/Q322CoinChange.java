package Leetcode.Medium;

import java.util.Arrays;

public class Q322CoinChange {
    public static void main(String[] args) {
        Q322CoinChange obj = new Q322CoinChange();
        int[] coins = {2};
//        System.out.println(obj.coinChange(coins, 3));
//        System.out.println(obj.coinChange(new int[] {1,2,5}, 11));
        System.out.println(obj.coinChange(new int[] {2}, 3));
    }

    // https://www.youtube.com/watch?v=H9bfqozjoqs
    // https://leetcode.com/problems/coin-change/description/
    public int coinChange(int[] coins, int amt) {
        if(coins == null)
            return 0;

        // Fill the cell with some invalid value because default value of 0 is a legit value
        int[] dp = new int[amt+1];

        // Take a minute to understand what values we can use as invalid values
        // We can't use Integer.MAX_VALUE because whenever we'll do 1 + dp[rem] it'll turn into negative and will impact the Min operation
        // We can't use any negative value either because it'll impact our Min calculations
        // So its better to use amt+1 or any other number greater than amt
        Arrays.fill(dp, amt+1);
        dp[0] = 0;

        // a = amounts ranging from 1 to amt. We'll calculate DP[a] such that it'll tell us minimum coins to make amt a.
        for(int a = 1; a <= amt; a++) {
            for (int coin : coins) {
                // If the coin is greater than the remaining amt, then pass.
                // If I pick this coin, then remaining amt would be
                int rem = a - coin;
                if(rem >= 0)
                    dp[a] = Math.min(dp[a], 1 + dp[rem]); // Why +1 : Because you're using this coin
            }
        }

        return dp[amt] == (amt + 1) ? -1 : dp[amt];
    }
}
