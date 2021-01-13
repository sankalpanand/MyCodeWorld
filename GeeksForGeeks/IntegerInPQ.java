
public class IntegerInPQ {

	public static void main(String[] args) 
	{
		int z = (int) Math.pow(5, 5);
		System.out.println(z);
		// z--;
		// z = 40353607;
		System.out.println(superPower(z));

	}
	
	public static int superPower(int z)
	{
		int result = 0;
		
		// If the number is even, then any odd number can not be its factor, so we can skip them.
		int begin = z%2==0 ? 2 : 3;
		
		for(int p=begin; p<Math.sqrt(z); p = p+2)
		{
			if(z%p != 0)
				continue;
			
			int temp = p;
			
			while(temp < z)
			{
				 temp = temp * p;
			}
			
			if(temp == z)
			{
				return 1;				
			}				
		}
		return result;
	}
}
