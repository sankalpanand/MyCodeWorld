package medium;

public class SortedLinkedListToBST2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println();
	}

	// http://www.geeksforgeeks.org/sorted-linked-list-to-balanced-bst/
    ListNode head;
    
    public TreeNode sortedListToBST(ListNode head) {
        
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
        // Because, Node 1 will be created in the very first recursive call at the root level. We want it to be created at the leaf levels.
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
