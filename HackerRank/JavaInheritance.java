
public class JavaInheritance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Adder X=new Adder();
		System.out.println("My superclass is: "+X.getClass().getSuperclass().getName());	
		System.out.print(X.add(10,32)+" "+X.add(10,3)+" "+X.add(10,10)+"\n");

	}

}

abstract class Arithmetic
{
	abstract int add(int a, int b);
	
}

class Adder extends Arithmetic
{
	public int add(int a, int b)
	{
		return a+b;
	}
}
