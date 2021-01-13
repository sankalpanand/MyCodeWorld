
public class FindDuplicatesInO1 {

	// http://www.geeksforgeeks.org/find-duplicates-in-on-time-and-constant-extra-space/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 2, 3, 1, 3, 6, 6};
		printRepeating(arr);
		

	}

	static void printRepeating(int arr[]) 
	{
		int size = arr.length;
		int i;
		System.out.println("The repeating elements are: \n");
		for (i = 0; i < size; i++) 
		{
			if (arr[Math.abs(arr[i])] >= 0)
				arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
			
			else
				System.out.println(Math.abs(arr[i]));
		}
	}

}
