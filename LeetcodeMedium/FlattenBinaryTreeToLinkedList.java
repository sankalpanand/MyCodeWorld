package LeetcodeMedium;

public class FlattenBinaryTreeToLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
TreeNode prev = null;
    
    
    // The idea is to Attach the RST of the root as a right child of the right most node in the LST
    public void flatten(TreeNode root) 
    {
        if(root == null) return;
        if(root.left == null && root.right == null) return;
        
        while(root != null)
        {
            TreeNode left = root.left;
            TreeNode right = root.right;
            
            // If I dont write this block, it will throw exception in [1, null, 2]
            if (root.left == null) 
            {
                root = root.right;
                continue;
            }
            
            // Go towards rightmost child in the LST
            while(left.right != null)
                left = left.right;
            
            // Sequence does matter. Do left nulling in the end
            
            // MakeAttach the right child of the root to right most node in the LST
            left.right = right;
            
            // shift LST to RST
            root.right = root.left;
            
            // Make LST = null
            root.left = null;
            
            // Proceed one step for the next iteration
            root = root.right;
        }
    }
    // This solution will start printing from the extreme right child
    public void flatten1(TreeNode root) 
    {
        // Base case
        if(root == null) 
            return;
        
        // Go towards right as long there is
        flatten(root.right);
        
        // Go towards left as long there is
        flatten(root.left);
        
        // Make the right child as the extreme right node
        root.right = prev;
        
        // Make the left child as null as there will be none
        root.left = null;
        
        // Store the current as the root for the upper level in recursion 
        prev = root;
        
    }
}
