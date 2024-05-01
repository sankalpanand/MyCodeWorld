
public class RandomNumber 
{

	// George Marsaglia's XORShift Random Number Generators
	
	public static void main(String[] args) 
	{
		RandomNumber obj = new RandomNumber();
		
		for(int i=0; i<10; i++)
		{
			System.out.println(obj.randomLong(100));
		}
	}
	
	long seed;	
	public RandomNumber()
	{
		this.seed = System.currentTimeMillis();
	}
	
	// http://www.javamex.com/tutorials/random_numbers/xorshift.shtml
	public int randomLong(int max) 
	{		
		seed ^= (seed << 21);
		seed ^= (seed >>> 35);
		seed ^= (seed << 4);
		int out = (int) seed % max;   
		return (out < 0) ? -out : out;
	}

}
