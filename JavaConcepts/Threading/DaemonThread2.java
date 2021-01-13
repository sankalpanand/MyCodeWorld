package JavaConcepts.Threading;

public class DaemonThread2 {

	int syncVar;
	
	private static class MyDaemonThread extends Thread {

		public MyDaemonThread() {
			setDaemon(true);
		}

		@Override
		public void run() {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}



	public static void main(String[] args) throws InterruptedException {
		Thread thread = new MyDaemonThread();
		thread.start();
		thread.join();
		System.out.println(thread.isAlive());



		// 
	}

	public void examples()
	{
		// Example of shut down hook
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {

			}
		});

		
		// Example of synchronize
		synchronized (DaemonThread2.class) 
		{
			syncVar++;
		}

	}
	
	
	


}
