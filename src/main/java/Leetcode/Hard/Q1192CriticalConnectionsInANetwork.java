package Leetcode.Hard;

import java.util.*;

public class Q1192CriticalConnectionsInANetwork {
    public static void main(String[] args) {
        int n = 4;

        List<List<Integer>> connections = new ArrayList<>();
        connections.add(new ArrayList<>(Arrays.asList(0, 1)));
        connections.add(new ArrayList<>(Arrays.asList(1, 2)));
        connections.add(new ArrayList<>(Arrays.asList(2, 0)));
        connections.add(new ArrayList<>(Arrays.asList(1, 3)));

        Q1192CriticalConnectionsInANetwork obj = new Q1192CriticalConnectionsInANetwork();
        System.out.println(obj.criticalConnections(n, connections));
    }


    // We record the timestamp that we visit each node. For each node, we check every neighbor except its parent and return a smallest timestamp in all its neighbors. If this timestamp is strictly less than the node's timestamp, we know that this node is somehow in a cycle. Otherwise, this edge from the parent to this node is a critical connection
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer>[] adjacencyList = new ArrayList[n];

        for (int i = 0; i < n; i++)
            adjacencyList[i] = new ArrayList<>();

        for(List<Integer> oneConnection : connections) {
            adjacencyList[oneConnection.get(0)].add(oneConnection.get(1));
            adjacencyList[oneConnection.get(1)].add(oneConnection.get(0));
        }

        int cost = 0;

        List<List<Integer>> results = new ArrayList<>();
        boolean[] visited = new boolean[n];
        int[] timeStampAtThatNode = new int[n];

        criticalConnectionsUtil(adjacencyList, -1, 0, cost, visited, results, timeStampAtThatNode);

        return results;
    }


    // Explanation - https://leetcode.com/problems/critical-connections-in-a-network/solutions/401340/clean-java-solution-with-explanation-great-question/comments/499388
    // https://www.youtube.com/watch?v=5xUdS0hclQ4
    public void criticalConnectionsUtil(List<Integer>[] adjacencyList, int parent, int node, int cost, boolean[] visited, List<List<Integer>> results, int []timeStampAtThatNode) {
        visited[node] = true;
        timeStampAtThatNode[node] = cost++;

        // this is to store your timestamp at the node you visit,
        // since timer keep increasing you wanna know when was the first time you visited that node.
        // e.g. when you visit node1 , timer is at 1, when you visit 2, timer increases to 2, and for node 3 it increases to 3

        // You need to know the current time when you enter the current node.
        // The intuition here is that DFS will travel to every unvisited node before it finishes processing the current node.
        // This is why timeStampAtThatNode[oneNeighbor] can guarantee that it contains the earliest time reachable by oneNeighbor
        int currentTimeStamp = timeStampAtThatNode[node];

        for(int neighbour : adjacencyList[node]) {
            if(neighbour == parent)
                continue;

            if(!visited[neighbour])
                criticalConnectionsUtil(adjacencyList, node, neighbour, cost, visited, results, timeStampAtThatNode);

            /*
            this is to minimize the timestamp of node visited if there are neighbors to lower it's timestamp;
            this is how we know some how there is another path to this node with lower cost/time
            For example when you hit 2 from 1, timer has increased to 2, but actual time/cost to 2 is not 2,
            it's 0 since it's connected to node 0 with lower cost of 0
            which means there is an alternative path to 2 from 0 that makes path 1->2 un-critical.

            You want to find the node with the earliest timestamp that you can reach from the current node, not including the parent node
             */
            timeStampAtThatNode[node] = Math.min(timeStampAtThatNode[node], timeStampAtThatNode[neighbour]);

            if(currentTimeStamp < timeStampAtThatNode[neighbour])
                results.add(Arrays.asList(node, neighbour));
        }
    }
}
