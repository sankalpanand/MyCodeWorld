package DesignQuestions.Inheritence.package1;

public class Child extends Parent {
	

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Child obj = new Child();
//		obj.print();
//
//		obj.privatePrint();
//
//		// Test 2 - Is child method callable from parent object?
//
//	}
	
	public Child()
	{
		super();		
	}
	
	public Integer privatePrint()
	{
		System.out.println("Inside child, privatePrint()");
		return 0;
	}
	
//	final void finalPrint()
//	{
//		System.out.println("Inside Parent, finalPrint()");
//	}
	
	public Child(int a)
	{
		System.out.println("");
//		super();
//		super(a);
	}
	
	public void print()
	{
		
//		super.protectedPrint();
//		super.publicPrint();
//		super.defaultPrint();
	}

}
