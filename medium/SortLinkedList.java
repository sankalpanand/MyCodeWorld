package medium;

public class SortLinkedList {

	public static void main(String[] args) 
	{
		ListNode head = new ListNode(5);
		head.AddToTail(4);
		head.AddToTail(3);
		head.AddToTail(2);
		head.AddToTail(1);
		
		sortList(head);
		
	}

	/* The idea is to find out the head and the mid of the LL. 
	 * Then you de-link the two. 
	 * Send them to merge list function.
	 * You can recurse on each of the smaller lists. */
	public static ListNode sortList(ListNode head) 
	{
		if (head == null || head.next == null)
			return head;
		
		ListNode fast = head.next.next;
		ListNode slow = head;
		
		while (fast != null && fast.next != null) 
		{
			slow = slow.next;
			fast =  fast.next.next;
		} // Slow.next gives you the head of the second half
		
		// 2- Sort first half
		ListNode h2 = sortList(slow.next);
		
		// 3- Delink the lists
		slow.next = null;
		
		// 4- Sort second half
		ListNode h1 = sortList(head);
		 
		// 5- Merge the two sorted lists
		return merge(h1, h2);
	}
	
	public static ListNode merge(ListNode h1, ListNode h2) 
	{
		ListNode dummy = new ListNode(Integer.MIN_VALUE);
		ListNode mergedListPointer = dummy;
		
		while (h1 != null && h2 != null) 
		{
			if (h1.val < h2.val) 
			{
				mergedListPointer.next = h1;
				h1 = h1.next;
			}
			// You can't use if() - else if() in such conditions. Duplicates will cause trouble.
			else 
			{
				mergedListPointer.next = h2;
				h2 = h2.next;
			}
			
			mergedListPointer = mergedListPointer.next;
		}
		
		// Remember, it is if() not while()
		if (h1 != null)
			mergedListPointer.next = h1;
		
		if (h2 != null)
			mergedListPointer.next = h2;
		
		return dummy.next;
	}

}
