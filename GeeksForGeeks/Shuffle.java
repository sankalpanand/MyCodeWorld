import java.util.Arrays;
import java.util.Random;

public class Shuffle {

	public static void main(String[] args) 
	{
		int[] arr = {1,2,3,4,5};
	    System.out.println(Arrays.toString(shuffle(arr)));

	}
	
	public static int[] shuffle(int[] arr)
	{
		int n = arr.length;
		
		// Use a different seed value so that we don't get same
	    // result each time we run this program
		Random rand = new Random();
	 
	    // Start from the last element and swap one by one. We don't
	    // need to run for the first element that's why i > 0
	    for (int i = n-1; i >= 0; i--)
	    {
	        // Pick a random getCellIndex from 0 to i
	        int j = rand.nextInt(i+1);
	 
	        int temp = arr[i];
	        arr[i] = arr[j];
	        arr[j] = temp;
	    }
	    
	    return arr;
	}
	

}
