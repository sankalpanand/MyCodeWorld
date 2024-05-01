import java.util.*;

public class ArraysUnionUnsorted 
{
	public static void main(String[] args) 
	{
		int nums1[] = {1,2,3,4,5,6};
		int nums2[] = {5,6,7,8,9};
		ArrayList<Integer> res = printUnionUnsorted(nums1, nums2);
		System.out.println(res);
	}

	// Pre-req = Arrays should be sorted
	public static ArrayList<Integer> printUnionUnsorted(int arr1[], int arr2[])
	{
		int m = arr1.length;
		int n = arr2.length;
		ArrayList<Integer> union = new ArrayList<Integer>();
		
		// Before finding union, make sure arr1[0..m-1] is smaller
	    if (m > n)
	    {
	        return printUnionUnsorted(arr2, arr1);
	    }
	 
	    // Now arr1[] is smaller
	 
	    // mergeSort the first array and print its elements (these two
	    // steps can be swapped as order in output is not important)
	    Arrays.sort(arr1);
	    for (int i=0; i<m; i++)
	    	union.add(arr1[i]);
	 
	    // Search every element of bigger array in smaller array
	    // and print the element if not found
	    for (int i=0; i<n; i++)
	        if (! exists(arr1, 0, m-1, arr2[i]))
	        	union.add(arr2[i]);
	    
	    return union;
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
