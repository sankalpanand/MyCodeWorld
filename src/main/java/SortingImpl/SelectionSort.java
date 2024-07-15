package SortingImpl;

public class SelectionSort {

	public static void main(String[] args) {
		// create an int array we want to sort using bubble sort algorithm
		int numss[] = new int[] {150, 90, 45, 35, 5, 3};

		// print array before sorting using bubble sort algorithm
		System.out.println("Array Before Bubble mergeSort");
		for (int i = 0; i < numss.length; i++) {
			System.out.print(numss[i] + " ");
		}

		// sort an array using bubble sort algorithm
		selectionSort(numss);

		System.out.println("");

		// print array after sorting using bubble sort algorithm
		System.out.println("Array After Bubble mergeSort");
		for (int i = 0; i < numss.length; i++) {
			System.out.print(numss[i] + " ");
		}
	}

	// https://www.youtube.com/watch?v=GUDLRan2DWM
    // https://www.youtube.com/watch?v=cqh8nQwuKNE
	// {150, 90, 45, 35, 5, 3}, min=3
	// {3, 90, 45, 35, 5, 150}, min=5
	// {3, 5, 45, 35, 90, 150}, min=35
	// {3, 5, 35, 45, 90, 150}, min=35
	// We make one pass, find the min value and swap it with the left most item
	public static int[] selectionSort(int[] nums) {
		int i,j;
		int iMin;
		int n = nums.length;

		for(j = 0; j < n-1; j++) {
		    /* find the min element in the unsorted nums[j .. n-1] */
		    /* assume the min is the first element */
		    iMin = j;
		    
			// Inner loop starts at the first unsorted item and continues through the end of the list
		    for( i = j+1; i<n; i++) {
		        /* if this element is less, then it is the new minimum */
		        if (nums[i] < nums[iMin]) {
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
			System.out.println();
		}
		
		return nums;
	}

}
