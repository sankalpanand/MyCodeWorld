package medium;

import java.util.LinkedList;
import java.util.List;

public class UniqueBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numTrees(5));
	}
	
	// https://leetcode.com/discuss/24282/dp-solution-in-6-lines-with-explanation-f-i-n-g-i-1-g-n-i
    // G(n) = G(0) * G(n-1) + G(1) * G(n-2) + … + G(n-1) * G(0)
	// F(3,7) = G(2) * G(4)
	/*
	 	G[0]*G[1]	G[1]*G[0]	
		G[0]*G[2]	G[1]*G[1]	G[2]*G[0]	
		G[0]*G[3]	G[1]*G[2]	G[2]*G[1]	G[3]*G[0]	
		G[0]*G[4]	G[1]*G[3]	G[2]*G[2]	G[3]*G[1]	G[4]*G[0]	
		
	 * */
    public static int numTrees(int n) 
    {
        int [] G = new int[n+1];
        G[0] = G[1] = 1;
    
        for(int i=2; i<=n; ++i) 
        {
            for(int j=1; j<=i; ++j) 
            {
            	System.out.print("G[" + (j-1) + "]" + "*" + "G[" + (i-j) + "]\t");
                G[i] = G[i] + G[j-1] * G[i-j];
            }
            System.out.println();
        }
    
        return G[n];
    }

	public List<TreeNode> generateTrees(int n) 
	{
	    return generateSubtrees(1, n);
	}
	
	private List<TreeNode> generateSubtrees(int start, int end) 
	{
	    List<TreeNode> res = new LinkedList<TreeNode>();
	    if (start > end) 
	    {
	        res.add(null); // empty tree
	        return res;
	    }
	
	    for (int i = start; i <= end; ++i) 
	    {
	        List<TreeNode> leftSubtrees = generateSubtrees(start, i - 1);
	        List<TreeNode> rightSubtrees = generateSubtrees(i + 1, end);
	
	        for (TreeNode left : leftSubtrees) 
	        {
	            for (TreeNode right : rightSubtrees) 
	            {
	                TreeNode root = new TreeNode(i);
	                root.left = left;
	                root.right = right;
	                res.add(root);
	            }
	        }
	    }
	    return res;
	}

}
