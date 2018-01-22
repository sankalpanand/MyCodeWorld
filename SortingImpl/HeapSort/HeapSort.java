package HeapSort;

import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {12, 11, 13, 5, 6, 7};
		int size = array.length;
		System.out.println(Arrays.toString(array));
		heapSort(array, size);
		System.out.println(Arrays.toString(array));
	}

	public static void heapSort(int[] array, int size)
	{
		// Build a heap from input data
		MaxHeap maxHeap = createAndBuildHeap(array, size);
		
		System.out.println("MaxHeap: " + Arrays.toString(maxHeap.array));
		
		// Repeat the process until heap size > 1
		// The last element in the max heap will be the minimum element		
		while(maxHeap.size > 1)
		{
			System.out.println("Size: " + maxHeap.size + "\t" + Arrays.toString(maxHeap.array));
			
			// The largest item in the heap is stored at the root.
			// Replace it with the last item of the heap and reduce the size of the heap by 1.
			// Swap
			int temp = maxHeap.array[0];
			maxHeap.array[0] = maxHeap.array[maxHeap.size - 1];
			maxHeap.array[maxHeap.size - 1] = temp;
			
			maxHeap.size--;
			
			// Finally, heapify the root of the tree
			maxHeapify(maxHeap, 0);
		}

	}

	public static MaxHeap createAndBuildHeap(int[] array, int size)
	{
		MaxHeap maxHeap = new MaxHeap(array, size);

		// Start from the bottommost and rightmost internal node and heapify all the internal modes in a bottomup way.
		// We start by the first parent node from the bottom - (maxHeap.size -1 -1) / 2 
		for(int i = (maxHeap.size -1 -1) / 2; i >=0; i--)
		{
			maxHeapify(maxHeap, i);
		}
		return maxHeap;
	}

	// How to heapify- https://www.youtube.com/watch?v=5iBUTMWGtIQ
	// The main function to heapify a max heap.
	// It assumes that everything under given root is already heapified.
	public static void maxHeapify(MaxHeap maxHeap, int parent)
	{
		int largest = parent;
		int leftChild = 2 * parent + 1;
		int rightChild = 2 * parent + 2;

		// See if the left child of root exists and is greater than the largest so far
		// We check for heapSize here for 2 reasons-
		// 1. It should not check out of bounds
		// 2. We are decreasing size after every heapify in heap sort. So, this will stop the infinite loop of heapify and swapping.
		if(leftChild < maxHeap.size && 
				maxHeap.array[leftChild] > maxHeap.array[largest])
			largest = leftChild;

		// See if the right child of root exists and is greater than the largest so far
		if(rightChild < maxHeap.size && 
				maxHeap.array[rightChild] > maxHeap.array[largest])
			largest = rightChild;

		// Change root, if needed
		if(largest != parent)
		{
			// Swap
			int temp = maxHeap.array[largest];
			maxHeap.array[largest] = maxHeap.array[parent];
			maxHeap.array[parent] = temp;

			// This swap might have invalidated the subtrees within, so they need to be heapified again.
			// Now, the root is no longer the index.
			// Root may have been shifted to the 'largest' position 
			maxHeapify(maxHeap, largest);
		}

	}

}

class MaxHeap
{
	int size;
	int[] array;

	public MaxHeap(int[] array, int size) 
	{
		// TODO Auto-generated constructor stub
		this.size = size;
		this.array = array;
	}
}
