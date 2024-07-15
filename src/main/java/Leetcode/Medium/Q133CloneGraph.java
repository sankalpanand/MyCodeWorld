package Leetcode.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Q133CloneGraph {

    private Map<Node, Node> oldToNew = new HashMap<>();

    // This will return a copy of a node
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        if (oldToNew.containsKey(node)) {
            return oldToNew.get(node);
        }

        Node copy = new Node(node.val);
        oldToNew.put(node, copy);

        for (Node neighbor : node.neighbors) {
            Node copyOfNeighbor = cloneGraph(neighbor);
            copy.neighbors.add(copyOfNeighbor);
        }

        return copy;
    }
}

// Already present in Leetcode
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
