package Threading;

public class Join {

	public static void main(String[] args) throws InterruptedException 
	{
		System.out.println(Thread.currentThread().getName() + " is Started");
	      
        Thread exampleThread = new Thread()
        {
            public void run()
            {
                try 
                {
                    System.out.println(Thread.currentThread().getName() + " is Started");
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName() + " is Completed");
                } 
                catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        };
      
        exampleThread.start();
        exampleThread.join();
      
        System.out.println(Thread.currentThread().getName() + " is Completed");
	}
}
