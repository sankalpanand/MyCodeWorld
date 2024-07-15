package Leetcode.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q1443MinimumTimeToCollectApples {
    // Leetcode - https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/description/
    // Neetcode - https://www.youtube.com/watch?v=Xdt5Z583auM

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            int par = edge[0];
            int child = edge[1];
            adj.get(par).add(child);
            adj.get(child).add(par);
        }

        return dfs(0, -1, adj, hasApple);
    }

    private int dfs(int cur, int parent, Map<Integer, List<Integer>> adj, List<Boolean> hasApple) {
        int time = 0;
        for (int child : adj.get(cur)) {
            if (child == parent) {
                continue;
            }
            int childTime = dfs(child, cur, adj, hasApple);
            if (childTime > 0 || hasApple.get(child)) {
                time += 2 + childTime;
            }
        }
        return time;
    }
}
