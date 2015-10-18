package easy;

import java.util.Stack;

public class PalindromeLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = GenerateEvenLL();

		System.out.println(isPalindrome(head));


	}

	public static boolean isPalindrome(ListNode head) {

		// Get length
		ListNode temp = head;
		int length = 0;
		while(temp != null)
		{
			length++;
			temp = temp.next;
		}
		
		// System.out.println(length);
		
		if(length == 0)
			return true;
		
		if(length == 1)
			return true;
		

		int index = 1;
		int mid = length/2;

		temp = head;
		Stack<Integer> stack = new Stack<Integer>();


		boolean result = true;
		while(index <= length)
		{
			if(index <= mid)
			{
				stack.push(temp.val);
			}

			if(index > mid)
			{
				int element = stack.pop();
				if(element != temp.val)
				{
					return false;
				}
			}
			
			if(index == mid && length % 2 != 0)
			{
				temp = temp.next.next;
				index = index +2;
			}
			else
			{
				temp = temp.next;
				index++;
			}
			
			
			
		}

		return result;
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
