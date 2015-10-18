package medium;

import java.util.List;


public class SumRootToLeafNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println();
	}

	public long totalSum = 0;

	public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
          
        // Do not send anything from here. Since root is not null, every node will append its ownn value.
        helper(root, "");
        return (int) totalSum;
    }
    
    public void helper(TreeNode root, String path)
    {
    	// To avoid all troubles, update the path in the beginning itself.
        // If recursive call have reached here, there is definitely some value in the root.
        path = path + root.val;
        
        if(root.left == null && root.right == null)        
            totalSum = totalSum + Long.parseLong(path);
        if(root.left != null) helper(root.left, path);
        if(root.right != null) helper(root.right, path);
    }

}
