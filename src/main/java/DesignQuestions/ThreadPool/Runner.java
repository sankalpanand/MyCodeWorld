package ThreadPool;

public class Runner {

	public static void main(String[] args) {
		
		ThreadPool pool = new ThreadPool(10);
		pool.start();
		
		for(int i=0; i<10; i++)
		{
			pool.submitJob(new VideoChat());
		}
		
		for(int i=0; i<10; i++)
		{
			pool.submitJob(new OnlineShopping());
		}
		
		for(int i=0; i<10; i++)
		{
			pool.submitJob(new Spotify());
		}
	}
	
	static class VideoChat implements Runnable
	{
		public void run()
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + ": " +  "I am doing video chat");
		}		
	}
	
	static class OnlineShopping implements Runnable
	{
		public void run()
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + ": " +  "I am doing Online Shopping");
		}		
	}
	
	static class Spotify implements Runnable
	{
		public void run()
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + ": " +  "I am listening Spotify");
		}		
	}

}
