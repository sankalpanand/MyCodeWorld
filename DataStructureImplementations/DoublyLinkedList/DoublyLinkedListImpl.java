package DoublyLinkedList;

import java.util.NoSuchElementException;

public class DoublyLinkedListImpl<E> 
{
	public static void main(String a[])
	{
		DoublyLinkedListImpl<Integer> dll = new DoublyLinkedListImpl<Integer>();
		dll.addFirst(10);
		dll.addFirst(34);
		dll.addLast(56);
		dll.addLast(364);
		dll.iterateForward();
		dll.removeFirst();
		dll.removeLast();
		dll.iterateBackward();
	}


	private Node head;
	private Node tail;
	private int size;

	public DoublyLinkedListImpl() 
	{
		size = 0;
	}

	public int size() { return size; }

	public boolean isEmpty() { return size == 0; }

	public void addFirst(int element) 
	{
		Node tmp = new Node(element, head, null);

		// If it is not the first node, then link the temp and head
		if(head != null ) {head.prev = tmp;}

		// Update the head pointer
		head = tmp;

		// Agar tail khali thi, matlab ye pahla element hi tha... to temp ko hi tail bhi bana do
		if(tail == null) { tail = tmp;}

		// Size badha do
		size++;
		System.out.println("adding: "+element);
	}

	// Same thing as above for add Last also 
	public void addLast(int element) 
	{
		Node tmp = new Node(element, null, tail);
		if(tail != null) {tail.next = tmp;}
		tail = tmp;
		if(head == null) { head = tmp;}
		size++;
		System.out.println("adding: "+element);
	}

	
	public void iterateForward()
	{
		System.out.println("iterating forward..");
		Node tmp = head;
		while(tmp != null){
			System.out.println(tmp.element);
			tmp = tmp.next;
		}
	}

	public void iterateBackward()
	{
		System.out.println("iterating backword..");
		Node tmp = tail;
		while(tmp != null){
			System.out.println(tmp.element);
			tmp = tmp.prev;
		}
	}

	public int removeFirst() 
	{
		if (size == 0) throw new NoSuchElementException();
		Node tmp = head;
		head = head.next;
		head.prev = null;
		size--;
		System.out.println("deleted: "+tmp.element);
		return  tmp.element;
	}

	public int removeLast() 
	{
		if (size == 0) throw new NoSuchElementException();
		Node tmp = tail;
		tail = tail.prev;
		tail.next = null;
		size--;
		System.out.println("deleted: "+tmp.element);
		return  tmp.element;
	}

}
