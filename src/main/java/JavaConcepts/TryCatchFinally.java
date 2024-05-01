
public class TryCatchFinally {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    Integer a = 100, b = 100;
	    System.out.println(a == b);
	    Integer c = 200, d = 200;
	    System.out.println(c == d);
	    
		test();

	}
	
	public static void test()
	{
		try
		{
			System.out.println("Inside try...");
			
			// Case 1- Finally wont execute
			System.exit(0);
			
			// Case 2- Finally would execute
			return;
		}
		catch(Exception e)
		{
			System.out.println("Inside catch...");
		}
		finally
		{
			System.out.println("Inside finally...");
		}
	}

}


