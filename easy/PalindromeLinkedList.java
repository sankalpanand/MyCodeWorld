package easy;


public class PalindromeLinkedList 
{

	public static void main(String[] args) 
	{
		ListNode head = GenerateEvenLL();
		System.out.println(isPalindrome(head));
	}

	public static boolean isPalindrome(ListNode head) 
    {
        if(head == null || head.next == null) 
            return true;
    
        ListNode slow = head;
        ListNode fast = head;
        
        // This while loop will continue till 3rd last node and
        // fast.next != null  => ODD cases
        // fast.next.next != null => Even cases
        while(fast.next != null && fast.next.next != null)
        {
        	slow = slow.next;
        	fast = fast.next.next;
        }
        
        // After coming out of this while loop, situation will be like
        // Even case:
        // 0 -- 0 -- 0 -- 0 (slow) -- 0 -- 0 -- 0 (fast) -- 0 -- null
        // slow.next will give us the starting node of the second half
        
        // Odd case:
        // 0 -- 0 -- 0 -- 0 (slow) -- 0 -- 0 -- 0 (fast) -- null
        // Slow.next will still give us the starting node of the second half
        
        slow.next = ReverseLinkedList(slow.next);
        
        // Move into the second half
        slow = slow.next;
        
        // Start comparing
        while(slow != null)
        {
        	if(head.val != slow.val)
        		return false;
        	head = head.next;
        	slow = slow.next;
        }
        
        return true;          
    }
	
	public static ListNode ReverseLinkedList(ListNode head)
	{
		ListNode pre = null;
		ListNode next = null;
		
		while(head != null)
		{
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		
		return pre;
	}
	
	public static ListNode GenerateEvenLL()
	{
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);

		ListNode node5 = new ListNode(4);
		ListNode node6 = new ListNode(3);
		ListNode node7 = new ListNode(2);
		ListNode node8 = new ListNode(1);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;
		
		return node1;
	}
	
	public static ListNode GenerateOddLL()
	{
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		
		ListNode node4 = new ListNode(4);

		
		ListNode node5 = new ListNode(3);
		ListNode node6 = new ListNode(2);
		ListNode node7 = new ListNode(1);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		
		
		return node1;
	}

}
