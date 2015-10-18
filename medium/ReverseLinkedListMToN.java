package medium;

public class ReverseLinkedListMToN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*
    dummy->1->2->3->4->5->NULL
    
    m=2, n=4
    
    Target:
    dummy->1->4->3->2->5->NULL
    
    
    Step 1:
    dummy->1->3->2->4->5->NULL
    
    Step 2:
    dummy->1->4->3->2->5->NULL
    
    Algorithm:
    Take pre = last element which won't be affected. Here 1. We need this whenever we are bring last element of the window to the first.
    Start = first element from where this will start. Here m.
    Then = the last element in the window which is going to be head. So, start.next.
    
    Step 1: Delink the element which you want to move first. Here 4 in the first iteration.
    start.next = then.next
    dummy->1->2->4->5->NULL
    
    Step 2: Move this delinked node to the front of the window. Make it point to the first element in the window. Here 2.
    then.next = pre.next
    dummy->1->2->4->5->NULL
              ^
              |
              3
    
    Step 3: Delink start (2) from pre. And point it to the new hanging node (3).
    pre.next = then
    dummy->1->3->2->4->5->NULL
    
    Step 4: We are done with the first iteration. Move 'then'. (3rd node to 4th node)
    Pre remains the same as we need it when we bring another node from rear to front.
    Start also remains the same as it's next pointer was changed inside the loop in step 1.
    
    */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode pre = dummy;
        
        for(int i=0; i<m-1; i++)
        {
            pre = pre.next;
        }
        
        ListNode start = pre.next;
        ListNode then = start.next;
        
        for(int i=0; i<n-m; i++)
        {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }
        
        return dummy.next;
        
    }

}
