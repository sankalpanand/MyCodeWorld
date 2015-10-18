package medium;

public class RotateList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

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
