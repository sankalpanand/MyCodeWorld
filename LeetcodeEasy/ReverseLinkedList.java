package LeetcodeEasy;

public class ReverseLinkedList {
	public static  ListNode newHead;
	

	public static void main(String[] args) 
	{
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(7);
		ListNode node3 = new ListNode(5);
		ListNode node4 = new ListNode(1);
		ListNode node5 = new ListNode(9);
		ListNode node6 = new ListNode(3);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;

		ListNode newHead = reverseList(node1);

		System.out.println(newHead.val);


	}
	
	public static ListNode reverseList(ListNode head)
	{
		ListNode pre = null;
		ListNode next = null;
		
		while(head != null)
		{
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		
		return pre;
	}


	public static  ListNode reverseList2(ListNode head) {
		if(head == null)
			return null;

		// helper(head);
		ListNode newHead = helper(head, null);
		return newHead;
	}

	public static  ListNode helper(ListNode head)
	{
		if(head.next == null)
		{
			newHead = head;
			return head;
		}

		ListNode innerNode = helper(head.next);
		innerNode.next = head;
		head.next = null;
		return head;

	}

	public static  ListNode helper(ListNode head, ListNode newNext)
	{
		if(head.next == null)
		{
			head.next = newNext;
			return head;
		}
		
		ListNode next = head.next;
		head.next = newNext;
		return helper(next, head);
	}
}

