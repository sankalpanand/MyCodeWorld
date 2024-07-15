package Leetcode.Medium;

import java.util.Arrays;

public class Q684RedundantConnections {
    public static void main(String[] args) {
        Q684RedundantConnections obj = new Q684RedundantConnections();
        int[][] edge = {{7,8},{2,6},{2,8},{1,4},{9,10},{1,7},{3,9},{6,9},{3,5},{3,10}};
        System.out.println(Arrays.toString(obj.findRedundantConnection(edge)));

    }
    // Leetcode - https://leetcode.com/problems/redundant-connection/description/
    // Neetcode - https://www.youtube.com/watch?v=FXWRE67PLL0
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1];
        int[] rank = new int[edges.length + 1];

        for (int i = 0; i < edges.length + 1; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for(int[] edge : edges) {
            boolean res = union(parent, rank, edge[0], edge[1]);
            System.out.println(Arrays.toString(parent) + "\t\t\t" + Arrays.toString(rank));
            if (! res)    // Will return False if parents are the same
                return new int[] {edge[0], edge[1]};
        }

        return new int[]{};
    }

    public int find(int[] parentArr, int v) {
        if(parentArr[v] == v)
            return v;

        parentArr[v] = find(parentArr, parentArr[v]);

        return parentArr[v];
    }

    // This is from Neetcode and it doesn't work for some test cases. Refer to above.
//    public int find(int[] parentArr, int v) {
//        if(parentArr[v] == v)
//            return v;
//
//        int parOfV = parentArr[v];
//
//        // Path compression
//        while (parOfV != parentArr[v]) {
//            parentArr[parOfV] = parentArr[parentArr[parOfV]];
//            parOfV = parentArr[parOfV];
//        }
//
//        return parOfV;
//    }

    public boolean union(int[] parent, int[] rank, int n1, int n2) {
        int p1 = find(parent, n1);
        int p2 = find(parent, n2);
        System.out.println("p1: " + p1 + "\t p2: " + p2);

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
