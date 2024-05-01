import java.util.Random;

public class RandomNumberInStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// http://www.geeksforgeeks.org/select-a-random-number-from-stream-with-o1-space/
	public static int selectRandom(int x)
	{
	    int res=-1;    // The resultant random number
	    int count = 0;  //Count of numbers visited so far in stream
	 
	    count++;  // increment count of numbers seen so far
	 
	    // If this is the first element from stream, return it
	    if (count == 1)
	        res = x;
	    else
	    {
	        // Generate a random number from 0 to count - 1
	    	Random rand = new Random();
	    	int randInt = rand.nextInt(count); 
	    		 
	        // If i is equal to 'count – 1', update the result as x.
	        if (randInt == count - 1)
	            res  = x;
	    }
	    return res;
	}

}
