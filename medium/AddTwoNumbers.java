package medium;

class ListNode 
{
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

public class AddTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(5);
		ListNode l2 = new ListNode(5);
		ListNode res = addTwoNumbers(l1, l2);
		System.out.println(res.val);

	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1 == null) return l2;
		else if(l2 == null) return l1;

		ListNode previous = new ListNode(0);
		ListNode dummy = previous;

		int carry = 0, count = 0;

		while(l1 != null || l2 != null || carry != 0)
		{
			ListNode curr = new ListNode(0);
			
			int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
			curr.val = sum % 10;
			carry = sum/10;
			
			previous.next = curr;
			previous = curr;

			// I had a question that if I am checking l1 and l2 being null above then why do I need to check again?
			// If I dont check it here, l1.next will throw exception when l1 is already null
			l1 = l1 == null? l1 : l1.next;
			l2 = l2 == null? l2 : l2.next;			
		}
		return dummy.next;
	}

}
