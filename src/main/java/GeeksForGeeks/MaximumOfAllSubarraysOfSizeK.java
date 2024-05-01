import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class MaximumOfAllSubarraysOfSizeK {

	/*
	 * 
	Input :
	arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}
	k = 3
	Output :
	3 3 4 5 5 5 6
	 * 
	 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 2, 3, 1, 4, 5, 2, 3, 6};
		printMax(nums, 3);

	}

	public static void printMax1(int[] nums, int k)
	{		
		int size = nums.length;
		int[] result = new int[size -k + 1];

		for(int i=0; i<= size - k; i++)
		{
			int max = Integer.MIN_VALUE;
			for(int j=i; j<i+3; j++)
			{
				if(nums[j] > max)
				{
					max = nums[j];
				}
			}
			result[i] = max; 
		}

		System.out.println(Arrays.toString(result));
	}

	// O(n) single pass
	public static void printMax(int[] nums, int k)
	{
		Deque<Integer> DQ = new LinkedList<Integer>();

		/* Process first k (or first window) elements of array */
		int i;
		int n = nums.length;
		
		for (i = 0; i < k; ++i)
		{
			// For every element, the previous smaller elements are useless so remove them
			while ( !DQ.isEmpty() && nums[i] >= nums[DQ.peekLast()])
				DQ.pollLast(); 

			// Add new element at rear of queue
			DQ.offerLast(i);
		}
		
		// Process rest of the elements, i.e., from arr[k] to arr[n-1]
	    for ( ; i < n; ++i)
	    {
	        // The element at the front of the queue is the largest element of previous window, so print it
	        System.out.print(nums[DQ.peekFirst()] + " ");
	 
	        // Remove the elements which are out of this window
	        while ( ! DQ.isEmpty() && DQ.peekFirst() <= i - k)
	        	DQ.pollFirst();  // Remove from front of queue
	 
	        // Remove all elements smaller than the currently being added element (remove useless elements)
	        // Same as previous loop
	        while ((!DQ.isEmpty()) && nums[i] >= nums[DQ.peekLast()])
	        	DQ.pollLast();
	 
	         // Add current element at the rear of Qi
	        DQ.offerLast(i);
	    }
	}

}
