import java.util.*;

public class ArraysIntersection 
{
	public static void main(String[] args) 
	{
		int nums1[] = {1,2,3,4,5,6};
		int nums2[] = {5,6,7,8,9};
		ArrayList<Integer> res = printUnion(nums1, nums2);
		System.out.println(res);
	}

	// Pre-req = Arrays should be sorted
	public static ArrayList<Integer> printUnion(int nums1[], int nums2[])
	{
		int m = nums1.length;
		int n = nums2.length;
		int i = 0, j = 0;
		ArrayList<Integer> union = new ArrayList<Integer>();
		
		while (i < m && j < n)
		{
			// First array element smaller. Increase only i
			if (nums1[i] < nums2[j])
				union.add(nums1[i++]);
				
			// Second array element smaller. Increase only j
			else if (nums1[i] > nums2[j])
				union.add(nums2[j++]); 
			
			// Both equal, increase both i and j.
			else
			{
				union.add(nums2[j++]);
				i++;
			}
		}

		/* Print remaining elements of the larger array */
		while(i < m)
			union.add(nums1[i++]);
		
		while(j < n)
			union.add(nums2[j++]);
		
		return union;
	}

}
