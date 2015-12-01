package medium;


public class ListNode 
{
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
	
	
	public void AddToTail(int val)
	{
		if(next == null)
			next = new ListNode(val);
		else
			next.AddToTail(val);
	}
	
	public String toString()
	{
		if(next == null)
			return val+"";
			
		return val + " -> " + next.toString();
	}
}