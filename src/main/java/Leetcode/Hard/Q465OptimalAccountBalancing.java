package Leetcode.Hard;

import java.util.HashMap;
import java.util.Map;

public class Q465OptimalAccountBalancing {
    // Leetcode - https://leetcode.com/problems/optimal-account-balancing/description/

    public int minTransfers(int[][] transactions) {
        // Key: person's ID   Value: person's balance after calculation
        // {1 : -5} means person 1 should get $5
        // {2 : 10} means person 2 should pay $10
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] trans : transactions) {
            map.put(trans[0], map.getOrDefault(trans[0], 0) - trans[2]);
            map.put(trans[1], map.getOrDefault(trans[1], 0) + trans[2]);
        }

        // Since after we get those amount of balance, person's ID does not affect the final result
        int n = map.size(), i = 0;

        // Balance array for all the participants
        int[] balance = new int[n];
        for (int k : map.keySet()) {
            balance[i++] = map.get(k);
        }

        return dfs(0, balance);
    }

    private int dfs(int idx, int[] balance) {
        if (idx == balance.length)              // all balance are cleared ==> requires 0 operation
            return 0;

        if (balance[idx] == 0)                  // curr person has balance 0 ==> skip curr person
            return dfs(idx + 1, balance);

        int res = Integer.MAX_VALUE;

        int currDebt = balance[idx];

        for (int i = idx+1; i < balance.length; i++) {
            // Its only useful to make a transaction if one party is positive and other is negative.
            // If both are positive or both are negative then transaction can not happen. So skip such pairs.
            if (balance[i] * currDebt >= 0)
                continue;

            /* Key Step 2 : 
                transfer all balance from balance[idx] to balance[i], i.e. after the transaction, balance[idx] = 0
                dfs 1 -> balance[1] = balance[0] + balance[1]
                dfs 2 -> balance[2] = balance[1] + balance[2]
                dfs 3 -> balance[3] = balance[2] + balance[3]
                So we add up balances for 1, then 2, then 3 etc.
                Once we've exhausted all the array, we'd have recorded all the transactions in res.

                Then we'll start adding up balances for 1, then 3, then 4... etc. So we'll try all the combinations and get the lowest possible result.

            */
            balance[i] += currDebt;
            res = Math.min(res, 1 + dfs(idx + 1, balance));
            balance[i] -= currDebt;
        }
        return res;
    }
}
