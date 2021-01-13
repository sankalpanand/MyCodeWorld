package Leetcode.Hard;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFromDataStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

// https://leetcode.com/problems/find-median-from-data-stream/discuss/74047/JavaPython-two-heap-solution-O(log-n)-add-O(1)-find
// Complexity - Alltogether, the add operation is O(logn), The findMedian operation is O(1).
class MedianFinder 
{

    private PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
    private PriorityQueue<Integer> large = new PriorityQueue<>();
    private boolean even = true;

    public double findMedian() {
        if (even)
            return (small.peek() + large.peek()) / 2.0;
        else
            return small.peek(); // Do a dry run to understand this.
    }

    // Remember we cannot just push the item into large,
    // We should push the new number into small and pop the maximum item from small then push it into large
    public void addNum(int num) {
        if (even)
        {
            large.offer(num);
            small.offer(large.poll());
        }
        else
        {
            small.offer(num);
            large.offer(small.poll());
        }
        even = !even;
    }
};