
interface Vehicle
{
	int fuel = 100;
	public void BlowHorn();
	
}

class Car implements Vehicle
{
	public void BlowHorn()
	{
		System.out.println("BlowHorn from " + this.getClass());
	}
}


public class InterfacesDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car c = new Car();
		c.BlowHorn();

	}

}
