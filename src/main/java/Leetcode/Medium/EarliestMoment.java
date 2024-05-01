package Leetcode.Medium;

import Leetcode.ParentClasses.UnionFind;

import java.util.Arrays;

public class EarliestMoment implements UnionFind {
    // https://leetcode.com/problems/the-earliest-moment-when-everyone-become-friends/discuss/326305/Union-Find(Java)

    public int earliestAcq(int[][] logs, int N)
    {
        int[] parent = new int[N];
        for (int i = 0; i < N; i++)
            parent[i] = i;

        // Sort the array as per the timestamp
        Arrays.sort(logs, (a, b) -> (a[0] - b[0]));

        for (int[] log : logs) {
            int root1 = find(parent, log[1]);
            int root2 = find(parent, log[2]);

            if (root1 != root2) {
                parent[root1] = root2;
                N--;
            }

            if (N == 1)
                return log[0];
        }
        return -1;
    }

    int find(int[] parent, int i) {
        while (parent[i] != i)
        {
            i = parent[parent[i]];
        }
        return i;
    }

}
