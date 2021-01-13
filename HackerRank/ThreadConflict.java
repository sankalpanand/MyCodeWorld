
public class ThreadConflict {

	public static void main(String[] args) 
	{
		
		Integer iterations = 2000;
		int processor = 10000;
		
		CountingThread[] threads = new CountingThread[processor];
		
		for (int i = 0; i < processor; i++)
			threads[i] = new CountingThread(iterations);
		
		
		// Start all 1000000 threads
		for (CountingThread t : threads)
			t.start();
		
		
		boolean stoped = false;
		
		// Stop tab false return hoga agar ek bhi thread chal raha hoga andar. 
		// Ye for loop tab terminate hoga agar saare threads chalna band ho jaaye.
		while (!stoped) 
		{
			stoped = CountingThread.isStopped(threads);

			try {
				Thread.sleep(0);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(CountingThread.counter);
	}

	static class CountingThread extends Thread {
		/**
		 * Static fields
		 */
		static Integer counter = 0;

		static synchronized  void increaseCounter() {
			counter++;
		}

		public static int getCounter() {
			return counter;
		}

		
		/** It goes through each thread. Checks each one of them if they are running. 
		 * If any one of them is running, it returns out false.
		 * @param threads
		 * @return
		 */
		public static boolean isStopped(CountingThread[] threads) 
		{
			for (CountingThread t : threads) 
			{
				if (t.isAlive()) 
				{
					return false;
				}
			}
			return true;
		}
        
        public static boolean isStopped2(CountingThread[] threads) 
		{
			
			for (CountingThread t : threads) 
			{
			if (t.isAlive()) 
				{
					return false;
				}
			}
			return true;
			
			
		}

		/**
		 * Static fields ended
		 */

		boolean running = false;
		static int iterations;

		public CountingThread(int iterations) 
		{
			this.iterations = iterations;
		}

		@Override
		public void run() 
		{
			running = true;
			for (int i = 0; i < iterations; i++) {
				increaseCounter();
			}
			running = false;
			
		}

		public boolean isRunning() 
		{
			return running;
		}

	}

}


