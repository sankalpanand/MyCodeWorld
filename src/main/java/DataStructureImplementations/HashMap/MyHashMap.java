package HashMap;

import java.util.ArrayList;

//Remember: This generic is necessary for holding values of any data type
public class MyHashMap<K, V> 
{
	private ArrayList<LinkedListNode<K, V>> arr;
	
	/*** This initializes an ArrayList with null and puts a cap of capacity on it */
	public MyHashMap(int capacity) 
	{
		/* Create list of linked lists. */
		arr = new ArrayList<LinkedListNode<K, V>>();
		arr.ensureCapacity(capacity);
		
		for (int i = 0; i < capacity; i++) 
		{
			arr.add(null);
		}
	}
	
	/** Insert key and value into hash table. */
	public void put(K key, V value) 
	{
		// Step 1: Check if a node is there for the passed key.
		LinkedListNode<K, V> node = getNodeForKey(key);
		
		// Step 2: If it exists, update the value and return.
		if (node != null) 
		{
			node.value = value; // just update the value.
			return;
		}
		
		// Step 3: If the given key has no node, create one
		node = new LinkedListNode<K, V>(key, value);
		
		// Step 4: Since we have to store a new node, generate the getCellIndex for this key
		int index = getIndexForKey(key);
		
		// Step 5: Append this node to the front of the chain at this getCellIndex
		if (arr.get(index) != null) 
		{
			node.next = arr.get(index);
			node.next.prev = node;
		}
		
		// Step 6: Update the entry in the array list
		arr.set(index, node);
	}
	
	/* Remove node for key. */
	public void remove(K key) 
	{
		// Step 1 : Get the node present at the key
		LinkedListNode<K, V> node = getNodeForKey(key);
		
		// Step 2 : If node is not the first one in the chain, unlink this node from the chain
		if (node.prev != null) 
		{
			node.prev.next = node.next;
		} 
		
		// Step 3 : MyNode is the head, so make its next node as the head for this chain.
		else 
		{
			// Next wala element head par aa jayega
			int hashKey = getIndexForKey(key);
			arr.set(hashKey, node.next);
		}
		
		// Update prev pointers of neighbors
		if (node.next != null) 
		{
			node.next.prev = node.prev;
		}
	}
	
	/* Get value for key. */
	public V get(K key) 
	{
		LinkedListNode<K, V> node = getNodeForKey(key);
		return node == null ? null : node.value;
	}
	
	/* Get linked list node associated with a given key. */
	private LinkedListNode<K, V> getNodeForKey(K key) 
	{
		// Step 1 : Hash the key to get the getCellIndex
		int index = getIndexForKey(key);
		
		// Step 2 : Fetch the head of the chain at this getCellIndex
		LinkedListNode<K, V> current = arr.get(index);
		
		// Step 3 : Walk through this chain and keep matching the keys
		while (current != null) 
		{
			// If the key matches, return this node. If it doesn't match, move ahead.
			if (current.key == key) 
			{
				return current;
			}
			current = current.next;
		}
		return null;		
	}
	
	/* Basic hash function */
	public int getIndexForKey(K key) 
	{
		int hash = Math.abs(key.hashCode() % arr.size()); 
		return hash;
	}
	
	public void printTable() 
	{
		for (int i = 0; i < arr.size(); i++) 
		{
			String s = arr.get(i) == null ? "" : arr.get(i).printForward();
			System.out.println(i + ": " + s);
		}
	}
}
