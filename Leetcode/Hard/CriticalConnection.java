package Leetcode.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class CriticalConnection {

    // Read this for explanation -
    // https://leetcode.com/problems/critical-connections-in-a-network/discuss/382638/DFS-detailed-explanation-O(orEor)-solution

    ArrayList<Integer>[] graph;
    int[] rank;
    HashSet<List<Integer>> connectionsSet;


    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        graph = new ArrayList[n];
        connectionsSet = new HashSet<>(connections);
        rank = new int[n];
        Arrays.fill(rank, -2);

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // This will create an arraylist of size n.
        // Each getCellIndex will hold indices of other vertices that this node connects to.
        for(List<Integer> connection : connections) {
            int u = connection.get(0);
            int v = connection.get(1);

            graph[u].add(v);
            graph[v].add(u);
        }


        dfs(0, 0);

        return new ArrayList<>(connectionsSet);
    }

    public int dfs(int node, int depth) {

        // This is supposed to be a new node with rank -2, but if you find some positive rank on it,
        // it means this node has already been covered and an edge between this node and current node will result in a cycle.
        // visiting (0<=rank<n), or visited (rank=n)
        if (rank[node] >= 0) {
            return rank[node]; // already visited node. return its rank
        }

        // If this node has a rank zero, set its rank as the depth (which is +1 from the one before it)
        rank[node] = depth;
        int minDepthFound = Integer.MAX_VALUE; // can be Integer.MAX_VALUE also.

        // Now iterate over all the neighbors of this node. It'll be zero at the beginning.
        for(Integer neighbor: graph[node]) {

            // Make sure you don't go back, so ignore the parent.
            // that's why i didn't choose -1 as the special value, in case depth==0
            if (rank[neighbor] == depth-1){
                continue;
            }

            // But only the current level of search knows it finds a cycle.
            // How does the upper level of search knows, if you backtrack?
            // Let's make use of the return value of DFS: dfs function returns the minimum rank it finds.
            int minDepth = dfs(neighbor, depth+1);
            minDepthFound = Math.min(minDepthFound, minDepth);

            // During a step of search from node u to its neighbor v,
            // if dfs(v) returns something smaller than or equal to rank(u),
            // then u knows its neighbor v helped it to find a cycle back to u or u's ancestor.
            if (minDepth <= depth){
                // to avoid the sorting just try to remove both combinations. of (x,y) and (y,x)
                connectionsSet.remove(Arrays.asList(node, neighbor));
                connectionsSet.remove(Arrays.asList(neighbor, node));
            }
        }

        return minDepthFound;
    }


    // Solution 2 - https://leetcode.com/problems/critical-connections-in-a-network/discuss/401340/Clean-Java-Solution-With-Explanation!!!-Great-Question!
    // We record the timestamp that we visit each node. 
    // For each node, we check every neighbor except its parent and return a smallest timestamp in all its neighbors. 
    // If this timestamp is strictly less than the node's timestamp, we know that this node is somehow in a cycle. 
    // Otherwise, this edge from the parent to this node is a critical connection
    public List<List<Integer>> criticalConnections2(int n, List<List<Integer>> connections) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) 
            graph[i] = new ArrayList<>();

        for(List<Integer> oneConnection :connections) {
            graph[oneConnection.get(0)].add(oneConnection.get(1));
            graph[oneConnection.get(1)].add(oneConnection.get(0));
        }
        
        int timer[] = new int[1];
        List<List<Integer>> results = new ArrayList<>();
        boolean[] visited = new boolean[n];
        int[] timeStampAtNode = new int[n];
        
        criticalConnectionsUtil(graph, -1, 0, timer, visited, results, timeStampAtNode);
        
        return results;
    }


    public void criticalConnectionsUtil(List<Integer>[] graph, int parent, int node, int timer[], boolean[] visited, List<List<Integer>> results, int []timeStampAtNode) {
        visited[node] = true;
        timeStampAtNode[node] = timer[0]++;

        // this is to store your timestamp at the node you visit,
        // since timer keep increasing you wanna know when was the first time you visited that node.
        // e.g. when you visit node1 , timer is at 1, when you visit 2, timer increases to 2, and for node 3 it increases to 3.
        // You need to know when you started when you come back from recursive function
        int currentTimeStamp = timeStampAtNode[node];

        for(int oneNeighbour : graph[node]) {
            if(oneNeighbour == parent)
                continue;

            if(!visited[oneNeighbour])
                criticalConnectionsUtil(graph, node, oneNeighbour, timer, visited, results, timeStampAtNode);

            // this is to minimize the timestamp of node visited in case there are neighbors to lower its timestamp;
            // this is how we know somehow there is another path to this node with lower cost/time.
            timeStampAtNode[node] = Math.min(timeStampAtNode[node], timeStampAtNode[oneNeighbour]);

            if(currentTimeStamp < timeStampAtNode[oneNeighbour])
                results.add(Arrays.asList(node, oneNeighbour));
        }


    }
}
