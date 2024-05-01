
public class MaximumDifference {

	public static void main(String[] args) {

		int arr[] = {2, 3, 10, 6, 4, 8, 1};
		int size = arr.length;
		System.out.println(maxDifference(arr));
	}

	
	
	static int maxDifference(int[] arr) {
		int maxDiff = arr[1] - arr[0];
		int minElement = arr[0];
		int i;
		
		for(i = 1; i < arr.length; i++)
		{       
			if (arr[i] - minElement > maxDiff)                               
				maxDiff = arr[i] - minElement;
			
			if (arr[i] < minElement)
				minElement = arr[i];                     
		}
		
		return maxDiff;

    }
	
	

}


