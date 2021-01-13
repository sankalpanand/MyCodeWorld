package Queue;

public class QueueUsingArray 
{
	public static void main(String[] args)
	{
		Queue queue = createQueue(5);

		enqueue(queue, 10);
		enqueue(queue, 20);
		enqueue(queue, 30);
		enqueue(queue, 40);
		enqueue(queue, 50);

		System.out.println("Dequeued from queue " + dequeue(queue));
		enqueue(queue, 60);
		
		System.out.println("Front item is " + front(queue));
		System.out.println("Rear item is " + rear(queue));
	}
	
	public static Queue createQueue(int capacity)
	{
		Queue queue = new Queue();
		queue.capacity = capacity;
		queue.front = 0;
		queue.size = 0;
		queue.rear = capacity - 1;  // This is important, see the enqueue
		queue.array = new int[capacity];
		return queue;
	}

	static void enqueue(Queue queue, int item)
	{
		if (isFull(queue))
			return;

		// This makes sure to wrap the rear getCellIndex after increasing it
		queue.rear = (queue.rear + 1) % queue.capacity;
		
		// Now that we have updated the rear, store value on top of it
		queue.array[queue.rear] = item;
		
		// Update the size
		queue.size = queue.size + 1;
		
		System.out.println("Enqueued to queue " + item);
	}

	static int dequeue(Queue queue)
	{
		if (isEmpty(queue))
			return Integer.MIN_VALUE;
		
		// Get the item from the front.
		int item = queue.array[queue.front];
		
		// This makes sure to wrap the front getCellIndex after increasing it
		queue.front = (queue.front + 1) % queue.capacity;
		
		// Decrease the size
		queue.size = queue.size - 1;
		
		// Return the item
		return item;
	}

	static int front(Queue queue)
	{
		if (isEmpty(queue))
			return Integer.MIN_VALUE;
		
		return queue.array[queue.front];
	}

	public static int rear(Queue queue)
	{
		if (isEmpty(queue))
			return Integer.MIN_VALUE;
		
		return queue.array[queue.rear];
	}
	
	static boolean isFull(Queue queue)
	{  
		return queue.size == queue.capacity;
	}

	static boolean isEmpty(Queue queue)
	{
		return queue.size == 0;
	}
}

class Queue
{
	int front;
	int rear;
	int size;
	int capacity;
	int[] array;
}
