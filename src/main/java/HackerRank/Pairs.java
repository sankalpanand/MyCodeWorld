import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Pairs {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String line = in.nextLine().trim();

		int N = Integer.parseInt(line.split(" ")[0]);
		int k = Integer.parseInt(line.split(" ")[1]);

		line = in.nextLine().trim();
		String[] strNums = line.split(" ");
		int[] list = new int[strNums.length];

		for (int i = 0; i < strNums.length; i++) {
			list[i] = Integer.parseInt(strNums[i]);
		}

		Arrays.sort(list);

		System.out.println(count(list, k));

		in.close();

	}


	private static int count(int[] nums, int k) {
		int count = 0;

		// Anchor one element
		for (int i = 0; i < nums.length; i++) 
		{
			// Store the anchored element
			int a = nums[i];
			
			// Check the rest of the elements
			for (int j = i + 1; j < nums.length; j++) 
			{
				// Store the next integer in the inner series to check 
				int b = nums[j];

				// Since the array is sorted, check if a is less than b
				if (a < b) 
				{
					// If the diff equals k, increase the count
					if (Math.abs(a - b) == k)
						count++;

					// If the diff is more than k, break out of loop as further numbers will give more difference
					if (Math.abs(a - b) > k)
						break;
				} 
				
				else 
				{
					j = i;
				}
			}

		}

		return count;
	}

}
