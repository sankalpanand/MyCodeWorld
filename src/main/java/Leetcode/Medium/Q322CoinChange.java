package Leetcode.Medium;

import java.util.Arrays;

public class Q322CoinChange {
    public static void main(String[] args) {
        Q322CoinChange obj = new Q322CoinChange();
        int[] coins = {2};
        System.out.println(obj.coinChange(coins, 3));
    }

    // https://www.youtube.com/watch?v=H9bfqozjoqs
    // https://leetcode.com/problems/coin-change/description/
    public int coinChange(int[] coins, int amount) {
        if(coins == null)
            return 0;

        // Fill the cell with some invalid value because default value of 0 is a legit value
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount + 1);
        dp[0]=0;

        for(int a = 1; a <= amount; a++) {
            for (int coin : coins) {
                // If the coin is greater than the remaining amount, then pass.
                // If I pick this coin, then remaining amount would be
                int rem = a - coin;
                if(rem >= 0)
                    dp[a] = Math.min(dp[a], 1 + dp[rem]); // Why +1 : Because you're using this coin
            }
        }

        return dp[amount] == (amount + 1) ? -1 : (int) dp[amount];
    }
}
