import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// http://www.geeksforgeeks.org/print-postorder-from-given-inorder-and-preorder-traversals/
public class BSTPreOrderToPostOrder 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		ArrayList<Integer> inorder;

		Scanner sc = new Scanner(System.in);
		inorder= new ArrayList<Integer>();

		while (sc.hasNext()) 
		{
			inorder.add(Integer.parseInt(sc.nextLine()));
		}

		int[] inOrder = new int[inorder.size()];
		for (int i = 0; i < inorder.size(); i++) 
		{
			inOrder[i] = inorder.get(i);
		}

		// int[] inOrder = {5,2,1,3,8,6,9};
		int[] preorderCopy = Arrays.copyOf(inOrder, inOrder.length);
		Arrays.sort(inOrder);

		printPostOrder(inOrder, preorderCopy, inOrder.length);

	}


	// Prints postorder traversal from given inorder and preorder traversals
	static void printPostOrder(int in[], int pre[], int n)
	{
		// The first element in pre[] is always root, search it
		// in in[] to find left and right subtrees
		int root = search(in, pre[0], n);

		// If left subtree is not empty, print left subtree
		if (root != 0)
			printPostOrder(in, Arrays.copyOfRange(pre, 1, pre.length), root);

		// If right subtree is not empty, print right subtree
		if (root != n-1)
			printPostOrder(Arrays.copyOfRange(in, root+1, in.length), Arrays.copyOfRange(pre, root+1, pre.length), n-root-1);

		// Print root
		System.out.println(pre[0] + " ");
	}

	// A utility function to search x in arr[] of size n
	static int search(int arr[], int x, int n)
	{
		for (int i = 0; i < n; i++)
			if (arr[i] == x)
				return i;
		return -1;
	}
}
