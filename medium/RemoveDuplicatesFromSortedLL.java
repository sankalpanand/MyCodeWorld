package medium;

public class RemoveDuplicatesFromSortedLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// 1 Pointer solution
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
                pre.next=cur.next;
            }
			
			// Cur will move ahead in any case
            cur=cur.next;
		}

		return dummy.next;
	}

}
