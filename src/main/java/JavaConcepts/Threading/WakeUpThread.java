package Threading;

public class WakeUpThread implements Runnable 
{
	public static void main(String[] args) throws InterruptedException 
	{
		Thread myThread = new Thread(new WakeUpThread(), "myThread");
		myThread.start();

		System.out.println("[" + Thread.currentThread().getName() + "] Sleeping in main thread for 5s...");
		Thread.sleep(5000);

		System.out.println("[" + Thread.currentThread().getName() + "] Interrupting myThread");
		myThread.interrupt();
	}

	public void run() {
		try {
			System.out.println("[" + Thread.currentThread().getName() + "] Sleeping indefinitely...");
			Thread.sleep(Long.MAX_VALUE);
		} catch (InterruptedException e) {
			System.out.println("[" + Thread.currentThread().getName() + "] Interrupted by exception!");
		}
	}
}
