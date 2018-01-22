package LeetcodeMedium;

public class SwapNodesInPairs {

	public static void main(String[] args) 
	{
		ListNode head = new ListNode(1);
		head.AddToTail(2);
		head.AddToTail(3);
		head.AddToTail(4);
		head.AddToTail(5);
		head.AddToTail(6);
		
		System.out.println(head.toString());
		
		swapPairs1(head);
	}
	
	// Given 1->2->3->4, you should return the list as 2->1->4->3.
	// My solution - iterative. Draw it on paper.
    public static ListNode swapPairs1(ListNode head) 
    {
        if(head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head.next;
        
        ListNode curr = head;
        ListNode prev = dummy;
        
        while(curr != null && curr.next != null)
        {
        	// 1- Store the next node
            ListNode next = curr.next;
            
            // 2- Connect current to the next to next
            curr.next = curr.next.next;
            
            // 3- Connect the next with the current in the reverse direction
            next.next = curr;
            
            // 4- Connect previous with next (not the current one)
            prev.next = next;
            
            // 5- Update the pointers for the next round
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
