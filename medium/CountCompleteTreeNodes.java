package medium;

public class CountCompleteTreeNodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Log n * log n
    public int countNodes(TreeNode root) 
	{

        if(root == null) 
        	return 0;

        int hl=0, hr=0;

        TreeNode l=root, r=root;

        // Calculate left hight from root
        while(l != null) 
        {
            hl++; 
            l=l.left;
            
        }

        // Calculate right hight from root
        while(r != null) 
        {
            hr++; 
            r=r.right;
        }

        // 2^h - 1
        if(hl==hr) 
            return (1<<hl) -1;

        return 1 + countNodes(root.left) + countNodes(root.right);

    }
	
}
