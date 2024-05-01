
public class StaticVariable {
	
	static int a;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StaticVariable obj1 = new StaticVariable(1);
		StaticVariable obj2 = new StaticVariable(2);
		
		obj1.a = 100; 
		
		System.out.println(obj2.a);

	}
	
	public StaticVariable(int a) 
	{
		this.a = a;
	}

}
