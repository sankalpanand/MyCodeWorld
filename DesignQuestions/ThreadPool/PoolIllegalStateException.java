package ThreadPool;

public class PoolIllegalStateException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	PoolIllegalStateException() 
	{
		super("Thread pool not in valid state.");
	}
}