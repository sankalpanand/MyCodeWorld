package SelectionSort;

public class SelectionSort {

	public static void main(String[] args) {
		// create an int array we want to sort using bubble sort algorithm
		int numss[] = new int[] { 5, 90, 35, 45, 150, 3 };

		// print array before sorting using bubble sort algorithm
		System.out.println("Array Before Bubble Sort");
		for (int i = 0; i < numss.length; i++) {
			System.out.print(numss[i] + " ");
		}

		// sort an array using bubble sort algorithm
		selectionSort(numss);

		System.out.println("");

		// print array after sorting using bubble sort algorithm
		System.out.println("Array After Bubble Sort");
		for (int i = 0; i < numss.length; i++) {
			System.out.print(numss[i] + " ");
		}
	}

	public static int[] selectionSort(int[] nums)
	{
		/* nums[0] to nums[n-1] is the array to sort */
		int i,j;
		int iMin;
		int n = nums.length;

		for (j = 0; j < n-1; j++) 
		{
		    /* find the min element in the unsorted nums[j .. n-1] */
		    /* assume the min is the first element */
		    iMin = j;
		    
		    /* Get the minimum in the remaining array after j'th index */
		    for ( i = j+1; i<n; i++) 
		    {
		        /* if this element is less, then it is the new minimum */
		        if (nums[i] < nums[iMin]) 
		        {
		            /* found new minimum; remember its index */
		            iMin = i;
		        }
		    }

		    // Swap the minimum element with current element
		    if(iMin != j) {
		    	nums[j] = nums[j] + nums[iMin];
		    	nums[iMin] = nums[j] - nums[iMin];
		    	nums[j] = nums[j] - nums[iMin];
		    }
		}
		
		return nums;
	}

}
