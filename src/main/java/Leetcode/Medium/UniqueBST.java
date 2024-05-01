package Leetcode.Medium;

public class UniqueBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numTrees(5));
	}
	
	
	/*
	 	Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
	 	
	 	https://leetcode.com/discuss/24282/dp-solution-in-6-lines-with-explanation-f-i-n-g-i-1-g-n-i
	 	https://www.youtube.com/watch?v=YDf982Lb84o
     	
	 	G(n): the number of unique BST for a sequence of length n.
	 	F(i, n), 1 <= i <= n: the number of unique BST, where the number i is the root of BST, and the sequence ranges from 1 to n.
	 	For example, F(3,7) = G(2) * G(4)
	 	
	 	G(n) = F(1, n) + F(2, n) + ... + F(n, n)
	 		 = G(0) * G(n-1) + G(1) * G(n-2) + � + G(n-1) * G(0)
	 	
	 	0 = 1
	 	1 = 1	 	
	 	2 = G[0]*G[1]	G[1]*G[0]	
		3 = G[0]*G[2]	G[1]*G[1]	G[2]*G[0]	
		4 = G[0]*G[3]	G[1]*G[2]	G[2]*G[1]	G[3]*G[0]	
		5 = G[0]*G[4]	G[1]*G[3]	G[2]*G[2]	G[3]*G[1]	G[4]*G[0]	
		
	 * */
    public static int numTrees(int n) 
    {
        int [] G = new int[n+1];
        
        // Only one combination to construct a BST out of a sequence of length 1 (only a root) or 0 (empty tree). 
        G[0] = G[1] = 1;
    
        // Iterate for the remaining from 2 till n
        for(int i=2; i<=n; ++i) 
        {
        	// Every i'th level will have i'th components
            for(int j=1; j<=i; ++j)
            {
            	System.out.print("G[" + (j-1) + "]" + "*" + "G[" + (i-j) + "]\t");
                G[i] = G[i] + G[j-1] * G[i-j];
            }
            System.out.println();
        }
    
        return G[n];
    }
}
