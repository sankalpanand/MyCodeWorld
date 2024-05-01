package Leetcode.Hard;

public class PopulatingNextRightPointers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// https://leetcode.com/discuss/7327/a-simple-accepted-solution
	// Sketch a tree, solve it on paper to understand. Very easy approach.
	public void connect1(TreeLinkNode root) 
    {
        if(root == null) 
            return;
            
        TreeLinkNode pre = root;
        TreeLinkNode curr;
        
        // Go as far left as possible as long as there is a left child
        // This loop traverses vertically
        while(pre.left != null)
        {
            curr = pre;
            
            // This loop traverses horizontally
            while(curr != null)
            {
                curr.left.next = curr.right;
                if(curr.next != null)
                    curr.right.next = curr.next.left;
                
                curr = curr.next;
            }
            
            // Since curr has gone to extreme right, 
            // we need a way to stay at extreme left so that we can go one level down
            pre = pre.left;
        }
    }
    
    // Recursive
    public void connect(TreeLinkNode root) 
    {
        if(root == null || root.left == null) 
            return;
        
        connectNodes(root.left, root.right);
    }

    public void connectNodes(TreeLinkNode node1, TreeLinkNode node2) 
    {
        // Connect the siblings
        node1.next = node2;
        
        if(node1.left != null)
        {
            connectNodes(node1.left, node1.right);
            connectNodes(node2.left, node2.right);
            connectNodes(node1.right, node2.left);
        }
    } 

}
