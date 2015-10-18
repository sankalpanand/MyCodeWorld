package easy;

public class RemoveDuplicatesFromSortedLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// My accepted solution
	public ListNode deleteDuplicates(ListNode head) {

		if(head == null) return null;

		ListNode back = head;
		ListNode front = head.next;

		while(front != null)
		{
			if(front.val == back.val)
			{
				back.next = front.next;
			}
			else
			{
				back = back.next;
			}

			front = front.next;
		}

		return head;
	}

	// Recursive solution
	public ListNode deleteDuplicatesR1(ListNode head) {
		if(head == null || head.next == null)return head;
		head.next = deleteDuplicates(head.next);
		return head.val == head.next.val ? head.next : head;
	}

	// Recursive solution
	public ListNode deleteDuplicatesR2(ListNode head) {
		if(head == null)
			return null;
		
		if(head.next != null && head.next.val == head.val) 
		{
			head.next = head.next.next;
			head = deleteDuplicates(head);
		}
		else
			head.next = deleteDuplicates(head.next);

		return head;

	}

	// 1 Pointer solution
	public ListNode deleteDuplicates2(ListNode head) {
		if(head == null || head.next == null) return head;

		ListNode list = head;
		while(list.next != null) 
		{
			if (list.val == list.next.val)
				list.next = list.next.next;
			else 
				list = list.next;
		}

		return head;
	}

}
