package medium;

import java.util.HashMap;

public class CloneGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
	
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) 
    {
        return clone(node);
    }

    private UndirectedGraphNode clone(UndirectedGraphNode node) 
    {
        if (node == null) 
        	return null;

        if (map.containsKey(node.label)) 
        {
            return map.get(node.label);
        }
        
        // Control reached till here, it means this node is not visited
        // Create a new node using having data as the present node
        UndirectedGraphNode clonedNode = new UndirectedGraphNode(node.label);
        
        // Mark it as visited by putting it in the map
        map.put(clonedNode.label, clonedNode);
        
        // Add each neighbor of the current node to the cloned node
        for (UndirectedGraphNode neighbor : node.neighbors) 
        {
        	clonedNode.neighbors.add(clone(neighbor));
        }
        
        return clonedNode;
    }
}
