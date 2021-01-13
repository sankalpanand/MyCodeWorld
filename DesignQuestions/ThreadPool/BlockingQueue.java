package ThreadPool;

import java.util.LinkedList;

class BlockingQueue<E>
{
	private final LinkedList<E> queue = new LinkedList<E>();
	private boolean isServerClosed = false;

	/** This synchronized method is used by multiple threads to submit their jobs to the queue */
	synchronized public void enqueue(E job) 
	{
		// While adding jobs to the queue, check if the server is accepting jobs or not
		if (isServerClosed) 
		{
			throw new ServerIllegalStateException();
		}
		
		// Add the job to the queue
		queue.add(job);
		
		// Notify any other thread that are waiting on this method to enqueue their jobs
		notify();
	}

	/** This synchronized method is used by multiple threads to sretrieve jobs from the queue */
	synchronized public E dequeue() 
	{
		// Check two things - 1. The server is functioning, 2. There are jobs in the queue 
		while (! isServerClosed && queue.size() == 0) 
		{
			try 
			{
				wait();
			} 
			catch (InterruptedException e) 
			{
				// ignore
			}
		}
		
		// If the size of the queue is already zero, then there is nothing to dequeue
		if (queue.size() == 0) 
		{
			return null;
		}
		
		// Remove the first item from the queue
		return queue.removeFirst();
	}

	/** This synchronized method is used by multiple threads to check the size of the job queue */
	synchronized public int size() {
		return queue.size();
	}

	/** This synchronized method is used by multiple threads to close the server */
	synchronized public void closeServer() {
		isServerClosed = true;
		notifyAll();
	}

	/** This synchronized method is used by multiple threads to start the server */
	synchronized public void openServer() {
		isServerClosed = false;
	}

	
}
