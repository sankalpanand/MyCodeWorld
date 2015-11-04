package easy;

public class RemoveDuplicatesFromSortedLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Common solution as Part II
	public ListNode deleteDuplicates(ListNode head) 
	{
		if(head == null || head.next == null) 
			return head;

		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;
		ListNode cur = head;

		while(cur != null) 
		{
			// Keep skipping the repeated elements
			while(cur.next !=null && cur.val==cur.next.val)
			{
				cur=cur.next;
			}
			// At the end of this while loop, curr will hold the last repeated node.

			// Check if no skipping actually took place, simply move the pre one step
			if(pre.next==cur)
			{
				pre=pre.next;
			}

			// Skipping took place, so next item will be the unique one so far
			else
			{
				pre.next=cur;

				// *********************************************************//
				// Just this line added from Remove Duplicates II to make it work
				pre = pre.next;
			}

			// Cur will move ahead in any case
			cur=cur.next;
		}

		return dummy.next;
	}

	// My accepted solution
	public ListNode deleteDuplicates2(ListNode head) {

		if(head == null) return null;

		ListNode back = head;
		ListNode front = head.next;

		while(front != null)
		{
			if(front.val == back.val)
			{
				back.next = front.next;
			}
			else
			{
				back = back.next;
			}

			front = front.next;
		}

		return head;
	}

	// Recursive solution
	public ListNode deleteDuplicatesR1(ListNode head) {
		if(head == null || head.next == null)return head;
		head.next = deleteDuplicates(head.next);
		return head.val == head.next.val ? head.next : head;
	}

	// Recursive solution
	public ListNode deleteDuplicatesR2(ListNode head) {
		if(head == null)
			return null;

		if(head.next != null && head.next.val == head.val) 
		{
			head.next = head.next.next;
			head = deleteDuplicates(head);
		}
		else
			head.next = deleteDuplicates(head.next);

		return head;

	}

	// 1 Pointer solution
	public ListNode deleteDuplicates3(ListNode head) {
		if(head == null || head.next == null) return head;

		ListNode list = head;
		while(list.next != null) 
		{
			if (list.val == list.next.val)
				list.next = list.next.next;
			else 
				list = list.next;
		}

		return head;
	}

}
