package Leetcode.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfIslands2 {

    /*
        This is how the indices will look like in a 9*9 matrix
        00  01  02  03  04  05  06  07  08
        10  11  12  13  14  15  16  17  18
        20  21  22  23  24  25  26  27  28
        30  31  (32)  33  34  35  36  37  38
        40  41  42  43  44  45  46  47  48
        50  51  52  53  54  55  56  57  58
        60  61  62  63  64  65  66  67  68
        70  71  72  73  74  75  76  77  78
        80  81  82  83  84  85  86  87  88



        0  1  2     3  4  5  6  7  8
        9  10 11    12 13 14 15 16 17
        18 19 20    21 22 23 24 25 26
        27 28 (29)  30 31 32 33 34 35
    */

    private int[][] dir = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        UnionFind2D islands = new UnionFind2D(m, n);
        List<Integer> ans = new ArrayList<>();

        // Go through the positions
        for (int[] position : positions) {
            int x = position[0];
            int y = position[1];

            // Add karo aur jahan add kiya hai wahan ki roots save karo
            int p = islands.add(x, y);

            // Don't check neighbors if this cell has already been added
            if(p != 0) {
                for (int[] d : dir) {
                    // Aage pichhe wali cells ka roots nikaalo
                    int q = islands.getNeighborId(x + d[0], y + d[1]);

                    // Check karo jahan add kiya hai wo aur padosi ki ID same to nahi hai
                    if (q > 0 && !islands.find(p, q))

                        // Agar same parent hai, to dono ko unite kar do
                        islands.unite(p, q);
                }
            }

            // First position add ho gayi, ab total islands return kar do.
            ans.add(islands.size());
        }
        return ans;
    }


    class UnionFind2D {
        private int[] roots;
        private int[] ranks;
        private int m, n, count;

        public UnionFind2D(int m, int n) {
            this.count = 0;
            this.n = n;
            this.m = m;

            this.roots = new int[m * n + 1];
            Arrays.fill(this.roots, -1);

            this.ranks = new int[m * n + 1];
            Arrays.fill(this.ranks, 1);
        }

        public int getCellIndex(int x, int y) {
            return x * n + y + 1;
        }

        public int size() {
            return this.count;
        }

        public int getNeighborId(int x, int y) {
            if (0 <= x && x < m && 0<= y && y < n)
                return roots[getCellIndex(x, y)];
            return 0;
        }

        public int add(int x, int y) {
            int i = getCellIndex(x, y);

            // If we have already added this, it means it was a duplicate. Island count shouldn't be incremented.
            // Return zero.
            if(roots[i] == i) {
                return 0;
            }

            roots[i] = i;
            ranks[i] = 1;
            count++;
            return i;
        }

        public boolean find(int p, int q) {
            return root(p) == root(q);
        }

        public void unite(int p, int q) {
            int i = root(p);
            int j = root(q);

            // Now compare both the roots
            if (ranks[i] < ranks[j]) { //weighted quick union
                roots[i] = j;
                ranks[j] += ranks[i];
            } else {
                roots[j] = i;
                ranks[i] += ranks[j];
            }
            count--;
        }

        private int root(int i) {

            // See if i can lead you to a parent
            for (; i != roots[i]; i = roots[i]) {
                int parent = roots[i];
                roots[i] = roots[parent]; //path compression
            }

            return i;
        }
    }
}
