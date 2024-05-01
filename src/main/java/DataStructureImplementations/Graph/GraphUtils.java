package DataStructureImplementations.Graph;

import java.util.*;

public class GraphUtils {

	// Creates a graph with V vertices and E edges
	public Graph createGraph(int V, int E)
	{
	    Graph graph = new Graph();
	    graph.numOfvertices = V;
	    graph.numOfedges = E;
	 
	    graph.edges = new ArrayList<Edge>();
	 
	    return graph;
	}
	
	// A utility function to find the subset of an element i
	int find(int parent[], int i)
	{
	    if (parent[i] == -1)
	        return i;
	    return find(parent, parent[i]);
	}
	 
	// A utility function to do union of two subsets 
	void Union(int parent[], int x, int y)
	{
	    int xset = find(parent, x);
	    int yset = find(parent, y);
	    parent[xset] = yset;
	}
}
