package easy;

public class MergeTwoSortedLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		if(l1 == null && l2 == null) return null;
		if(l1 == null) return l2;
		else if(l2 == null) return l1;

		ListNode head = null;
		
		// You can remove this initial head fetch by using a dummy node. See second solution below.
		if(l1.val > l2.val)
		{
			head = l2;
			l2 = l2.next;
		}

		else if(l1.val <= l2.val)
		{
			head = l1;
			l1 = l1.next;
		}

		ListNode temp = head;
		while(l1 != null || l2 != null)
		{
			if(l1 == null) { head.next = l2; break; }
			else if(l2 == null) { head.next = l1; break; }

			else if(l1.val > l2.val)
			{
				head.next = l2;
				head = head.next;
				l2 = l2.next;
			}

			else if(l1.val < l2.val)
			{
				head.next = l1;
				head = head.next;
				l1 = l1.next;
			}
			else
			{
				head.next = l2;
				l2 = l2.next;
				head = head.next;
				head.next = l1;
				l1 = l1.next;
				head = head.next;
			}
		}

		return temp;
	}

	// Same logic but more elegant solution
	public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
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
		tail.next = l1 != null ? l1 : l2;
		return head.next;

	}
	
	public ListNode mergeTwoListsR(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode mergeHead;
        if(l1.val < l2.val){
            mergeHead = l1;
            mergeHead.next = mergeTwoLists(l1.next, l2);
        }
        else{
            mergeHead = l2;
            mergeHead.next = mergeTwoLists(l1, l2.next);
        }
        return mergeHead;
    }

}
