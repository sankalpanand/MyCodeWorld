package Leetcode.Medium;

import java.util.*;

public class Q787CheapestFlightsWithinKStops {
    public static void main(String[] args) {

    }

    // Leetcode solution- https://leetcode.com/problems/cheapest-flights-within-k-stops/solutions/115541/java-c-python-priority-queue-solution-tle-now/
    // By Lee215
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        // Create a map = {source city : Map<destination city, price>}
        Map<Integer, Map<Integer, Integer>> prices = new HashMap<>();
        for (int[] f : flights) {
            int from = f[0];
            if (!prices.containsKey(from))
                prices.put(from, new HashMap<>());
            prices.get(from).put(f[1], f[2]);
        }

        // Min heap that will keep the array with minimum price at the top always
        // {current total price, current source city, max distance to destination}
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> (Integer.compare(a[0], b[0])));

        // Why k+1 ? Because we're allowed k stops, so we can move k+1 times.
        // If layover allowed is 1, then we'll have to take two flights.
        pq.add(new int[] {0, src, k + 1});

        HashMap<Integer, int[]> seen = new HashMap<>(); //new change

        while (!pq.isEmpty()) {
            // Get the cheapest flight
            int[] top = pq.remove();
            int price = top[0];
            int city = top[1];
            int stops = top[2];

            if (seen.containsKey(city) && seen.get(city)[0] < price && seen.get(city)[1] < stops)
                continue; //new change

            seen.put(city, new int[]{price, stops}); //new change

            if (city == dst)
                return price;

            if (stops > 0) {
                // Get all the flights that fly out from the current source city
                Map<Integer, Integer> adj = prices.getOrDefault(city, new HashMap<>());

                // Calculate new price and new distance and add them to PQ
                for (int a : adj.keySet()) {
                    pq.add(new int[] {price + adj.get(a), a, stops - 1});
                }
            }
        }
        return -1;
    }

    // Bellman Ford
    // Neetcode - https://www.youtube.com/watch?v=5eIK3zUdYmE
    public int findCheapestPrice_BF(int n, int[][] flights, int src, int dst, int K) {
        int[] prices = new int[n];
        Arrays.fill(prices,Integer.MAX_VALUE);
        prices[src]=0;

        for(int i=0; i<=K; i++) {
            int[] tempPrices = Arrays.copyOf(prices,n);

            for(int[] f: flights) {
                int curr=f[0], next=f[1], price=f[2];

                // If the cost to reach this source is INF then we don't want to visit that
                if(prices[curr]==Integer.MAX_VALUE)
                    continue;


                tempPrices[next] = Math.min(tempPrices[next], prices[curr] + price);
            }
            prices = tempPrices;
        }

        return prices[dst] == Integer.MAX_VALUE ? -1:prices[dst];
    }

    // BFS - https://leetcode.com/problems/cheapest-flights-within-k-stops/solutions/3099885/day-26-simple-bfs-easiest-beginner-friendly-solution/
    public int findCheapestPrice_BFS(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] flight : flights) {
            adj.get(flight[0]).add(new int[] {flight[1], flight[2]});
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {src, 0});
        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        int stops = 0;

        while (!q.isEmpty() && stops <= k) {
            int size = q.size();
            while (size-- > 0) {
                int[] curr = q.poll();
                for (int[] neighbour : adj.get(curr[0])) {
                    int price = neighbour[1], neighbourNode = neighbour[0];
                    if (price + curr[1] >= minCost[neighbourNode])
                        continue;
                    minCost[neighbourNode] = price + curr[1];
                    q.offer(new int[] {neighbourNode, minCost[neighbourNode]});
                }
            }
            stops++;
        }
        return minCost[dst] == Integer.MAX_VALUE ? -1 : minCost[dst];
    }
}
