package SortingImpl;

public class BubbleSort {

	public static void main(String[] args) 
	{
		// create an int array we want to sort using bubble sort algorithm
		int nums[] = new int[] {5, 90, 35, 45, 150, 3};

		// print array before sorting using bubble sort algorithm
		System.out.println("Array Before Bubble mergeSort");
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}

		// sort an array using bubble sort algorithm
		bubbleSort(nums);

		System.out.println("");

		// print array after sorting using bubble sort algorithm
		System.out.println("Array After Bubble mergeSort");
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}

	// n || n^2 || n^2
	private static void bubbleSort(int[] nums) {
		int n = nums.length;

		for (int i = 0; i < n; i++) { // Outer for loop isn't tracking a pointer. It's just that this process of passes will occur n times.

			// Sweeping will start from index 1
			// With every sweep, the largest element will move towards the end. So j need not go till n.
			for (int j = 1; j < (n - i); j++) {
				// If the item to the left is larger, swap it to the right
				if (nums[j - 1] > nums[j]) {
					// swap the elements!
					nums[j] = nums[j] + nums[j-1];
					nums[j-1] = nums[j] - nums[j-1];
					nums[j] = nums[j] - nums[j-1];
				}
			}
		}
	}
	
	public static void swap(int a, int b) {
		a = a + b;
		b = a - b;
		a = a - b;		
	}

}
