package LinkedList;


public class Node<K, V> 
{
	public Node<K, V> next;
	public Node<K, V> prev;
	public Node<K, V> last;
	public int data;
	
	public Node(int d, Node<K, V> next, Node<K, V> previous) 
	{
		data = d;
		setNext(next);
		setPrevious(previous);
	}
	
	public void setNext(Node<K, V> n) 
	{
		// Step 1: Update the pointer
		next = n;
		
		// Step 2: Check if the given node was the last node, then you need to update the last pointer also.
		if (this == last) 
		{
			last = n;
		}
		
		// Step 3: Form the backward link
		if (n != null && n.prev != this) 
		{
			n.setPrevious(this);
		}
	}
	
	public void setPrevious(Node<K, V> p) 
	{
		prev = p;
		
		if (p != null && p.next != this) 
		{
			p.setNext(this);
		}
	}	
	
	public String printForward() 
	{
		if (next != null) 
		{
			return data + "->" + next.printForward();
		} 
		else 
		{
			return ((Integer) data).toString();
		}
	}
	
	public Node<K, V> clone() 
	{
		Node<K, V> next2 = null;
		if (next != null) 
		{
			next2 = next.clone();
		}
		Node<K, V> head2 = new Node<K, V>(data, next2, null);
		return head2;
	}
}
