package Leetcode.Medium;

import Leetcode.Templates.ListNode;

public class Q143ReorderList {

	// Leetcode - https://leetcode.com/problems/reorder-list/
    // Neetcode - https://www.youtube.com/watch?v=S5bfdUTrKLM
	public static void main(String[] args) {
        Q143ReorderList obj = new Q143ReorderList();

		ListNode headN = new ListNode(1);
		headN.AddToTail(2);
		headN.AddToTail(3);
		headN.AddToTail(4);
		headN.AddToTail(5);
		headN.AddToTail(6);
		headN.AddToTail(7);
		headN.AddToTail(8);
		headN.AddToTail(9);
		headN.AddToTail(10);
		headN.AddToTail(11);
		
		System.out.println(headN);
		obj.reorderList(headN);
		System.out.println(headN);

	}

    public void reorderList(ListNode head) {
        if (head == null) return;

        // Step 1: Find the middle of the linked list
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the list
        ListNode second = slow.next;
        slow.next = null;
        ListNode prev = null;
        while (second != null) {
            ListNode tmp = second.next;
            second.next = prev;
            prev = second;
            second = tmp;
        }

        // Step 3: Merge the two halves
        ListNode first = head;
        second = prev;
        while (second != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;
            first.next = second;
            second.next = tmp1;
            first = tmp1;
            second = tmp2;
        }
    }

}
