
public class AbstractClass {
	public static void main(String[] args)
	{
		iPhone obj = new iPhone();
		// obj.recieveData();
	}
}

abstract class AbstractCar
{
	abstract boolean isIphone();
	int a = 1;

	public void charge() 
	{
		System.out.println("Charging Mobile Phone");
	}

	// Abstract classes can have constructors
	public AbstractCar()
	{
		System.out.println("Super constructor implicitely called.");
	}
}

class iPhone extends AbstractCar
{
	public boolean isIphone() { return true; }

	public iPhone()
	{		
		System.out.println("iPhone constructor called!");
		
		// Abstract parent variable can be read as well as written
		System.out.println(++a);
	}

	public void charge() 
	{
		System.out.println("Charging Mobile Phone");
	}


}