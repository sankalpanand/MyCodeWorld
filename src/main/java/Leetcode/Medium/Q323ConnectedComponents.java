package Leetcode.Medium;

import Leetcode.ParentClasses.UnionFind;

import java.util.Arrays;

public class Q323ConnectedComponents implements UnionFind {

    // https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
    // Neetcode - https://www.youtube.com/watch?v=8f1XPm4WOUc
    // Also known as number of friend groups
    // This is essentially 1D version of Island 2 problem (union find)
    public int countComponents_DFS(int n, int[][] edges)
    {
        // Create a parent array which will keep track of the parent for each node
        // Initially each node will be a parent of its own
        int[] parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;

        // Initially we'll have n separate components, and we'll keep reducing this number each time we're doing a union
        int components = n;

        // With each edge added, check which island is e[0] or e[1] belonging to.
        for (int[] e : edges) {
            int p1 = findParent(parent, e[0]);
            int p2 = findParent(parent, e[1]);
            // If p1 == p2 then it means that they are in same islands, do nothing, so we don't want to decrement the number of components
            // If p1 != p2, then it means they belong to different islands and connecting them will reduce the components
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

    public int countComponents(int n, int[][] edges)
    {
        // Create a parent array which will keep track of the parent for each node
        // Initially each node will be a parent of its own
        int[] parent = new int[n];
        int[] rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        // Initially we'll have n separate components, and we'll keep reducing this number each time we're doing a union
        int components = n;

        // With each edge added, check which island is e[0] or e[1] belonging to.
        for (int[] e : edges) {
            int p1 = findParent(parent, e[0]);
            int p2 = findParent(parent, e[1]);
            // If p1 == p2 then it means that they are in same islands, do nothing, so we don't want to decrement the number of components
            // If p1 != p2, then it means they belong to different islands and connecting them will reduce the components
            if (p1 != p2) {
                parent[p1] = p2; // P2 ko P1 ka parent bana do
                components--;
            }
        }
        return components;
    }

    public int find(int[] parentArr, int v) {
        if(parentArr[v] == 0)
            return v;

        parentArr[v] = find(parentArr, parentArr[v]);

        return parentArr[v];
    }

    public boolean union(int[] parent, int[] rank, int n1, int n2) {
        int p1 = find(parent, n1);
        int p2 = find(parent, n2);

        if(p1 == p2)
            return false;

        if(rank[p1] > rank[p2]) {
            parent[p2] = p1;
            rank[p1] = rank[p1] + rank[p2];
        } else {
            parent[p1] = p2;
            rank[p2] = rank[p2] + rank[p1];
        }
        return true;
    }
}
