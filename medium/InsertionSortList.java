package medium;

public class InsertionSortList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(7);
		ListNode node3 = new ListNode(5);
		ListNode node4 = new ListNode(1);
		ListNode node5 = new ListNode(4);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		insertionSortList(node1);

	}
	
	// https://leetcode.com/discuss/24663/an-easy-and-clear-way-to-sort-o-1-space
	// Do it on paper. 
	// In every iteration, we move the pre pointer further in the array 
	// until we reach the point where current becomes smaller than the pre.next
	// It would mean, that we should insert our curr between pre and pre.next	
	public static ListNode insertionSortList(ListNode head) 
	{
		if( head == null )
		{
			return head;
		}

		ListNode helper = new ListNode(0); // new starter of the sorted list
		
		ListNode pre = helper; //insert node between pre and pre.next
		ListNode cur = head; // the node will be inserted		
		ListNode next = null; //the next node will be inserted
		
		//not the end of input list
		while( cur != null )
		{
			next = cur.next;
			
			//find the right place to insert
			while( pre.next != null && pre.next.val < cur.val )
			{
				pre = pre.next;
			}
			
			// Insert between pre and pre.next
			cur.next = pre.next;
			pre.next = cur;
			
			// Insertion over, reset pre. Take it back to the helper.
			pre = helper;
			
			// Move to the next node
			cur = next;
		}

		return helper.next;
	}

}
