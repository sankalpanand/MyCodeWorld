package Templates;
import java.util.Random;

public class RandomBit {

	public static void main(String[] args) 
	{
		
	}
	
	public static void generatBinary()
	{
		Random rand = new Random();
		for(int i=0; i<5; i++)
		{
			System.out.println(rand.nextInt(2));
		}
	}

}
