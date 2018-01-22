package RadixSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RadixSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {7125, 21171, 120, 43589, 73641, 31975, 51455, 60433};	
		System.out.println(Arrays.toString(array));
		Sort1(array);
		System.out.println(Arrays.toString(array));

	}
	

	public static void Sort1(int[] array)
	{
		// Declare and initializes an empty bucket
		List<Integer>[] bucket = new ArrayList[10];
		
		for (int i = 0; i < bucket.length; i++) 
		{
			bucket[i] = new ArrayList<Integer>();
		}
		
		boolean maxLength = false; // Loop control variable
		int placement = 1; // Variable which decides which bit to take care of
		int tmp = -1; // Variable which will store the truncated number
		 
		
		while (!maxLength) 
		{
			maxLength = true;
			
			// This iterates over the array
			for (Integer i : array) 
			{
				// Here we keep dividing the integer by 1, 10, 100, and so on when proceed from one bit to another.
				tmp = i / placement;
				
				// It sends the integer to the corresponding bucket as per the current bit being operated on.
				bucket[tmp % 10].add(i);
				
				// If there are still digits left in atleast one number, the loop should continue
				if (maxLength && tmp > 0) 
				{
					maxLength = false;
				}
			}
			
			// This will be the index of the array while putting elements back to the array after every bit iteration
			int a = 0;
			
			// This for loop iterates over each bucket to store their numbers back in the array
			for (int b = 0; b < 10; b++) 
			{
				// This for loop iterates over each element in a bucket
				for (Integer i : bucket[b]) 
				{
					array[a] = i;
					a++;
				}
				
				bucket[b].clear();
			}
			// move to next digit
			placement *= 10;
		}
	}
}
