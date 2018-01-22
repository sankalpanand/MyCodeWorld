package LeetcodeMedium;

public class RotateList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/* The approach is to get to the tail while taking the count.
	 * Then, move (n-k) steps from the tail 
	 * Then, the next pointer will be your new head !! */
	public ListNode rotateRight(ListNode head, int k) 
	{
		if(head == null) 
			return head;

		
		ListNode newHead = head;
		
		// Get the count of the LL
		int len=1; 
		ListNode tail = head;
		while(tail.next != null)  // get the number of nodes in the list
		{
			tail = tail.next;
			len++;
		}
		
		// Connect the tail to the head, make it a circle
		tail.next = head;

		// Normalize the rotations
		k = k % len;
		
		
		/* Now, the tail is connected to the head. So, head is 1st element from tail.
		 * (2) is the second element from tail
		 * (3) is the third element from tail
		 *  and so on...
		 *  So, move (n-k) from the tail and the next element will be your new head after rotation !!
		 *  */
		if(k != 0) 
		{
			// the tail node is the (len-k)-th node (1st node is head)
			for(int i=0; i<len-k; i++) 
				tail = tail.next; 
		}
		
		newHead = tail.next; 
		tail.next = null;
		return newHead;
	}

}
