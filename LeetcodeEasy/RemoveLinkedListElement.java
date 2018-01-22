package LeetcodeEasy;

public class RemoveLinkedListElement 
{
	// Iterative- Start with the head and the next node. Keep moving until next is not null. Remove elements.
	public static ListNode removeElements(ListNode head, int val) 
    {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode pre = dummy;
        ListNode next = head;
        
        while(next != null)
        {
            if(next.val == val) 
                pre.next = next.next;
            else
                pre = pre.next;
                
            next = next.next;            
        }
        
        return dummy.next;
    }

	// Recursive solution
	public static ListNode removeElementsR(ListNode head, int val) 
	{
		/*if (head == null) return null;
	        head.next = removeElements2(head.next, val);
	        return head.val == val ? head.next : head;*/

		// Base case
		if(head == null)
			return null;

		// At first we are going till the end
		head.next = removeElementsR(head.next, val);

		// If the value matches, we return the next node to the calling function
		if(head.val == val)
			return head.next;

		// If the value is different, we return the original head node to the calling function
		else
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode head = GenerateEvenLL();
		ListNode newHead =  removeElements(head, 1);

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

}
