package Leetcode.Medium;

import Leetcode.Templates.ListNode;
import Leetcode.Templates.TreeNode;

public class SortedLinkedListToBST2 {

	public static void main(String[] args) 
	{
		SortedLinkedListToBST2 obj = new SortedLinkedListToBST2();
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

	// http://www.geeksforgeeks.org/sorted-linked-list-to-balanced-bst/
	/**The idea is to follow inorder traversal. Go till the deepest level by halving the size at each level. 
	 * When the size is reduced to zero, then consume the first node and retract by moving the LL head pointer.
	 * Since it will match inorder traversal, create root now.
	 * Now that the root is created, form a RST and attach it to the root.
	 *  */ 
	ListNode head;
    public TreeNode sortedListToBST(ListNode head)
    {
        int size = Count(head);
        this.head = head;
        System.out.println(size);
        return helper(size);
    }
    
    // Visualization: For every half length of the array, it will go one level down
    // Suppose size = 11. Then leftSubTree will receive 11/2=5 => 5/2 = 2 => 2/2=1 => 1/2=0. It will give leftSubTree = null when size remain just 1.
    // Then rooot node will be created with 1 as data.
    public TreeNode helper(int size)
    {
        // Base case
        if(size <= 0)
            return null;
        
        // Construct LST
        TreeNode leftSubTree = helper(size/2);
        
        // Create a node from the root and attach the LST to this node
        // Question: Why we can not create root before invoking LST?
        // Because, MyNode 1 will be created in the very first recursive call at the root level. We want it to be created at the leaf levels.
        TreeNode root = new TreeNode(head.val);
        root.left = leftSubTree;
        
        // Since this value is taken up by the LST, move to the next.
        head = head.next;
        
        // Recursively create a Right sub tree
        // - size/2 because size/2 has already been created earlier
        // -1 because 1 will be consumed by root
        TreeNode rightSubTree = helper(size - (size/2) - 1);
        root.right = rightSubTree;
        
        return root;
    }
    
    
    public static int Count(ListNode head)
    {
        if(head == null) return 0;
        return 1 + Count(head.next);
    }
	

}
