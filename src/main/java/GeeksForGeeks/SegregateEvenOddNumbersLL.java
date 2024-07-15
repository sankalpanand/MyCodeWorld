package GeeksForGeeks;

import Leetcode.Templates.Node;

public class SegregateEvenOddNumbersLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void SegregateEvenOdd(Node head) {
		Node end = head;
		Node prev = null;
		Node curr = head;
		
		/* Get pointer to the last node */
		while(end.next != null)
		{
			end = end.next;
		}
		
		Node newEnd = end;
		
		// Start from the beginning, if the node is odd, link it to the newEnd
		while(curr.val % 2 != 0 && curr != end)
		{
			// Point the last node's next pointer to this node
			newEnd.next = curr;
			
			// Move the current pointer to the next node for the next iteration
			curr = curr.next;
			
			// Break the link between curr and curr.next
			// ALSO, take this beginning node to the end
			newEnd.next.next = null;
			
			// Link has been established, update the newEnd. newEnd becomes the curr now. 
			newEnd = newEnd.next;
		}
		
		// After this while, all the ODD nodes are taken to the end.
		// If we have reached here, the curr points to the even node.
		if(curr.val %2 == 0)
		{
			/* Change the head pointer to point to first even node */
			head = curr;
			
			while(curr != end)
			{
				if(curr.val %2 == 0) // Case of even values
				{
					prev = curr;
					curr = curr.next;
				}
				else // Case of odd values
				{
					// Delete the link between previous even and current odd
					prev.next = curr.next; // curr odd gone !!
					
					// Make the next of the current as NULL
					curr.next = null; // curr next link gone !!
					
					// Move this ODD current to the end
					newEnd.next = curr;
					
					// Update the newEnd
					newEnd = curr;
					
					// Since we have to proceed forward, curr next link gone, so 
					curr = prev.next;
				}
			}
			
		}
		
		// If the above loop is not executed, then prev will still be null. We need to set it.
		else
		{
			prev = curr;
		}
		
		// Above loop broke when curr = end. So we haven't processed curr yet
		if(newEnd != end && end.val % 2 != 0)
		{
			prev.next = end.next;
			end.next = null; // This is going to be the last one, so make it's end as null
			newEnd.next = end;
			
		}
		return;		
	}

}
