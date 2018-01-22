package Threading;

public class HelloWorldThread extends Thread 
{
	final String text;
	static boolean keeper = true;
	final  boolean flag;;
	final  Object lock;

	public static void main(String args[])
	{
		//Sync will happen over this object named lock
		final Object lock = new Object();
		
		new Thread(new HelloWorldThread("hello", lock, true)).start();
		new Thread(new HelloWorldThread("world", lock, false)).start();
	}

	//constructor
	public HelloWorldThread(String text, Object lock, boolean flag)
	{
		this.text = text;
		this.lock = lock;
		this.flag = flag;
	}

	public void run()
	{
		// this loop will print 3 hello and 3 world
		// Do this until i reaches 6 and 
		for(int i=0; i<6 && !Thread.currentThread().isInterrupted(); i++)
		{
			synchronized(lock) 
			{
				// Flag is a thread identifier. Hello is true. World is false.
				if(flag == keeper)
				{
					// Each thread enters this method, print it and toggles the keeper for the next thread to enter.
					System.out.print(this.text + " ");					
					keeper = !keeper;
					
					// Notify message other threads that i am done, u can go ahead
					lock.notify();
				}
				
				// The thread is not allowed to enter, so let it wait.
				else
				{
					try 
					{
						// this ask thread to wait
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
						return;
					}
				}

			}
		}
	}
}
