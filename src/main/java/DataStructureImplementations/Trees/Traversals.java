package DataStructureImplementations.Trees;

import Leetcode.ParentClasses.Tree;

import java.util.*;

public class Traversals extends Tree {

	/*
	Tree Traversals-
	1. Breadth First Traversal (Or Level Order Traversal)
    2. Depth First Traversals
        i. Inorder Traversal (Left-Root-Right)
        ii. Preorder Traversal (Root-Left-Right)
        iii. Postorder Traversal (Left-Right-Root)

    BFS starts visiting nodes from root while DFS starts visiting nodes from leaves.
	 */
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7,8,9};
		
		TreeNode root = AssortedMethods.createMinimalBST(array, 0, array.length - 1);
		BTreePrinter1.printNode(root);
		// inOrder(root);
		// System.out.println();
		// preOrder(root);
		// reverseInOrder1(root);
		// System.out.println();
		// postOrder(root);

        // printLevelOrder(root);
        bfsTraversal(root);
	}
	

	
	public static void reverseInOrder(TreeNode root)
	{
		if(root == null) return;		
		reverseInOrder(root.right);
		System.out.print(root.val + " ");
		reverseInOrder(root.left);
	}
	
	// Print second largest element in a binary tree
	static int count = 0;
	public static void reverseInOrder1(TreeNode root)
	{
		if(root == null) return;		
		reverseInOrder1(root.right);
		
		count++;
		if(count == 2) System.out.println(root.val);
		
		reverseInOrder1(root.left);
	}




    /* function to print level order traversal of tree */
    static void printLevelOrder(TreeNode root)
    {
        int h = height(root);
        int i;
        for (i=1; i<=h; i++) {
            printGivenLevel(root, i);
        }
    }

    /* Compute the "height" of a tree -- the number of nodes along the longest path from the root node down to the farthest leaf node.*/
    static int height(TreeNode root)
    {
        if (root == null)
            return 0;
        else
        {
            /* compute  height of each subtree */
            int lheight = height(root.left);
            int rheight = height(root.right);

            /* use the larger one */
            if (lheight > rheight)
                return(lheight+1);
            else
                return(rheight+1);
        }
    }

    /* Print nodes at the given level */
    static void printGivenLevel (TreeNode root, int level)
    {
        // System.out.println(level);
        if (root == null)
            return;
        if (level == 1)
        {
            System.out.print(root.val + " ");
        }
        else if (level > 1)
        {
            printGivenLevel(root.left, level-1);
            printGivenLevel(root.right, level-1);
        }
    }

    /*------------------------------------------------------------------------------------------------------------
    BFS Traversal (uses a queue) | https://www.youtube.com/watch?v=86g8jAQug04
    -------------------------------------------------------------------------------------------------------------- */
    static void bfsTraversal(TreeNode root)
    {
        if(root == null)
            return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode current = queue.remove();
            System.out.print(current.val + " ");

            if(current.left != null)
                queue.add(current.left);

            if(current.right != null)
                queue.add(current.right);

        }
    }

    /*
    ------------------------------------------------------------------------------------------------------------
    DFS - INORDER - PREORDER - POSTORDER using recursion
    ------------------------------------------------------------------------------------------------------------
     */

    public static void inOrder(TreeNode root)
    {
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    public static void preOrder(TreeNode root)
    {
        if(root == null) return;
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);

    }

    public static void postOrder(TreeNode root)
    {
        if(root == null) return;
        preOrder(root.left);
        preOrder(root.right);
        System.out.print(root.val + " ");
    }

    /*
    ------------------------------------------------------------------------------------------------------------
    DFS - INORDER - PREORDER - POSTORDER without using recursion - https://www.youtube.com/watch?v=nzmtCFNae9k
    ------------------------------------------------------------------------------------------------------------
     */

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();

        while(!stack.isEmpty() || root != null) {

            // If root isn't null, push it to the stack and move towards left
            if(root != null)
            {
                stack.push(root );
                root = root.left;
            }
            else // As soon as root is null (which means we have hit the depth), pop and move towards right
            {
                TreeNode node = stack.pop();
                result.add(node.val);  // Add after all left children
                root = node.right;
            }
        }
        return result;
    }

    // From Leetcode - https://leetcode.com/problems/binary-tree-postorder-traversal/discuss/45551/Preorder-Inorder-and-Postorder-Iteratively-Summarization
    public List<Integer> preorderTraversal(TreeNode root) {
        
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode temp = root;
        
        while(!stack.isEmpty() || temp != null) {
            if(temp != null) {
                stack.push(temp);
                result.add(temp.val);  // Add before going to children
                temp = temp.left;
            } else {
                TreeNode node = stack.pop();
                temp = node.right;
            }
        }
        return result;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode temp = root;
        while(!stack.isEmpty() || temp != null) {
            if(temp != null) {
                stack.push(temp);
                result.addFirst(temp.val);  // Reverse the process of preorder
                temp = temp.right;             // Reverse the process of preorder
            } else {
                TreeNode node = stack.pop();
                temp = node.left;           // Reverse the process of preorder
            }
        }
        return result;
    }


}
