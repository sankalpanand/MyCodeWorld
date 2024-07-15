package Leetcode.Medium;

import java.util.*;

public class Q743NetworkDelayTime {
    public static void main(String[] args) {

    }

    // Neetcode - https://www.youtube.com/watch?v=EaphyqKU4PQ
    // Leetcode - https://leetcode.com/problems/network-delay-time/description/
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> edges = new HashMap<>();
        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];
            if (!edges.containsKey(u)) {
                edges.put(u, new ArrayList<>());
            }
            edges.get(u).add(new int[]{v, w});
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        Set<Integer> visit = new HashSet<>();
        int t = 0;
        minHeap.offer(new int[]{0, k});

        while (!minHeap.isEmpty()) {
            int[] node = minHeap.poll();
            int w1 = node[0];
            int n1 = node[1];
            if (visit.contains(n1)) {
                continue;
            }

            visit.add(n1);

            t = Math.max(t, w1);
            // or t = w1 also works

            // BFS Portion of it
            List<int[]> adj = edges.getOrDefault(n1, new ArrayList<>());
            for (int[] edge : adj) {
                int n2 = edge[0];
                int w2 = edge[1];
                if (!visit.contains(n2)) {
                    minHeap.offer(new int[]{w2 + w1, n2});
                }
            }
        }
        return visit.size() == n ? t : -1;
    }

}
