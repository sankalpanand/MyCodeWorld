
public class Interface {
	public static void main(String[] args)
	{
		SonyErricson obj = new SonyErricson();
		obj.recieveData();
	}
}

interface USB 
{
	// Interface variables are final by default.
	public int a = 1;
	
	// You can not leave them uninitialized
	// int fuel;
	int fuel = 1;
	
	// Interface methods can not have a body
	public void sendPower(); 
	public void sendData(); 
	
	// Only a static method can have a body
	public static void recieveData()
	{
		System.out.println("receiveData from Interface");
	}
	
	// Interfaces can not have constructors
//	public USB()
//	{
//		
//	}
}

class SonyErricson implements USB
{
	int fuel;

	public void sendPower()
	{
		System.out.println("sendPower from SonyErricson");
	}
	
	public void sendData()
	{
		System.out.println("sendData from SonyErricson");
	}
	
	public void recieveData1()
	{
		System.out.println("recieveData from SonyErricson");
	}
	
	public static void recieveData()
	{
		// Interface variables can be accessed in child class in two ways-
		System.out.println(USB.a);
		System.out.println(a);
		
		// Interface variables are final. You can not change them.
		// a++; // The final field USB.a cannot be assigned
		
		
		USB.recieveData();
		
		
		System.out.println("receiveData from Child Class");
	}
}
