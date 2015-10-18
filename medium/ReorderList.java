package medium;

public class ReorderList {

	// https://leetcode.com/discuss/35599/java-solution-with-3-steps
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		
		reorderList(node1);

	}
	
	// https://leetcode.com/discuss/35599/java-solution-with-3-steps
	public static void reorderList(ListNode head) 
	{
        if(head==null||head.next==null) 
        	return;

        //Find the middle of the list
        ListNode p1=head;
        ListNode p2=head;
        while(p2.next!=null&&p2.next.next!=null)
        { 
            p1=p1.next;
            p2=p2.next.next;
        }

        //Reverse the half after middle  1->2->3->4->5->6 to 1->2->3->6->5->4
        ListNode preMiddle=p1;
        ListNode preCurrent=p1.next;
        while(preCurrent.next!=null)
        {
            ListNode current = preCurrent.next;
            preCurrent.next=current.next;
            current.next=preMiddle.next;
            preMiddle.next=current;
        }

        //Start reorder one by one  1->2->3->6->5->4 to 1->6->2->5->3->4
        p1=head;
        p2=preMiddle.next; // Just one before mid
        while(p1!=preMiddle)
        {
            preMiddle.next=p2.next; 
            p2.next=p1.next;		
            p1.next=p2;				
            p1=p2.next;				
            p2=preMiddle.next;
        }
    }

}
