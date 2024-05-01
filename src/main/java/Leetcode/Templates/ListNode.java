package Leetcode.Templates;

public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int x) {
		val = x;
	}

	public void addNode(int val) {

	    ListNode nodeToAdd = new ListNode(val);

	    ListNode curr = this;

	    while(curr.next != null) {
	        curr = curr.next;
        }

        curr.next = nodeToAdd;
    }

    public void printLinkedList() {
        ListNode curr = this;

        System.out.print(curr.val + " -> ");

        while(curr.next != null) {
            curr = curr.next;
            System.out.print(curr.val + " -> ");
        }

        System.out.println();
    }

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
