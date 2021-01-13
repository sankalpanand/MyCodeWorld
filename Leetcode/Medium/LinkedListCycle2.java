package Leetcode.Medium;

import Leetcode.Templates.ListNode;

public class LinkedListCycle2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast!=null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;

            // If cycle is detected, then start a new runner from head
            if (fast == slow) {
                ListNode slow2 = head;

                while (slow2 != slow){
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }
        return null;
    }
	


}
