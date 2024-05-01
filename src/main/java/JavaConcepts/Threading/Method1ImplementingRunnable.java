package JavaConcepts.Threading;

public class Method1ImplementingRunnable {

	// However, one feature lacking in Runnable is that we cannot make a thread return result when it terminates,
	// i.e. when run() completes. For supporting this feature, the Callable interface is present in Java.
	public static void main(String[] args) 
	{
		RunnableDemo R1 = new RunnableDemo( "Thread-1");
		R1.start();

		RunnableDemo R2 = new RunnableDemo( "Thread-2");
		R2.start();
	}
}

class RunnableDemo implements Runnable 
{
	private Thread t;
	private String threadName;

	RunnableDemo(String name)
	{
		threadName = name;
		System.out.println("Creating " +  threadName );
	}
	
	public void run() 
	{
		System.out.println("Entering Run() of " +  threadName );
		
		try 
		{
			for(int i = 4; i > 0; i--) 
			{
				System.out.println("i=" + i + " from " + threadName);
				// Let the thread sleep for a while.
				Thread.sleep(50);
			}
		} 
		catch (InterruptedException e) 
		{
			System.out.println("Thread " +  threadName + " interrupted.");
		}
		
		System.out.println("Exiting Run() of " +  threadName);
	}

	public void start ()
	{
		System.out.println("Starting " +  threadName );
		if (t == null)
		{
			t = new Thread (this, threadName);
			t.start ();
		}
	}
}