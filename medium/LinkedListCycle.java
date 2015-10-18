package medium;

public class LinkedListCycle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && slow != null)
        {
            if(slow.next == null) return false;
            else slow = slow.next;
            
            if(fast.next == null || fast.next.next == null) return false;
            else fast = fast.next.next;
            
            if(slow == fast) return true;
        }
        return false;
    }

}
