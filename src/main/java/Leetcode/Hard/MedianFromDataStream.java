package Leetcode.Hard;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFromDataStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

// Video explanation - https://www.youtube.com/watch?v=itmhHWaHupI
// https://leetcode.com/problems/find-median-from-data-stream/discuss/74047/JavaPython-two-heap-solution-O(log-n)-add-O(1)-find
// Complexity - Alltogether, the add operation is O(logn), The findMedian operation is O(1).
class MedianFinder 
{
    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(1);
        obj.addNum(2);
        obj.addNum(3);

        obj.findMedian();
    }

    PriorityQueue<Integer> minHeap = null;
    PriorityQueue<Integer> maxHeap = null;

    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap = new PriorityQueue<>();                            // right
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());   // left
    }

    // Each element is added to minheap first, (step 1)
    // Then the minimum element is poped out and offered to maxHeap (step 2).
    // This assures all elements in minHeap are greater than max leap.
    //
    // Finally the two heaps ried to be load balanced. (step 3)
    public void addNum(int num) {
        // We add it to the right min heap. After addition its possible that its smallest element is lesser than the
        // largest element in the left heap. So we need to do some balancing.
        minHeap.offer(num);
        maxHeap.offer(minHeap.poll());

        // Next we do some load balancing to maintain the size difference
        if(minHeap.size() < maxHeap.size()){
            minHeap.offer(maxHeap.poll());
        }
    }

    public double findMedian() {
        if(minHeap.size() > maxHeap.size()){
            return minHeap.peek();
        } else { // It means both have equal number of elements
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
    }
};