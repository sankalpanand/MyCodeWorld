package Leetcode.Medium;

import Leetcode.ParentClasses.UnionFind;

public class NumberOfProvinces implements UnionFind {

    class UnionFind {
        private int count = 0;
        private int[] parent, rank;

        public UnionFind(int n)
        {
            // Initial count will start from N. We'll reduce the count as we'll union the sets.
            count = n;


            parent = new int[n];
            rank = new int[n];

            // Initialize it with i ka parent i
            for (int i = 0; i < n; i++)
            {
                parent[i] = i;
            }
        }

        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];    // path compression by halving
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);

            // Agar dono ka root same hai, then do nothing
            if (rootP == rootQ)
                return;

            if (rank[rootQ] > rank[rootP])
            {
                parent[rootP] = rootQ;
            }
            else // rank[rootQ] <= rank[rootP]
            {
                parent[rootQ] = rootP;

                // Agar dono ki rank same thi, to ek ki rank badha do
                if (rank[rootP] == rank[rootQ])
                {
                    rank[rootP]++;
                }
            }

            // Reduce the count by 1, because you have combined two sets.
            count--;
        }

        public int count() {
            return count;
        }
    }

    public int findCircleNum(int[][] M) {
        int n = M.length;

        // This will just initialize two arrays - parent and rank of size n
        UnionFind uf = new UnionFind(n);

        for (int i=0; i < n-1; i++)
        {
            for (int j=i+1; j < n; j++)
            {
                if (M[i][j] == 1)
                    uf.union(i, j);
            }
        }

        return uf.count();
    }


    // Another DFS solution - Complexity O (n sq)
    public void dfs(int[][] M, int[] visited, int i) {

        // i'th friend is fixed, now find his relation with j'th friend.
        for (int j = 0; j < M.length; j++)
        {
            if(i == j)  // This is the same person
                continue;

            // If j is a friend of i and j isn't visited, then mark j as visited and start DFS on this new found friend.
            if (M[i][j] == 1 && visited[j] == 0)
            {
                visited[j] = 1;

                dfs(M, visited, j);
            }
        }
    }

    public int findCircleNumDFS(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++)
        {
            if (visited[i] == 0)
            {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }
}
