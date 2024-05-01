import java.util.*;

public class ArraysIntersectionUnsorted 
{
	public static void main(String[] args) 
	{
		int nums1[] = {1,2,3,4,5,6};
		int nums2[] = {5,6,7,8,9};
		ArrayList<Integer> res = printIntersectionSorted(nums1, nums2);
		System.out.println(res);
	}

	
	// Prints intersection of arr1[0..m-1] and arr2[0..n-1]
	public static ArrayList<Integer> printIntersectionSorted(int arr1[], int arr2[])
	{
		int m = arr1.length;
		int n = arr2.length;
		ArrayList<Integer> intersection = new ArrayList<Integer>();
		
		// Before finding union, make sure arr1[0..m-1] is smaller
	    if (m > n)
	    {
	        return printIntersectionSorted(arr2, arr1);
	    }
	 
	    // Now arr1[] is smaller
	 
	    // mergeSort the first array and print its elements (these two
	    // steps can be swapped as order in output is not important)
	    Arrays.sort(arr1);
	 
	    // Search every element of bigger array in smaller array
	    // and print the element if found
	    for (int i=0; i<n; i++)
	        if (exists(arr1, 0, m-1, arr2[i]))
	        	intersection.add(arr2[i]);
	    
	    return intersection;
	}
	
	public static boolean exists(int[] nums, int start, int end, int target)
	{
		if(start>end)
			return false;
		
		int mid = (start + end)/2;
		if(nums[mid] == target)
			return true;
		else if(nums[mid] > target)
			return exists(nums, start, mid-1, target);
		else
			return exists(nums, mid+1, end, target);
	}

}
