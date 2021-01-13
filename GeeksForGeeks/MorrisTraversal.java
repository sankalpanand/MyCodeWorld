
public class MorrisTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// http://stackoverflow.com/questions/5502916/explain-morris-inorder-tree-traversal-without-using-stacks-or-recursion
	// http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/
	public static void InOrder(TreeNode root)
	{
		TreeNode current, pre;
		if(root == null)
			return;
		
		current = root;
		
		while(current != null)
		{
			if(current.left == null)
			{
				System.out.println(current.val);
				current = current.right;
			}
			else // There is a left child
			{
				pre = current.left;
				
				// LST mein right jaate jaao...
				while(pre.right != null && pre.right != current)
				{
					pre = pre.right;
				} // By this point, pre has become the rightmost node of RST
				
				/* Yahan tak pre ka right null hi hoga because wo leaf node hai 
				 * which is ideally the predecessor of root. Ab, uska right wapas upar root ko point kar do.
				 * As per the algo, take a step towards left. 
				 * See stackoverflow link */
				if(pre.right == null)
				{
					pre.right = current;
					
					// Move the current to left
					current = current.left;
				}
				
				// MAGIC OF RESTORING the Tree happens here: 
				/* Yahan par right most node ka right null nahi hai... 
				 * iska matlab last time hum isko already root ko point kara chuke hain...
				 * Link tod do...
				 * If we have reached the right most node of the LST and 
				 * it happens to be the one which we previously pointed to the root then
				 * break the link to revert back to original by making it's right pointer null */
				else
				{
					pre.right = null;
					System.out.println(current.val);
					current = current.right;
				}
			}
		}
		
	}

}
