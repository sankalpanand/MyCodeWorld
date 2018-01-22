package LeetcodeMedium;

public class ReorderList {

	// https://leetcode.com/discuss/35599/java-solution-with-3-steps
	public static void main(String[] args) {
		ListNode headN = new ListNode(1);
		headN.AddToTail(2);
		headN.AddToTail(3);
		headN.AddToTail(4);
		headN.AddToTail(5);
		headN.AddToTail(6);
		headN.AddToTail(7);
		headN.AddToTail(8);
		headN.AddToTail(9);
		headN.AddToTail(10);
		headN.AddToTail(11);
		
		System.out.println(headN);
		reorderList(headN);
		System.out.println(headN);

	}
	
	// https://leetcode.com/discuss/35599/java-solution-with-3-steps
	/* 1- Reverse the second half
	 * 2- Take two heads - one in first half and second in second half
	 * 3- Try to add head2 as head1.next 
	 * 
	 * */
	public static void reorderList(ListNode head) 
	{
        if(head==null||head.next==null) 
        	return;

        //Find the middle of the list
        ListNode headFirstHalf = head;
        ListNode headSecondHalf=head;
        while(headSecondHalf.next!=null&&headSecondHalf.next.next!=null)
        { 
            headFirstHalf=headFirstHalf.next;
            headSecondHalf=headSecondHalf.next.next;
        }

        //Reverse the half after middle  1->2->3->4->5->6 to 1->2->3->6->5->4
        ListNode preMiddle=headFirstHalf;
        ListNode preCurrent=headFirstHalf.next;
        while(preCurrent.next!=null)
        {
            ListNode current = preCurrent.next;
            preCurrent.next=current.next;
            current.next=preMiddle.next;
            preMiddle.next=current;
        }

        System.out.println(head);
        //Start reorder one by one  1->2->3->6->5->4 to 1->6->2->5->3->4
        headFirstHalf=head;
        headSecondHalf=preMiddle.next; // Just one before mid
        
        // preMiddle always holds the same value, but it's next pointer moves in the second half
        // It gives you the node which has to be appended at the front
        while(headFirstHalf!=preMiddle)
        {
        	// Break the head2 from the list
            preMiddle.next=headSecondHalf.next; 
            
            // This inserts element in the second half between the first half
            headSecondHalf.next=headFirstHalf.next;		
            
            // This joins first half to the second half
            headFirstHalf.next=headSecondHalf;
            
            // Update headFirstHalf two steps ahead
            headFirstHalf=headSecondHalf.next;
            
            // Update headSecondHalf
            headSecondHalf = preMiddle.next;
            
            System.out.println(head);
        }
    }

}
