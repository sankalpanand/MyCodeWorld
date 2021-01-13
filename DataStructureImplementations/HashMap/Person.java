package HashMap;

public class Person 
{
	private String name;
	private int age;
	
	public Person(String n, int a) 
	{
		name = n;
		age = a;
	}
	
	@Override 
	public String toString() 
	{
		return "(" + name + ", " + age + ")";
	}
	
	public int getAge() 
	{
		return age;
	}
	
	public String getName() 
	{
		return name;
	}
}