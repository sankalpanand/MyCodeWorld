package easy;

public class MaximumDepthOfBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int maxDepth(TreeNode root) {
        // Base case when a leaf node is reached
        if(root == null) return 0;
        
        // Too avoid considering a node with a single child as a leaf node
        else if(root.left == null) return 1 + maxDepth(root.right); 
        else if(root.right == null) return 1 + maxDepth(root.left);
        
        // For a normal node with both the children
        else return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

}
