import java.util.*;
import java.util.Map.Entry;

abstract class Vehicle1
{
	int fuel = 100;
	public abstract void BlowHorn();

}

class Car1 extends Vehicle1
{
	public void BlowHorn()
	{
		System.out.println("BlowHorn from " + this.getClass());
	}
}

// Abstract class can also have all implemented methods and 0 unimplemented ones.
abstract class Bike
{
	public void BlowHorn()
	{
		System.out.println("BlowHorn from " + this.getClass());
	}
}



public class AbstractDemo {

	public static void main(String[] args) 
	{
		Car1 c = new Car1();
		c.BlowHorn();

		


	}

}
