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
        int[] nums = {3,2,1,5,6,4}; // => 1,2,3,4,5,6, len=6, k=2, len-k=4
        System.out.println(obj.findKthLargest(nums, 2));
    }

    // https://leetcode.com/problems/kth-largest-element-in-an-array/solutions/60294/solution-explained/

	// Solution 1 - mergeSort and pick Kth element
    // O(N log N) running time + O(1) memory
    public int findKthLargest1(int[] nums, int k) {
        final int N = nums.length;
        Arrays.sort(nums);
        return nums[N - k];
    }

    // Solution 2 - Priority Queue
	// O(N log K) running time + O(K) memory
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



	// Neetcode - https://www.youtube.com/watch?v=XEmy13g1Qxc
	// Leetcode - https://leetcode.com/problems/kth-largest-element-in-an-array/
	// O(N) best case / O(N^2) worst case running time + O(1) memory
	public int findKthLargest(int[] nums, int k) {
		int len = nums.length;

		// We are sending k as len-k because we are searching for 2nd largest element in an array of size 10, we will search for 8th one.
		return quickSelect(nums, 0, len-1, len-k);
	}

	public int quickSelect(int[] nums, int start, int end, int searchIndex) {
		// Step 1: Partition the array around last element and get position of pivot
		int pivot = nums[end];
		int pIndex = start;

		// If nums[i] is less than pivot, then i and pIndex both will move. Otherwise only i will move.
		for(int i=start; i <= end-1; i++) {
			if(nums[i] < pivot) {
				swap(nums, i, pIndex);
				pIndex++;
			}
		}

		swap(nums, pIndex, end);

		// Step 3: pIndex usually means that all the elements lesser than it lies towards its left
        // and the ones greater than it lie towards its right.
		// Since the search index is less than the pIndex, the search element should be in the LHS.
		if(pIndex > searchIndex) {
			return quickSelect(nums, start, pIndex - 1, searchIndex);
		}

		// Step 4: Since the search index is more than the pIndex, the search element should be in the RHS.
		else if (pIndex < searchIndex) {
			return quickSelect(nums, pIndex + 1, end, searchIndex);
		}

		else {
			return nums[pIndex];
		}
	}

	public void swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
}
