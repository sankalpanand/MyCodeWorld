package Leetcode.Medium;

public class RedundantConnections {
    public static void main(String[] args) {

    }

    public int[] findRedundantConnection(int[][] edges) {
        int[] sets = new int[edges.length + 1];

        for(int[] edge : edges) {
            int u = find(sets, edge[0]);
            int v = find(sets, edge[1]);
            if(u == v)
                return edge;
            sets[u] = v;
        }

        return new int[]{};
    }

    int find(int[] sets, int v) {
        if(sets[v] == 0)
            return v;

        sets[v] = find(sets, sets[v]);

        return sets[v];
    }
}
