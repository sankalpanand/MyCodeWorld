
public class OutputInheritance {

	public static void method(String str)
	{
		System.out.println("String called");
	}
	
	// Error
	/*public static void method(Integer str)
	{
		System.out.println("Integer called");
	}*/
	
	public static void method(Object obj)
	{
		System.out.println("Object called");
	}
	
	// Error
	/*public static void method(Exception e)
	{
		System.out.println("Exception called");
	}*/
	
	// Error
	/*public static void method(ArithmeticException e)
	{
		System.out.println("Exception called");
	}*/
	
	
	
	public static void main(String[] args) 
	{
		method(null);
	}
}
