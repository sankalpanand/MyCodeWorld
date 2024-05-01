package DesignQuestions.Inheritence.package1;

public class Parent 
{
	
	private int a;
	
	public Parent()
	{
		System.out.println("Inside parent default");
	}
	
	public Parent(int a)
	{
		System.out.println("Inside parent parameterized");
	}
	
	public Integer privatePrint()
	{
		System.out.println("Inside Parent, privatePrint()");
		return 0;
	}
	
	final void finalPrint()
	{
		System.out.println("Inside Parent, finalPrint()");
	}
	
	public void publicPrint()
	{
		System.out.println("Inside Parent, publicPrint()");
	}
	
	protected void protectedPrint()
	{
		System.out.println("Inside Parent, protectedPrint()");
	}
	
	void defaultPrint()
	{
		System.out.println("Inside Parent, defaultPrint()");
	}

	public static void main(String[] args) {
		// Test 2 - Is child method callable from parent object?
		Parent parent = new Parent();
		parent.privatePrint();
	}

}
