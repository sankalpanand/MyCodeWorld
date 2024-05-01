package Leetcode.Easy;

import Leetcode.Templates.ListNode;

public class ReverseLinkedList {
	public static ListNode newHead;
	

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

	// Iterative solution - https://www.youtube.com/watch?v=sYcOK51hl-A
	public static ListNode reverseList(ListNode head)
	{
		ListNode pre = null;
		ListNode next = null;
		
		while(head != null)
		{
			// Store next somewhere before you delink it
			next = head.next;

			// Make the current's next to previous node
			head.next = pre;

			// Move up previous node
			pre = head;

			// Move up current node
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

	// Recursion - Without global variable
	// Pichhe wala bhi second argument mein bhejo jis se ki link kiya ja sake
	// Next wala to already mil hi jayega
	public static  ListNode helper(ListNode head, ListNode newNext)
	{
		if(head.next == null)
		{
			head.next = newNext;
			return head;
		}

		// Store next first before it gets delinked
		ListNode next = head.next;

		// Establish next link for current node
		head.next = newNext;

		// Move on to the next node
		return helper(next, head);
	}

	// Recursion - With global variable
	// This will require a global head to store the end of list
	public static  ListNode helper(ListNode head)
	{
		// Exit condition
		if(head.next == null)
		{
			// Store the global head
			newHead = head;
			return head;
		}

		// innerNode ek tarah se next node hi hai, jo recursion se nikal ke aayegi
		ListNode innerNode = helper(head.next);

		// Inner node / Next node ka next current node ko bana do
		innerNode.next = head;

		// Next wala reverse link establish ho chuka hai, forward link break kar do
		head.next = null;

		return head;
	}
}

