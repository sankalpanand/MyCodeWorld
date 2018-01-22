package MergeSort;

import java.util.Arrays;


public class MergeSortCTCI 
{
	public static void main(String[] args) 
	{	
		int[] array = {2,4,1,6,8,5,3,7};
		int[] helper = new int[array.length];
		
		System.out.println(Arrays.toString(array));
		mergesort(array, helper, 0, array.length - 1);
		System.out.println(Arrays.toString(array));
	}

	public static void mergesort(int[] array, int[] helper, int start, int end) 
	{
		if (start < end) 
		{
			int middle = (start + end) / 2;
			mergesort(array, helper, start, middle); // Sort left half
			mergesort(array, helper, middle+1, end); // Sort right half
			merge(array, helper, start, middle, end); // Merge them
		}
	}

	public static void merge(int[] array, int[] helper, int start, int middle, int end) 
	{
		/* Copy both halves into a helper array */
		for (int i = start; i <= end; i++) 
		{
			helper[i] = array[i];
		}

		int helperLeftStart = start;
		int helperRightStart = middle + 1;
		int current = start;

		/* Iterate through helper array. Compare the left and right
		 * half, copying back the smaller element from the two halves
		 * into the original array. */
		while (helperLeftStart <= middle && helperRightStart <= end) 
		{
			// If left element is smaller than right element
			if (helper[helperLeftStart] <= helper[helperRightStart]) 
			{
				array[current] = helper[helperLeftStart];
				helperLeftStart++;
			} 
			
			// If right element is smaller than left element
			else 
			{ 
				array[current] = helper[helperRightStart];
				helperRightStart++;
			}
			
			current++;
		}

		/* Copy the rest of the left side of the array into the
		 * target array */
		int remaining = middle - helperLeftStart;
		for (int i = 0; i <= remaining; i++) 
		{
			array[current + i] = helper[helperLeftStart + i];
		}
	}
	
	

}