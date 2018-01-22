package Threading;

public class NoSynchronization 
{
	public static void main(String args[]) 
	{
		ATM PD = new ATM();

		UserProcess user1 = new UserProcess("Thread - 1 ", PD);
		UserProcess user2 = new UserProcess("Thread - 2 ", PD);

		user1.start();
		user2.start();
		
		// wait for threads to end
		try {
			user1.join();
			user2.join();
		} catch (Exception e) {
			System.out.println("Interrupted");
		}
	}
}

class ATM {
	
	int cash = 100;

	public void debit(String name)
	{
		cash--;
		System.out.println(name + " Debiting Cash. Available- " + cash);
	}
	
	public void credit(String name)
	{
		cash++;
		System.out.println(name + " Crediting Cash. Available- " + cash);
	}
}

class UserProcess extends Thread {
	private Thread t;
	private String threadName;
	ATM PD;

	UserProcess(String name, ATM pd) {
		threadName = name;
		PD = pd;
	}

	public void run() {
		
		// Unsysnchronized
		/*for (int i = 0; i < 5; i++) {
			PD.debit(this.threadName);
		}
		for (int i = 0; i < 5; i++) {
			PD.credit(this.threadName);
		}*/

		// Synchronized - This will allow Thread 1 to run first, then only thread 2
		synchronized(PD)
		{
			for (int i = 0; i < 5; i++) {
				PD.debit(this.threadName);
			}
			for (int i = 0; i < 5; i++) {
				PD.credit(this.threadName);
			}
		}
	}
	
	public void start() {
		System.out.println("Starting " + threadName);
		if (t == null) {
			t = new Thread(this, threadName);
			t.start();
		}
	}
}
