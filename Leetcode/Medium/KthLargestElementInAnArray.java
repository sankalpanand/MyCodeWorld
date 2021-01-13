package Leetcode.Medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElementInAnArray {

    public static void main(String[] args) {

        // Default will keep the smallest at the front
//        PriorityQueue<Integer> pq= new PriorityQueue<>(5);
//
//        // To get decreasing order, you'll have to pass in a comparator
//        // pq = new PriorityQueue<Integer>(5, (a,b) -> b-a);
//
//        pq.add(8);
//        pq.add(5);
//        pq.add(3);
//
//        while (pq.size() != 0) {
//            // the remove() method throws an exception, while the poll() method returns null
//            System.out.println(pq.remove());
//        }

        // Runner
        KthLargestElementInAnArray obj = new KthLargestElementInAnArray();
        int[] nums = {3,2,1,5,6,4};
        System.out.println(obj.findKthLargest(nums, 2));
    }

	// Solution 1 - mergeSort and pick Kth element
    // O(N lg K) running time + O(K) memory
    public int findKthLargest1(int[] nums, int k) {
        final int N = nums.length;
        Arrays.sort(nums);
        return nums[N - k];
    }

    // Solution 2 - Priority Queue
    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int val : nums) {
            pq.offer(val);

            if(pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }



	// http://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array/
	public int findKthLargest(int[] nums, int k)
	{
		int len = nums.length;

		// We are sending k as len-k because we are for 2nd largest element in an array of size 10, we will search for 8th one.
		return helper(nums, len-k, 0, len-1);
	}

	public int helper(int[] nums, int searchIndex, int start, int end)
	{
		// Step 1: Partition the array around last element and get position of pivot
		int pIndex = partition(nums, start, end);

		// Step 2: If position = k, return element
		if(pIndex == searchIndex) {
			return nums[pIndex];
		}

		// Step 3: pIndex usually means that all the elements lesser than it lies towards its left
        // and the ones greater than it lie towards its right.
		// Since the search getCellIndex is less than the pIndex, the search element should be in the LHS.
		else if(pIndex > searchIndex)
		{
			return helper(nums, searchIndex, start, pIndex - 1);
		}

		// Step 4: Since the search getCellIndex is more than the pIndex, the search element should be in the RHS.
		else
			return helper(nums, searchIndex, pIndex + 1, end);

	}

	// It considers the last element as the pivot
	// Moves all smaller elements to the left of it
	// Greater elements to the right of it
	public int partition(int[] nums, int start, int end)
	{
		int pivot = nums[end];
		int pIndex = start;

		for(int i = start; i <= end-1; i++) {
			if(nums[i] < pivot)
			{
				swap(nums, i, pIndex);
				pIndex++;
			}
		}

		swap(nums, pIndex, end);
		return pIndex;
	}

	public void swap(int[] nums, int a, int b)
	{
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}



}
