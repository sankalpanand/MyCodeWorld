package InsertionSort;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		// create an int array we want to sort using bubble sort algorithm
		int numss[] = new int[] { 5, 90, 35, 45, 150, 3 };

		// print array before sorting using bubble sort algorithm
		System.out.println("Array Before Bubble Sort");
		for (int i = 0; i < numss.length; i++) {
			System.out.print(numss[i] + " ");
		}

		// sort an array using bubble sort algorithm
		insertionSort(numss);

		System.out.println("");

		// print array after sorting using bubble sort algorithm
		System.out.println("Array After Bubble Sort");
		for (int i = 0; i < numss.length; i++) {
			System.out.print(numss[i] + " ");
		}
	}

	public static int[] insertionSort(int[] nums) 
	{
		for (int i = 1; i < nums.length; i++) 
		{
			int j = i;
			
			// Har baar i se pichhe chalo, agar koi aisa element milta hai jo pichhe se chhota hai, swap kar do
			while (j > 0 && nums[j] < nums[j - 1]) 
			{
				nums[j] = nums[j] + nums[j - 1];
				nums[j - 1] = nums[j] - nums[j - 1];
				nums[j] = nums[j] - nums[j - 1];

				j--;
			}
		}

		return nums;
	}

}
