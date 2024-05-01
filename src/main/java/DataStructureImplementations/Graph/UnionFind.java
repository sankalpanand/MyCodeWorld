package Graph;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tusroy
 * Date 06/20/2015
 *  
 * Video link - https://www.youtube.com/watch?v=ID00PMy0-vE
 *  
 *  Use cases of Disjoint Sets-
 *  1. Kruscal's algorithm uses disjoint sets
 *  2. Finding cycles in graph
 *  
 *  Space - O(n)
 *  Time - O (m alpha(n)) | alpha(n) <=4 => O(4m) => O(m)
 * Disjoint sets using path compression and union by rank
 * Supports 3 operations
 * 1) makeSet
 * 2) union
 * 3) findSet
 *
 */

public class UnionFind 
{
	private Map<Long, Node> map = new HashMap<>();

	class Node
	{
		long data;
		Node parent;
		int rank;
	}

	public static void main(String args[])
	{
		UnionFind ds = new UnionFind();
		ds.makeSet(1);
		ds.makeSet(2);
		ds.makeSet(3);
		ds.makeSet(4);
		ds.makeSet(5);
		ds.makeSet(6);
		ds.makeSet(7);

		ds.union(1, 2);
		ds.union(2, 3);
		ds.union(4, 5);
		ds.union(6, 7);
		ds.union(5, 6);
		ds.union(3, 7);

		System.out.println(ds.findRepresentativeSet(1));
		System.out.println(ds.findRepresentativeSet(2));
		System.out.println(ds.findRepresentativeSet(3));
		System.out.println(ds.findRepresentativeSet(4));
		System.out.println(ds.findRepresentativeSet(5));
		System.out.println(ds.findRepresentativeSet(6));
		System.out.println(ds.findRepresentativeSet(7));

	}

	/**
	 * Create a set with only one element.
	 */
	public void makeSet(long data)
	{
		Node node = new Node();
		node.data = data;
		node.parent = node;
		node.rank = 0;
		map.put(data,  node);
	}

	/**
	 * Combines two sets together to one. Does union by rank
	 */
	public void union(long data1, long data2)
	{
		// Step 1- Find nodes for the given data
		Node node1 = map.get(data1);
		Node node2 = map.get(data2);

		// Step 2- Find the parent for both of them
		Node parent1 = findSetFromNode(node1);
		Node parent2 = findSetFromNode(node2);

		// If the nodes have same parent, then do nothing
		if(parent1.data == parent2.data)
		{
			return;
		}

		// Step 3- Update ranks.
		// If parent1's rank is more, make him parent of parent2 as well
		if(parent1.rank >= parent2.rank)
		{
			//increment rank only if both sets have same rank
			parent1.rank = (parent1.rank == parent2.rank) ? parent1.rank + 1 : parent1.rank; 
			parent2.parent = parent1;
		}

		// Do the same thing for parent 2
		else
		{
			parent1.parent = parent2;
		}
	}

	/**
	 * Find the representative recursively and does path
	 * compression as well.
	 */
	private Node findSetFromNode(Node node)
	{
		Node parent = node.parent;
		if(parent == node)
		{
			return parent;
		}

		// Path compression- We connect this node directly to most senior parent
		Node dadaji = findSetFromNode(node.parent);
		node.parent = dadaji;

		// That most senior parent
		return dadaji;
	}

	/**
	 * Finds the representative of this set
	 */
	public long findRepresentativeSet(long data){
		return findSetFromNode(map.get(data)).data;
	}


}
