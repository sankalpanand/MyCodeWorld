package DataStructureImplementations.Graph;

import java.util.*;
import java.lang.*;
import java.io.*;

public class Prims
{
    // Number of vertices in the graph
    private static final int V=5;

    // A utility function to find the vertex with minimum key
    // value, from the set of vertices not yet included in MST
    int findMinimumCostUnincludedVertex(int key[], Boolean mstSet[])
    {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index=-1;

        for (int v = 0; v < V; v++)
            if (mstSet[v] == false && key[v] < min)
            {
                min = key[v];
                min_index = v;
            }

        return min_index;
    }

    // A utility function to print the constructed MST stored in parent[]
    void printMST(int parent[], int graph[][])
    {
        System.out.println("Edge   Weight");
        for (int i = 1; i < V; i++)
            System.out.println(parent[i]+" - "+ i+"\t"+ graph[i][parent[i]]);
    }

    /*
    https://www.geeksforgeeks.org/greedy-algorithms-set-5-prims-minimum-spanning-tree-mst-2/

    Vertex  ||  Key     ||      Parent
    A           0
    B           Infinity
    C           Infinity
    D           Infinity
    E           Infinity
     */

    // Function to construct and print MST for a graph represented
    //  using adjacency matrix representation
    void primMST(int graph[][])
    {
        // Array to store constructed MST
        int parent[] = new int[V];

        // It tells the distance for reaching i'th vertex
        int distanceToReachNode[] = new int [V];

        // Keep track of visited vertices
        Boolean visitedVertices[] = new Boolean[V];

        // Initialize all vertices distances as INFINITE, initialize all vertices visited state as false
        for (int i = 0; i < V; i++)
        {
            distanceToReachNode[i] = Integer.MAX_VALUE;
            visitedVertices[i] = false;
        }

        // Always include first 1st vertex in MST
        distanceToReachNode[0] = 0;     // Make distanceToReachNode 0 so that this vertex is picked as first vertex
        parent[0] = -1; // First node is always root of MST

        // The MST will have V vertices, follow this process for all the vertices
        for (int count = 0; count < V-1; count++)
        {
            // Pick thd minimum distanceToReachNode vertex from the set of vertices not yet included in MST
            int minimumCostUnincludedVertex = findMinimumCostUnincludedVertex(distanceToReachNode, visitedVertices);

            // Add the picked vertex to the MST Set
            visitedVertices[minimumCostUnincludedVertex] = true;

            // Update distanceToReachNode value and parent getCellIndex of the adjacent
            // vertices of the picked vertex. Consider only those
            // vertices which are not yet included in MST
            for (int v = 0; v < V; v++)

                // graph[minimumCostUnincludedVertex][v] is non zero only for adjacent vertices of m
                // visitedVertices[v] is false for vertices not yet included in MST
                // Update the distanceToReachNode only if graph[minimumCostUnincludedVertex][v] is smaller than distanceToReachNode[v]
                if (graph[minimumCostUnincludedVertex][v] != 0 &&                         // This vertex is the adjacent vertex of the current vertex  
                        visitedVertices[v] == false &&          // This vertex hasn't been visited
                        graph[minimumCostUnincludedVertex][v] <  distanceToReachNode[v])  // Cost of reaching this node from the current node is less than the cost computed earlier
                {
                    parent[v]  = minimumCostUnincludedVertex;                             // include the edge in the result
                    distanceToReachNode[v] = graph[minimumCostUnincludedVertex][v];       // Update the distance array for that node
                }
        }

        // print the constructed MST
        printMST(parent, graph);
    }

    public static void main (String[] args)
    {
        /* Let us create the following graph
           2    3
        (0)--(1)--(2)
        |    / \   |
        6| 8/   \5 |7
        | /      \ |
        (3)-------(4)
             9          */

        Prims t = new Prims();
        int graph[][] = new int[][] {
                {0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0},
        };

        // Print the solution
        t.primMST(graph);
    }
}
