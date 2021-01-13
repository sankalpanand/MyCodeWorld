package Leetcode.Medium;

public class MaximumProductSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {-2, 3, -4};
		System.out.println(maxProduct(nums));
	}

	// Kaden's Algo for maximum subarray can not work here because of the negatives.
	// Consider the case- [-2, 3, -4].
	// Kaden's algo gives -3 whereas the actual answer is 24
	public static int maxProduct(int[] A) {
		if (A == null || A.length == 0) 
		{
			return 0;
		}
		
		int max = A[0], min = A[0], result = A[0];
		for (int i = 1; i < A.length; i++) 
		{
			int temp = max;
			max = Math.max(Math.max(max * A[i], min * A[i]), A[i]);
			min = Math.min(Math.min(temp * A[i], min * A[i]), A[i]);
			if (max > result) {
				result = max;
			}
			System.out.println("temp: " + temp + "\t max: " + max + "\t min: " + min + "\tresult: " + result);
		}
		return result;

	}

}
