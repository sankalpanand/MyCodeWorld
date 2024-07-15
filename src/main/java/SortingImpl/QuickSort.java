package SortingImpl;

import java.util.Arrays;

public class QuickSort {

	// https://www.youtube.com/watch?v=COk73cpQbFQ
	/*
	Why Quick mergeSort is better?
	It is an in-place sorting algorithm, so it is better than Merge sort.
	 */


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {52, 36, 43, 97, 21, 18, 67};
		System.out.println(Arrays.toString(array));
		Sort(array, 0, 6);
		System.out.println(Arrays.toString(array));

	}

	// Works on the idea that an element is sorted if all the elements left of it are smaller and all the elements right of it are bigger
	// https://www.youtube.com/watch?v=7h1s2SojIRw
	public static void Sort(int[] array, int start, int end)
	{		
		if (start >= end) {
			return;
		}
		
		int pivotIndex = Partition(array, start, end);
		Sort(array, start, pivotIndex - 1);
		Sort(array, pivotIndex + 1, end);
	}

	// https://youtu.be/COk73cpQbFQ?list=PL2_aWCzGMAwKedT2KfDMB9YA5DgASZb3U&t=889
	// Returns the pivot
	public static int Partition(int[] array, int start, int end)
	{
		// Our pivot will always be the last element of the array
		int pivot = array[end];
		
		// At any stage, all the elements to the left of the partitionIndex will be less than the pivot
        // partition index basically tells us the pivot point where the elements to the left will be smaller
        // if you're swapping smaller value with the partition index, you'll have to increment it so that the next swap takes place at the next index
        // partition index will be left behind i as you'll start encountering larger numbers.
		int partitionIndex = start;

		// Agar pivot bada hai, to dono i and p aage badhenge and swap hoga
		// Agar pivot chhota hai to sirf i aage badhega
		for (int i = start; i < end; i++) {
			if (array[i] <= pivot) {
				swap(array, i, partitionIndex);
				partitionIndex++;				
			}			
		}
		
		swap(array, partitionIndex, end);
		return partitionIndex;		
		
	}

	public static void swap(int[] array, int x, int y)
	{
		int temp = array[x];
		array[x] = array[y];
		array[y] = temp;
	}

}
