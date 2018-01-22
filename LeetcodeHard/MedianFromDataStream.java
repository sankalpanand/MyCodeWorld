package LeetcodeHard;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFromDataStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

/*
Step 1: Add next item to one of the heaps

   if next item is smaller than maxHeap root add it to maxHeap,
   else add it to minHeap

Step 2: Balance the heaps (after this step heaps will be either balanced or
   one of them will contain 1 more item)

   if number of elements in one of the heaps is greater than the other by
   more than 1, remove the root element from the one containing more elements and
   add to the other one


Then at any given time you can calculate median like this:

   If the heaps contain equal elements;
     median = (root of maxHeap + root of minHeap)/2
   Else
     median = root of the heap with more elements
*/
class MedianFinder 
{

	// max queue is always larger or equal to min queue
	PriorityQueue<Integer> min = new PriorityQueue();
	PriorityQueue<Integer> max = new PriorityQueue(1000, Collections.reverseOrder());
	
	// Adds a number into the data structure.
	public void addNum(int num) 
	{
		max.offer(num);
		min.offer(max.poll());
		if (max.size() < min.size())
		{
			max.offer(min.poll());
		}
	}

	// Returns the median of current data stream
	public double findMedian() 
	{
		if (max.size() == min.size()) 
			return (max.peek() + min.peek()) /  2.0;
		
		else 
			return max.peek();
	}
};