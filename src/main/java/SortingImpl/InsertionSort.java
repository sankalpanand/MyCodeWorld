package SortingImpl;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		// create an int array we want to sort using bubble sort algorithm
		//		int numss[] = new int[] { 5, 90, 35, 45, 150, 3 };
		int numss[] = new int[] {150, 90, 45, 35, 5, 3};

		// print array before sorting using bubble sort algorithm
		System.out.println("Array Before Bubble mergeSort");
		for (int i = 0; i < numss.length; i++) {
			System.out.print(numss[i] + " ");
		}

		// sort an array using bubble sort algorithm
		insertionSort(numss);

		System.out.println("");

		// print array after sorting using bubble sort algorithm
		System.out.println("Array After Bubble mergeSort");
		for (int i = 0; i < numss.length; i++) {
			System.out.print(numss[i] + " ");
		}
	}

	//	https://www.youtube.com/watch?v=i-SKeOcBwko
	// https://www.youtube.com/watch?v=JU767SDMDvA - short version
	// We assume that the first item is always sorted
	// We start with the second element and insert it in the right place
	// With each pass, the sorted portion of the array on the left increases by 1
	public static void insertionSort(int arr[]) {
		int n = arr.length;
		for (int i = 1; i < n; ++i) {
			int key = arr[i];
			int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j]; // Copy this element on to next one
				j--;
			}

			// Loop will break when the key (item to be moved) is no longer smaller than the item at j
			// It means, just place the key on the next place, which is j+1
			arr[j + 1] = key;
		}
	}

}
