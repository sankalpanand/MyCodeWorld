import java.util.*;

public class ArraysUnion 
{
	public static void main(String[] args) 
	{
		int nums1[] = {1,2,3,4,5,6};
		int nums2[] = {5,6,7,8,9};
		ArrayList<Integer> res = printIntersection(nums1, nums2);
		System.out.println(res);
	}

	// Pre-req = Arrays should be sorted
	public static ArrayList<Integer> printIntersection(int nums1[], int nums2[])
	{
		int m = nums1.length;
		int n = nums2.length;
		int i = 0, j = 0;
		ArrayList<Integer> common = new ArrayList<Integer>();
		
		while (i < m && j < n)
		{
			if (nums1[i] < nums2[j])
				i++;
			
			else if (nums1[i] > nums2[j])
				j++;
			
			else /* if arr1[i] == arr2[j] */
			{
				common.add(nums2[j++]);
				i++;
			}
		}
		
		return common;
	}

}
