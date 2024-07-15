package Leetcode.Medium;

import Leetcode.ParentClasses.UnionFind;

import java.util.*;

public class Q261GraphValidTree implements UnionFind {
    // Two approaches-
    // 1. Union Find, 2. DFS
    public boolean validTree(int n, int[][] edges) {
        // initialize n isolated islands
        int[] nums = new int[n];
        Arrays.fill(nums, -1);

        // perform union find
        for (int i = 0; i < edges.length; i++)
        {
            int x = find(nums, edges[i][0]);
            int y = find(nums, edges[i][1]);

            // if two vertices happen to be in the same set
            // then there's a cycle
            if (x == y)
                return false;

            // union
            nums[x] = y;
        }

        return edges.length == n - 1;
    }

    int find(int nums[], int i)
    {
        if (nums[i] == -1)
            return i;

        return find(nums, nums[i]);
    }

    // Neetcode - https://www.youtube.com/watch?v=bXsUuownnoQ
    // Leetcode - https://leetcode.com/problems/graph-valid-tree/
    public boolean validTree_DFS(int n, int[][] edges) {
        if (n == 0) {
            return true;
        }

        // Build adjacency list
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            int n1 = edge[0], n2 = edge[1];
            adj.get(n1).add(n2);
            adj.get(n2).add(n1);
        }

        Set<Integer> visit = new HashSet<>();

        // There are two things that make a graph a tree -
        // 1. This ensures there is no cycle
        if (!dfs(0, -1, adj, visit)) {
            return false;
        }

        // 2. This ensure that we can reach all nodes
        return visit.size() == n;
    }

    // This basically tells us if there's a cycle
    private boolean dfs(int i, int prev, Map<Integer, List<Integer>> adj, Set<Integer> visit) {
        if (visit.contains(i)) {
            return false;
        }

        visit.add(i);
        for (int j : adj.get(i)) {
            // If one neighbor is the parent, we skip it
            if (j == prev) {
                continue;
            }

            // We check the cycle on all other neighbors
            if (!dfs(j, i, adj, visit)) {
                return false;
            }
        }
        return true;
    }
}
