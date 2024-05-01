
public class Output1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s1 = "abc";
		String s2 = "def";
		String s3 = s1.concat(s2.toUpperCase());
		// System.out.println(s1+s2+s3);
		// add(5);
		
		boolean a = false;
		if(a == true)
			System.out.println("Hello");
		
		else
			System.out.println("Goodbye");

	}
	
	public static void add(int a)
	{
		loop: for(int i=1; i<3; i++)
		{
			for(int j=1; j<3; j++)
			{
				if(a==5)
					break loop;
				
				System.out.println(i * j);
			}
		}
	}

}
