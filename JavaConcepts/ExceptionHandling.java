class Test extends Exception { }
class Base extends Exception {}
class Derived extends Base  {}

public class ExceptionHandling {

	public static void main(String args[]) { 
		Example1();
		Example2();
	}

	public static void Example1()
	{
		try {
			throw new Test();
		}
		catch(Test t) {
			System.out.println("Got the Test Exception");
		}
		finally {
			System.out.println("Inside finally block ");
		}
	}

	// Base class exception must always be caught after the child
	public static void Example2()
	{
		try {
			// Some monitored code
			throw new Derived();
		}
		catch(Base b)     { 
			System.out.println("Caught base class exception"); 
		}
		/*catch(Derived d)  { 
			System.out.println("Caught derived class exception"); 
		}*/
	}

}
