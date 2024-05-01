package Threading;

public class DeadlockSolution {
	public static Object Lock1 = new Object();
	public static Object Lock2 = new Object();

	public static void main(String args[]) {
		ThreadDemo1 T1 = new ThreadDemo1();
		long id = Thread.currentThread().getId();
		String name = Thread.currentThread().getName();

		ThreadDemo2 T2 = new ThreadDemo2();
		id = Thread.currentThread().getId();
		name = Thread.currentThread().getName();
		System.out.println("id: " + id + " name: " + name);

		T1.start();
		T2.start();
	}

	private static class ThreadDemo1 extends Thread {
		public void run() {
			long id = Thread.currentThread().getId();
			String name = Thread.currentThread().getName();
			System.out.println("id: " + id + " name: " + name);

			synchronized (Lock1) {
				System.out.println("Thread 1: Holding lock 1...");
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
				}

				System.out.println("Thread 1: Waiting for lock 2...");

				// Ye tab tak andar nahi ja sakta jab tak Demo2 lock2() ke bahar
				// nahi aa jaata
				synchronized (Lock2) {
					System.out.println("Thread 1: Holding lock 1 & 2...");
				}
			}
		}
	}

	private static class ThreadDemo2 extends Thread {
		public void run() {
			long id = Thread.currentThread().getId();
			String name = Thread.currentThread().getName();
			System.out.println("id: " + id + " name: " + name);

			Thread.currentThread().setPriority(MAX_PRIORITY);
			Thread.currentThread().setPriority(MIN_PRIORITY);
			Thread.currentThread().setPriority(NORM_PRIORITY);

			synchronized (Lock1) {
				System.out.println("Thread 2: Holding lock 1...");
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
				}

				System.out.println("Thread 2: Waiting for lock 2...");
				synchronized (Lock2) {
					System.out.println("Thread 2: Holding lock 1 & 2...");
				}
			}
		}
	}
}
