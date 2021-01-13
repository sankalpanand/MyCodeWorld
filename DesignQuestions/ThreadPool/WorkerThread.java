package ThreadPool;

/** This class hosts the functionality of a worker thread which exists within the Thread Pool */
public class WorkerThread extends Thread 
{
	public void run() 
	{
		// This thread will keep running as long as there are jobs in the queue
		while (true) 
		{
			// If there are no jobs in the queue, it doesn't have any work to do
			if(ThreadPool.queue.size() == 0)
			{
				System.out.println(this.getName() + ": No more jobs for me. I am killing myself.");
				break;
			}
			
			// Worker thread retrieves the job from the job queue
			Runnable job = (Runnable) ThreadPool.queue.dequeue();
			
			// Run the job in this current thread
			try 
			{
				job.run();
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
	}
}
