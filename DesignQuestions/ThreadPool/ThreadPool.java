package ThreadPool;

public class ThreadPool
{
	/*** This is thw queue that will hold all the jobs */
	protected static BlockingQueue<Runnable> queue;
	
	/*** This is the status of the ThreadPool */
	private boolean threadPoolClosed = true;

	/** These are the parameters and getters and setters of the thread pool */
	private int poolSize;
	public void setPoolSize(int poolSize) { this.poolSize = poolSize; }
	public int getPoolSize() { return poolSize; }

	public ThreadPool(int poolSize) 
	{
		this.poolSize = poolSize;
		queue = new BlockingQueue<Runnable>();
	}
	
	/** This method will start the thread pool and trigger all the Threads which it will hold within */
	public void start() 
	{
		if (!threadPoolClosed) 
		{
			throw new IllegalStateException("Pool already started.");
		}
		
		threadPoolClosed = false;
		
		// Start all the threads
		for (int i = 0; i < poolSize; ++i) 
		{
			new WorkerThread().start();
		}
	}

	/** This method accepts a Runnable Job and pushes it on to queue */
	synchronized public void submitJob(Runnable job) 
	{
		// If the thread pool is closed, raise exception
		if (threadPoolClosed) 
		{
			throw new PoolIllegalStateException();
		}
		
		queue.enqueue(job);
	}

	

	public void close() {
		threadPoolClosed = true;
		queue.closeServer();
	}

	
}

