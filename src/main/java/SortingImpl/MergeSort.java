package SortingImpl;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {2,4,1,6,8,5,3,7}; // len=8
		System.out.println(Arrays.toString(array));
		mergeSort(array);
		System.out.println(Arrays.toString(array));

	}

	// https://www.youtube.com/watch?v=TzeBrDU-JaY
	public static void mergeSort(int[] array)
	{
		int len = array.length;
		
		/* BASE CONDITION
		 * If there is just 1 element in the array, it means it need not be sorted. 
		 * It is just one element, just return it. */
		if(len < 2) 
			return;
		
		int mid = len/2;

		// In case of odd size, left will have one less size than the right
		int[] left = new int[mid]; 
		int[] right = new int[len - mid]; // remaining size 

		//	int[] left1 = Arrays.copyOfRange(array, 0, mid);
		for (int i = 0; i < mid; i++) 
		{
			left[i] = array[i];
		}

		//	int[] right1 = Arrays.copyOfRange(array, mid, len);
		for (int i = mid; i < len; i++) 
		{
			right[i-mid] = array[i];
		}
		
		mergeSort(left);
		mergeSort(right);

		Merge(left, right, array);					
	}
	
	public static void Merge(int[] left, int[] right, int[] parent)
	{
		int leftLength = left.length;
		int rightLength = right.length;
		
		int leftIndex = 0, rightIndex =0, parentIndex = 0;
		while(leftIndex < leftLength && rightIndex < rightLength)
		{
			if(left[leftIndex] <= right[rightIndex])
			{
				parent[parentIndex] = left[leftIndex];
				
				leftIndex++;
			}
			else
			{
				parent[parentIndex] = right[rightIndex];				
				rightIndex++;
			}
			
			parentIndex++;
		}
		
		/* Only one of these two while loops will execute */
		/* Check whether there are leftovers in the left array */
		while(leftIndex < leftLength)
		{
			parent[parentIndex] = left[leftIndex];
			parentIndex++;
			leftIndex++;
		}
		
		/* Check whether there are leftovers in the right array */
		while(rightIndex < rightLength)
		{
			parent[parentIndex] = right[rightIndex];
			parentIndex++;
			rightIndex++;
		}				
		
	}
	
	

}
