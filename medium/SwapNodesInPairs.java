package medium;

public class SwapNodesInPairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// Given 1->2->3->4, you should return the list as 2->1->4->3.
	// My solution - iterative. Draw it on paper.
    public ListNode swapPairs1(ListNode head) 
    {
        if(head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head.next;
        
        ListNode curr = head;
        ListNode prev = dummy;
        
        while(curr != null && curr.next != null)
        {
            ListNode next = curr.next;
            curr.next = curr.next.next;
            next.next = curr;
            prev.next = next;
            prev = curr;
            curr = curr.next;
        }
        
        return dummy.next;
    }
    
    // Recursive
    // 1 -> 2 -> 3 -> 4
    // 1 -> SWAP(3)
    // 2 -> 1 -> SWAP(3)
    // 2 -> 1 -> 4 -> 3
    public ListNode swapPairs(ListNode head) 
    {
        if (head == null || head.next == null) 
        {
            return head;
        }
        
        ListNode first = head;
        ListNode next = head.next;
        first.next = swapPairs(next.next);
        next.next = first;
        return next;
    }

}
