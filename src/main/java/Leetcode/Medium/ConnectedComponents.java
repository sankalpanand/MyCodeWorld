package Leetcode.Medium;

import Leetcode.ParentClasses.UnionFind;

public class ConnectedComponents implements UnionFind {

    // https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/discuss/516491/Java-Union-Find-DFS-BFS-Solutions-Complexity-Explain-Clean-code
    // Time: O(n+mlogn), where m is the number of connections, n is the number of nodes.
    public int countComponents(int n, int[][] edges)
    {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;

        int components = n;

        for (int[] e : edges)
        {
            int p1 = findParent(parent, e[0]);
            int p2 = findParent(parent, e[1]);

            if (p1 != p2) {
                parent[p1] = p2; // P2 ko P1 ka parent bana do
                components--;
            }
        }
        return components;
    }

    private int findParent(int[] parent, int i) {
        if (i == parent[i])
            return i;

        parent[i] = findParent(parent, parent[i]);  // Path compression
        return parent[i];
    }
}
