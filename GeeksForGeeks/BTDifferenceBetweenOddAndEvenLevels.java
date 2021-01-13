public class BTDifferenceBetweenOddAndEvenLevels {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.right = new TreeNode(6);
		
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(4);
		
		root.left.right.left = new TreeNode(3);
		root.right.right = new TreeNode(8);
		
		root.right.right.right = new TreeNode(9);
		root.right.right.left = new TreeNode(7);
		
		/*
		 * 
		      5
		    /   \
		   2     6
		 /  \     \  
		1    4     8
		    /     / \ 
		   3     7   9  
		 
		 
		 * */
		
		System.out.println(getLevelDiff(root));
	}
	
	// It reduces the children from its parents. 
	public static int getLevelDiff(TreeNode root)
	{
		// Base case
		if(root == null) return 0;
		
		return root.val - getLevelDiff(root.left) - getLevelDiff(root.right); 
				
	}
	

}
