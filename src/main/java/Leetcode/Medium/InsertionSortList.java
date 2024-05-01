package Leetcode.Medium;

import Leetcode.Templates.ListNode;

public class InsertionSortList {

	public static void main(String[] args) {
		int[] nums = {6, 5, 3, 1, 8, 7, 2, 4};
		ListNode head = new ListNode(nums[0]);

        for(int i=1; i<nums.length; i++) {
            head.AddToTail(nums[i]);
        }

        InsertionSortList obj = new InsertionSortList();

		ListNode sortedList = obj.insertionSortList(head);

        System.out.println();

	}
	
	// https://leetcode.com/problems/insertion-sort-list/discuss/46420/An-easy-and-clear-way-to-sort-(-O(1)-space-)
	// Do it on paper. 
	// In every iteration, we move the pre pointer further in the array 
	// until we reach the point where current becomes smaller than the pre.next
	// It would mean, that we should insert our curr between pre and pre.next	
	public ListNode insertionSortList(ListNode head)
	{
		if( head == null )
		{
			return head;
		}

		ListNode helper = new ListNode(0); // new starter of the sorted list
		
		ListNode pre = helper; //insert node between pre and pre.next
		ListNode cur = head; // the node will be inserted		
		ListNode next = null; //the next node will be inserted
		
		// not the end of input list
		while( cur != null )
		{
			// Pick the next element, then we'll think about where to insert it.
			next = cur.next;
			
			// find the right place to insert
			while( pre.next != null && pre.next.val < cur.val )
			{
				pre = pre.next;
			}
			
			// Insert between pre and pre.next
			cur.next = pre.next;
			pre.next = cur;
			
			// Insertion over, reset pre. Take it back to the helper.
			pre = helper;
			
			// Move to the next node
			cur = next;
		}

		return helper.next;
	}

}
