package Leetcode.Medium;

import java.util.*;

public class Q417PacificAtlanticWaterFlow {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length;
        int COLS = heights[0].length;
        Set<Pair<Integer, Integer>> pacificVisited = new HashSet<>();
        Set<Pair<Integer, Integer>> atlanticVisited = new HashSet<>();

        for (int c = 0; c < COLS; c++) {
            dfs(0, c, pacificVisited, heights, heights[0][c]);                  // TOP row
            dfs(ROWS - 1, c, atlanticVisited, heights, heights[ROWS - 1][c]);   // BOTTOM row
        }

        for (int r = 0; r < ROWS; r++) {
            dfs(r, 0, pacificVisited, heights, heights[r][0]);                  // LEFT column pacific
            dfs(r, COLS - 1, atlanticVisited, heights, heights[r][COLS - 1]);   // RIGHT column atlantic
        }

        // By this point we have marked all the cells that can be visited by Pacific and Atlantic ocean
        // Now walk over both the visit sets and filter out the common values
        List<List<Integer>> res = new ArrayList<>();
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                Pair<Integer, Integer> cell = new Pair<>(r, c);
                if (pacificVisited.contains(cell) && atlanticVisited.contains(cell)) {
                    res.add(Arrays.asList(r, c));
                }
            }
        }
        return res;
    }

    private void dfs(int r, int c, Set<Pair<Integer, Integer>> visit, int[][] heights, int prevHeight) {
        int ROWS = heights.length;
        int COLS = heights[0].length;
        Pair<Integer, Integer> cell = new Pair<>(r, c);

        if (visit.contains(cell) || r < 0 || r == ROWS || c < 0 || c == COLS || heights[r][c] < prevHeight) {
            return;
        }

        visit.add(cell);
        dfs(r + 1, c, visit, heights, heights[r][c]);
        dfs(r - 1, c, visit, heights, heights[r][c]);
        dfs(r, c + 1, visit, heights, heights[r][c]);
        dfs(r, c - 1, visit, heights, heights[r][c]);
    }

    static class Pair<U, V> {
        public final U first;
        public final V second;

        public Pair(U first, V second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Pair)) return false;
            Pair<?, ?> p = (Pair<?, ?>) o;
            return Objects.equals(first, p.first) && Objects.equals(second, p.second);
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }

        @Override
        public String toString() {
            return "(" + first + ", " + second + ")";
        }
    }
}
