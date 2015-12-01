package medium;

public class ReverseLinkedListMToN {

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
		
		reverseBetween(headN, 4, 8);

	}
	
    
    public static ListNode reverseBetween(ListNode head, int m, int n) 
    {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // First, reach till m'th node. You need two pointers from this loop - pre (m-1) and curr (m)'th node  
        ListNode cur1 = dummy;
        ListNode pre1 = null;
        for(int i=0;i<m;i++)
        {
            pre1 = cur1;
            cur1 = cur1.next;
        } // After this loop, curr has reached m'th node and pre is at (m-1)'th node 

        // Reverse
        ListNode cur2 = cur1;
        ListNode pre2 = pre1;
        ListNode nextNode;
        
        
        /* It's a standard 4 step link reversal process. Start with 3 pointers- pre, curr, next-
         * 1- Store next link
         * 2- Since next is stored separately, break next and face it backwards 
         * 3&4- Update pre and curr
        */
        for(int i=m;i<=n;i++)
        {
        	nextNode = cur2.next;
            cur2.next = pre2;
            pre2 = cur2;
            cur2 = nextNode;
        }

        /* At the end of the for loop, you need to do 2 thigs- Establish links of the reversed LL
         * 1- Connect (m-1)'th element to n'th element
         * 2- Connect m'th element to (n+1)'th element
        */
        pre1.next = pre2;
        cur1.next = cur2;

        return dummy.next;
    }

}
