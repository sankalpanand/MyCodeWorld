import java.util.Queue;

// http://www.careercup.com/question?id=4827656025538560

public class LastTenMinuteAveragePrice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircularArrayQueue queue = new CircularArrayQueue(5);
        
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        queue.enqueue("D");
        //queue.enqueue("E");
        System.out.println(queue.size());
        System.out.println(queue.dequeue());
        queue.enqueue("E");
        System.out.println(queue.size());
        //queue.enqueue("F");
        System.out.println(queue.dequeue());
        System.out.println(queue.size());

	}

}

class CircularArrayQueue
{
	private Object[] queue;
	private final int capacity; // capacity
	
	// Pointers- front and rear
	private int f = 0;
	private int r = 0;
	

	public CircularArrayQueue(int capacity)
	{
		this.capacity = capacity;
		queue = new Object[capacity];
	}

	public int size() 
	{
		if(r > f)
			return r - f;
		
		return capacity - f + r;
	}

	public boolean isEmpty() 
	{
		return (r == f) ? true : false;
	}

	public boolean isFull() 
	{
		int diff = r - f; 
		
		if(diff == -1 || diff == (capacity -1))
			return true;
		
		return false;
	}

	public synchronized void enqueue(Object obj)
	{
		if(isFull())
		{
			System.out.println("Full!!");;
		}
		
		else
		{
			queue[r] = obj;
			r = (r + 1) % capacity;
		}
	}

	public synchronized Object dequeue() 
	{
		Object item; 
		if(isEmpty())
		{
			System.out.println("Error.");
			return null;
		}
		else
		{
			item = queue[f];
			queue[f] = null;
			f = (f + 1) % capacity;
		}
		return item;
	}

}
