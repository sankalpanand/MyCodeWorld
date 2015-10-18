package hard;

public class MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {100000};
		int[] nums2 = {100001};

		System.out.println(findMedianSortedArrays(nums1, nums2));
	}

	/*
	 * 	If n is odd then the median is x[(n-1)/2].
		If n is even than the median is ( x[n/2] + x[(n/2)-1] ) / 2.
	 * */

	public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
		int[] combined = merge(nums1, nums2);
		double mid = -1;

		if(combined.length % 2 != 0) 
			mid =  combined[(combined.length - 1)/2];
		else
			mid =  (double)(combined[combined.length/2] + combined[(combined.length/2) - 1])/2;


		return mid;
	}

	public static int[] merge(int[] nums1, int[] nums2)
	{
		// If any array is null, return the other one
		if(nums1.length == 0) return nums2;
		else if(nums2.length == 0) return nums1;

		// Compute lengths
		int len1 = nums1.length - 1;
		int len2 = nums2.length - 1;
		int totalLen = nums1.length + nums2.length - 1;

		// Create an array to merge both of them
		int[] combined = new int[nums1.length + nums2.length];

		// Iterate elements until one of it becomes empty
		while(len1 >= 0 && len2 >= 0)
		{
			if(nums1[len1] >= nums2[len2])
			{
				combined[totalLen--] = nums1[len1--];
			}
			else
			{
				combined[totalLen--] = nums2[len2--];
			}
		}

		// If 2nd is remaining, fill its elements
		while(len2 >= 0)
		{
			combined[totalLen--] = nums2[len2--];
		}

		// If 1st is remaining, fill its elements
		while(len1 >= 0)
		{
			combined[totalLen--] = nums1[len1--];
		}

		return combined;

	}

	// O (log(Min(1, 2))) solution
	// https://leetcode.com/discuss/41621/very-concise-iterative-solution-with-detailed-explanation	
	public static double findMedianSortedArrays2(int[] nums1, int[] nums2) 
	{
		int len1 = nums1.length;
		int len2 = nums2.length;

		// Make sure A2 is the shorter one.
		if (len1 < len2) 
			return findMedianSortedArrays(nums2, nums1);   

		// If A2 is empty, return the median from A1 normally
		if (len2 == 0) 
			return ((double)nums1[(len1 - 1)/2] + (double)nums1[len1 / 2])/2;  

		/************* The main code starts here *****************/
		
		int lo = 0, hi = len2 * 2;

		while (lo <= hi) 
		{
			// when we cut at position C2 = K in A2
			int mid2 = (lo + hi) / 2;  
			
			// then the cut position in A1 must be C1 = N1 + N2 - k
			int mid1 = len1 + len2 - mid2;  // Calculate Cut 1 accordingly

			// Cuts are made in both the arrays, now we have two Ls and 2 Rs
			double L1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[(mid1-1)/2]; 
			double L2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[(mid2-1)/2];
			double R1 = (mid1 == len1 * 2) ? Integer.MAX_VALUE : nums1[(mid1)/2];
			double R2 = (mid2 == len2 * 2) ? Integer.MAX_VALUE : nums2[(mid2)/2];

			
			// A1's lower half is too big; need to move C1 left (C2 right)
			if (L1 > R2) 
				lo = mid2 + 1;     
			
			// A2's lower half too big; need to move C2 left.
			else if (L2 > R1) 
				hi = mid2 - 1;
			
			// Otherwise, that's the right cut.
			else 
				return (Math.max(L1,L2) + Math.min(R1, R2)) / 2; 
		}

		return -1;   
	}

	// https://leetcode.com/discuss/11174/share-my-iterative-solution-with-o-log-min-n-m
	// http://www2.myoops.org/course_material/mit/NR/rdonlyres/Electrical-Engineering-and-Computer-Science/6-046JFall-2005/30C68118-E436-4FE3-8C79-6BAFBB07D935/0/ps9sol.pdf
	public static double findMedianSortedArrays(int A[], int B[]) 
	{
		int lenA = A.length;
		int lenB = B.length;

		// The first should be smaller always.
		if (lenA > lenB)
			return findMedianSortedArrays(B, A);

		// now, do binary search
		int midCombined = (lenA + lenB - 1) / 2;
		int l = 0; 
		int r = Math.min(midCombined, lenA); // r is lenA, NOT lenA-1, this is important!!

		while (l < r) 
		{
			int midA = (l + r) / 2;
			int midB = midCombined - midA;
			if (A[midA] < B[midB])
				l = midA + 1;
			else
				r = midA;
		}

		// after binary search, we almost get the median because it must be between
		// these 4 numbers: A[l-1], A[l], B[k-l], and B[k-l+1] 

		// if (lenA+lenB) is odd, the median is the larger one between A[l-1] and B[k-l].
		// and there are some corner cases we need to take care of.
		int aA = l > 0 ? A[l - 1] : Integer.MIN_VALUE;
		int bB = midCombined - l >= 0 ? B[midCombined - l] : Integer.MIN_VALUE;		
		int a = Math.max(aA, bB);
		
		if (((lenA + lenB) % 2) == 1)
			return (double) a;

		// if (lenA+lenB) is even, the median can be calculated by median = (max(A[l-1], B[k-l]) + min(A[l], B[k-l+1]) / 2.0
		// also, there are some corner cases to take care of.
		aA = l < lenA ? A[l] : Integer.MAX_VALUE;
		bB = midCombined - l + 1 < lenB ? B[midCombined - l + 1] : Integer.MAX_VALUE;
		int b = Math.min(aA, bB);
		return (a + b) / 2.0;
	}
	
	


	

}
