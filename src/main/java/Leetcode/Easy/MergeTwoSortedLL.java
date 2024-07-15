package Leetcode.Easy;

import Leetcode.Templates.ListNode;

public class MergeTwoSortedLL {

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		n1.addNode(2);
        n1.addNode(4);

        ListNode n2 = new ListNode(1);
        n2.addNode(3);
        n2.addNode(4);

        MergeTwoSortedLL obj = new MergeTwoSortedLL();

//        n1.printLinkedList();
//        n2.printLinkedList();

        ListNode head = obj.mergeTwoLists(n1, n2);
        head.printLinkedList();

	}

	// Same logic but more elegant solution
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode tail = head;

		while(l1 != null && l2 != null) {
		    if(l1.val <= l2.val) {
		        tail.next = l1;
		        l1 = l1.next;
		    }
		    else {
		        tail.next = l2;
		        l2 = l2.next;
		    }

		    // It's important because we want to move on to the next node and form a link there for the next round
			tail = tail.next;
		}

		// By the time you'll reach here, one pointer would've reached null. So you need to link the rest of the other list.
		tail.next = l1 != null ? l1 : l2;
		return head.next;
	}

	// Recursive
	public ListNode mergeTwoListsR(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;

        if(l2 == null)
            return l1;

        ListNode mergeHead;

        // This if-else will determine which element will come at head
        if(l1.val < l2.val)
        {
            mergeHead = l1;
            mergeHead.next = mergeTwoListsR(l1.next, l2);
        }
        else
        {
            mergeHead = l2;
            mergeHead.next = mergeTwoListsR(l1, l2.next);
        }

        return mergeHead;
    }

}
