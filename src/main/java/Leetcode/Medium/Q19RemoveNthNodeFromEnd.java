package Leetcode.Medium;

import Leetcode.Templates.ListNode;

public class Q19RemoveNthNodeFromEnd {

	public static void main(String[] args) {
		Q19RemoveNthNodeFromEnd obj = new Q19RemoveNthNodeFromEnd();

		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		ListNode n7 = new ListNode(7);
		ListNode n8 = new ListNode(8);
		ListNode n9 = new ListNode(9);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n9;

		ListNode removed = obj.removeNthFromEnd(n1, 3);

	}
	
	// My accepted solution.
	// I took 2 pointers, fast and slow.
	// I moved fast pointer for n steps.
	// I then moved both the pointers after n steps together.
	// All the times, slow pointer was behind fast pointer by 3 steps.
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode left = dummy;
		ListNode right = head;

		while (n > 0) {
			right = right.next;
			n--;
		}

		while (right != null) {
			left = left.next;
			right = right.next;
		}

		left.next = left.next.next;
		return dummy.next;
	}

}
