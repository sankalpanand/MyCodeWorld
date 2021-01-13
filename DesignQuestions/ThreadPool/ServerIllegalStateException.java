package ThreadPool;

/** This is a custom runtime exception which is triggered when Server is not accepting jobs */
public class ServerIllegalStateException extends RuntimeException 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ServerIllegalStateException() 
	{
		super("Queue isServerClosed.");
	}
}