package hard;

public class MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Case 1 - B[j-1] > A[i]
		int[] A = {2,13,17,30,45};
		int[] B = {1,12,15,26,38,48,52};		
		// System.out.println(findMedianSortedArrays(A, B));
		
		int[] E = {1};
		int[] F = {2,3};
		System.out.println(findMedianSortedArrays(E, F));

		int[] nums3 = {2, 50, 60, 70, 80};
		int[] nums4 = {1,12,15,26,38,48,52};		
		System.out.println(findMedianSortedArrays(nums3, nums4));
	}


	public static double findMedianSortedArrays(int[] A, int[] B) 
	{
		int m = A.length, n = B.length;
		
		// Get the medians. 
		// In case m+n is odd, both l and r will give the same values.
		// But when m+n is even, m+n will give us two different indices (i,i+1) which we will average
		int l = (m + n + 1) / 2;
		int r = (m + n + 2) / 2;

		return (getkth(A, 0, B, 0, l) + getkth(A, 0, B, 0, r)) / 2.0;
	}

	
	/**
	  	Step 1- Calculate midA and midB
		Step 2- Find out the smaller mid
		Step 3- Start of only the array with a smaller mid will change. It will move to next. 
				Start of the array with larger mid will remain unchanged.
	 */
	public static double getkth(int[] A, int aStart, int[] B, int bStart, int k) 
	{
		// Base Case 1- If A is finished, get k'th element from B
		if (aStart > A.length - 1) 
			return B[bStart + k - 1];    
		
		// Base Case 2- If B is finished, get k'th element from A
		if (bStart > B.length - 1) 
			return A[aStart + k - 1];
		
		// Base Case 3- If you are to extract first element, take the minimuum of the two starting elements
		if (k == 1) 
			return Math.min(A[aStart], B[bStart]);

		int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
		
		// Calculate both the mid elements
		if (aStart + k/2 - 1 < A.length) 
			aMid = A[aStart + k/2 - 1]; 
		
		if (bStart + k/2 - 1 < B.length) 
			bMid = B[bStart + k/2 - 1];        

		// REAL PART: Here you test the above logic and pass on the recursive call
		if (aMid < bMid) 
			return getkth(A, aStart + k/2, B, bStart, k - k/2);
		else 
			return getkth(A, aStart, B, bStart + k/2, k - k/2);
	}
	




	/* O (Log (Min(m,n)))
	 * https://leetcode.com/discuss/15790/share-my-o-log-min-m-n-solution-with-explanation
	 * In this question, we move our indices on smaller array. 
	 * We compute some possible partition index for both the arrays and check the corner four values against each other.
	 * For every comparison, we discard the left part or right part to the pIndex of the smaller array. 
	 * Thus we get O(log(Min (M,N))) complexity.
	 * When we get such a partition where all the elements on the left side are larger than the right side, we get our indexes.
	 * */
	public static double findMedianSortedArrays2(int[] A, int[] B) 
	{
		int m = A.length;
		int n = B.length;


		// First array always has to be smaller
		if (m > n) 
			return findMedianSortedArrays2(B, A);

		// We will keep track of index in larger array only
		int minSmallerArray = 0; 
		int maxSmallerArray = m; 

		int i=0; 
		int j=0;

		int num1=0; 
		int midCombined = (m + n + 1) / 2; 
		int num2=0;

		while (minSmallerArray <= maxSmallerArray)
		{
			i = (minSmallerArray + maxSmallerArray) / 2;
			j = midCombined - i;

			// If B(last of first half) > A(first of second half), then the object "ix" can't be in the left part [0, i0]
			if (i<m && j>0 && B[j-1] > A[i]) 
				minSmallerArray = i + 1; // Discard the left part and continue searching in [i + 1, maxSmallerArray]

			// If A(last of first half) > B(first of second half), then the object "ix" can't be in the right part [i0, m].
			else if (i>0 && j<n && B[j] < A[i-1]) 
				maxSmallerArray = i - 1; // Discard the right part and continue searching in [minSmallerArray, i - 1]

			// Bingo! This is our object "i"
			else
			{
				if (i == 0) 
					num1 = B[j-1];

				else if (j == 0) 
					num1 = A[i-1];

				else 
					num1 = Math.max(A[i-1], B[j-1]);

				break;
			}
		} // Object is found



		// When m+n is odd-
		if (((m + n) % 2) == 1) 
			return num1;

		// Find out the median-
		if (i == m) 
			num2 = B[j];

		else if (j == n) 
			num2 = A[i];

		else 
			num2 = Math.min(A[i],B[j]);

		return (num1 + num2) / 2.;
	}

}
