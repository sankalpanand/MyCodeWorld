package Threading;

import java.util.concurrent.*;

public class ThreadPoolCreation {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		Future<Integer>[] futures = new Future[5];
		
		for (int i = 0; i < futures.length; i++) {
			// futures[i] = executorService.submit(new MyCallable());
		}
		for (int i = 0; i < futures.length; i++) {
			Integer retVal = futures[i].get();
			System.out.println(retVal);
		}
		executorService.shutdown();
	}
}
