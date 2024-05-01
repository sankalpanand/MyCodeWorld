package LinkedList;


public class Operations<K, V>
{
	public Node<K, V> randomLinkedList(int N, int min, int max) 
	{
		Node<K, V> root = new Node<K, V>(randomIntInRange(min, max), null, null);
		Node<K, V> prev = root;
		
		// One element formed and designated as root, now generate rest. [i=1]
		for (int i = 1; i < N; i++) 
		{
			Node<K, V> next = new Node<K, V>(randomIntInRange(min, max), null, null);
			prev.setNext(next);
			prev = next;
		}
		return root;
	}


	public Node<K, V> createLinkedListFromArray(int[] vals) 
	{
		Node<K, V> head = new Node<K, V>(vals[0], null, null);
		Node<K, V> current = head;
		for (int i = 1; i < vals.length; i++) 
		{
			current = new Node<K, V>(vals[i], null, current);
		}
		return head;
	}
	
	public static int randomInt(int n) 
	{
		return (int) (Math.random() * n);
	}

	public static int randomIntInRange(int min, int max) 
	{
		return randomInt(max + 1 - min) + min;
	}
}
