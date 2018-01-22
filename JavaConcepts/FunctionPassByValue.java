
public class FunctionPassByValue {

	public static void main(String[] args) 
	{
		passByValue();
		passByRef();
	}

	// Variables are always passed by value
	public static void passByValue()
	{
		Integer i = new Integer(10);
		Integer j = new Integer(20);
		swap(i, j);
		System.out.println("i = " + i + ", j = " + j);
	}

	// Objects are always passed by reference
	public static void passByRef()
	{
		intWrap i = new intWrap();
		i.x = 10;
		intWrap j = new intWrap();
		j.x = 20;
		swap(i, j);
		System.out.println("i.x = " + i.x + ", j.x = " + j.x);
	}

	public static void swap(Integer i, Integer j)
	{
		Integer temp = new Integer(i);
		i = j;
		j = temp;
	}

	public static void swap(intWrap i, intWrap j)
	{
		int temp = i.x;
		i.x = j.x;
		j.x = temp;
	}

	static class intWrap 
	{
		int x;
	} 

}
