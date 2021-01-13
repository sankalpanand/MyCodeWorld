package HashMap;

public class LinkedListNode<K, V> 
{
	public LinkedListNode<K, V> next;
	public LinkedListNode<K, V> prev;
	public K key;
	public V value;
	
	public LinkedListNode(K k, V v) 
	{
		key = k;
		value = v;
	}
	
	public String printForward() 
	{
		String data = "(" + key + "," + value + ")";
		if (next != null) 
		{
			return data + "->" + next.printForward();
		} 
		else 
		{
			return data;
		}
	}
}	
