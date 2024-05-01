package Leetcode.Medium;

import Leetcode.Templates.ListNode;

public class SortLinkedList {

	public static void main(String[] args) 
	{
	    int[] nums = {6, 38, 25, 46, 45, 90, 97, 52, 75, 18};
		ListNode head = new ListNode(nums[0]);

		for(int i=1; i<nums.length; i++) {
            head.AddToTail(nums[i]);
        }

        SortLinkedList obj = new SortLinkedList();
        obj.sortList3(head);
	}

	/* The idea is to find out the head and the mid of the Linked List.
	 * Then you de-link the two. 
	 * Send them to merge list function.
	 * You can recurse on each of the smaller lists. */
	public ListNode sortList(ListNode head)
	{
		if (head == null || head.next == null)
			return head;
		
		ListNode fast = head.next.next;
		ListNode slow = head;
		
		while (fast != null && fast.next != null) 
		{
			slow = slow.next;
			fast =  fast.next.next;
		} // Slow.next gives you the head of the second half
		
		// 2- mergeSort second half
		ListNode h2 = sortList(slow.next);
		
		// 3- Delink the lists
		slow.next = null;
		
		// 4- mergeSort first half
		ListNode h1 = sortList(head);
		 
		// 5- Merge the two sorted lists
		return merge(h1, h2);
	}

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode tail = head;

        while(l1 != null && l2 != null)
        {
            if(l1.val <= l2.val)
            {
                tail.next = l1;
                l1 = l1.next;
            }
            else
            {
                tail.next = l2;
                l2 = l2.next;
            }

            tail = tail.next;
        }

        // By the time you'll reach here, one pointer would've reached null. So you need to link the rest of the other list.
        tail.next = l1 != null ? l1 : l2;
        return head.next;
    }


    // https://leetcode.com/problems/sort-list/discuss/46712/Bottom-to-up(not-recurring)-with-o(1)-space-complextity-and-o(nlgn)-time-complextity
    // Merging using bottoms up approach
    // Video explanation here - https://youtu.be/6pV2IF0fgKY?t=643
    public ListNode sortList3(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int n = 0;

        while (head != null) {
            head = head.next;
            n++;
        }

        for (int step = 1; step < n; step = step * 2) {
            ListNode prev = dummy;
            ListNode cur = dummy.next;

            while (cur != null) {
                ListNode left = cur;
                ListNode right = split(left, step);
                cur = split(right, step); // Curr tracks the start in the next iteration

                // Left and right have been de-linked. Now merge them in sorted order.
                // We need to send down prev so that the merged linked list is linked to previous
                // Previous is the last node of the sorted section, so update it too.
                prev = merge(left, right, prev);
            }
        }

        return dummy.next;
    }

    // This method splits the section from the next one and returns the head of the next section
    private ListNode split(ListNode head, int step) {
        if (head == null)
            return null;

        // For a section of length n, you only need to move the pointer n-1 times
        for (int i = 1; head.next != null && i < step; i++) {
            head = head.next;
        }

        ListNode right = head.next;
        head.next = null;
        return right;
    }

    private ListNode merge(ListNode left, ListNode right, ListNode prev) {
        ListNode cur = prev;

        while (left != null && right != null)
        {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            }
            else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }

        if (left != null)
            cur.next = left;
        else if (right != null)
            cur.next = right;

        // Merge function always return the address of the last node after sorting that section
        while (cur.next != null)
            cur = cur.next;

        return cur;
    }



}
