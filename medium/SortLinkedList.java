package medium;

public class SortLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode sortList(ListNode head) 
	{
		if (head == null || head.next == null)
			return head;
		
		ListNode fast = head.next.next;
		ListNode slow = head;
		
		while (fast != null && fast.next != null) 
		{
			slow = slow.next;
			fast =  fast.next.next;
		}
		
		ListNode h2 = sortList(slow.next); // 1
		slow.next = null;
		ListNode h1 = sortList(head); // 2
		 
		return merge(h1, h2); // 3
	}
	
	public ListNode merge(ListNode h1, ListNode h2) 
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
