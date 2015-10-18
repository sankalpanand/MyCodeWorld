package easy;

public class RemoveLinkedListElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode head = GenerateEvenLL();
		ListNode newHead =  removeElements1(head, 1);

	}

	public static ListNode GenerateEvenLL()
	{
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(1);
		//		ListNode node4 = new ListNode(4);
		//
		//		ListNode node5 = new ListNode(4);
		//		ListNode node6 = new ListNode(3);
		//		ListNode node7 = new ListNode(2);
		//		ListNode node8 = new ListNode(1);

		node1.next = node2;
		node2.next = node3;
		//		node3.next = node4;
		//		node4.next = node5;
		//		node5.next = node6;
		//		node6.next = node7;
		//		node7.next = node8;

		return node1;
	}
	
	public static ListNode removeElements2(ListNode head, int val) 
	{
		/*if (head == null) return null;
        head.next = removeElements2(head.next, val);
        return head.val == val ? head.next : head;*/
		
		// Base case
		if(head == null)
            return null;
		
		// At first we are going till the end
        head.next = removeElements2(head.next, val);
        
        // If the value matches, we return the next node to the calling function
        if(head.val == val)
            return head.next;
        
        // If the value is different, we return the original head node to the calling function
        else
            return head;
	}
	
	public static ListNode removeElements3(ListNode head, int val) 
	{
		if (head == null) return null;
	    ListNode pointer = head;
	    while (pointer.next != null) 
	    {
	        if (pointer.next.val == val) 
	        	pointer.next = pointer.next.next;
	        
	        else 
	        	pointer = pointer.next;
	    }
	    return head.val == val ? head.next : head;
	}
	
	//public static ListNode removeElements4(ListNode head, int val) 
	{
		
	}

	public static ListNode removeElements1(ListNode head, int val) 
	{
		if(head == null) return null;

		ListNode prev = head;
		ListNode next = head.next;

		while(next != null)
		{
			if(next.val == val)
				prev.next = next.next;

			else
				prev = next;

			next = next.next;
		}

		// Since we are not explicitly checking the head, this is the check for head
		if((head.val == val)) head = head.next;

		return head;
	}

	public static void PrintLL(ListNode head)
	{
		while(head != null)
		{
			System.out.print(head.val + "->");
			head = head.next; 
		}
	}

}
