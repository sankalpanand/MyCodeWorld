package Leetcode.Medium;

import Leetcode.Templates.ListNode;
import Leetcode.Templates.TreeNode;

public class Q109SortedLinkedListToBST2 {

	public static void main(String[] args) 
	{
		Q109SortedLinkedListToBST2 obj = new Q109SortedLinkedListToBST2();
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
		
		TreeNode res = obj.sortedListToBST(headN);
		System.out.println(headN);
		
		TreeNode.printNode(res);
	}

	// The time complexity of the solution is O(n logn) since you have to traverse the sub-list in each recursive call.
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;

        if (head.next == null)
            return new TreeNode(head.val);

        ListNode fast = head, slow = head, pre = null;

        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // We need to cut the left sub tree here so that the recursive call will have an end point to stop while trying to find mid
        pre.next = null;

        // By now the slow pointer would've been at mid
        TreeNode n = new TreeNode(slow.val);
        n.left = sortedListToBST(head);
        n.right = sortedListToBST(slow.next);

        return n;
    }
}
