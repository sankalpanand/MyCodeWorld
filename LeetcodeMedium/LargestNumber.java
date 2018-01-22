package LeetcodeMedium;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3, 30, 34, 5, 9};
		System.out.println(largestNumber(nums));

	}

	public static String largestNumber(int[] nums) {

		/*
        Be Notice about the edge case:
        Input: [0, 0]
        Expeceted Output: 0
		 */

		/*
        nums = {3, 30, 34, 5, 9}
        Sorted as integers = {3,5,9,30,34}
        Sorted as string = {3,30,34,5,9}
        We are getting 43033 after 95
        However, if we take the first 3 first, we can get 43303 which is > 43033.
        Therefore, needed = {30,3,34,5,9}
        So, we need to implement our own comparator. 
		 */

		// Check the base case
		if(nums == null || nums.length == 0) return null;

		// Convert nums from integer to string
		int len = nums.length;
		String[] strNums = new String[len];
		for(int i=0; i<len; i++)
		{
			strNums[i] = nums[i] + ""; 
		}


		// Implement comparator
		Comparator<String> comp = new Comparator<String>()
		{
			@Override
			public int compare(String s1, String s2)
			{
				String str1 = s1 + s2;
				String str2 = s2 + s1;
				return str1.compareTo(str2);
			}
		};

		// Sort the array as per the new comparator
		Arrays.sort(strNums, comp);

		// Remember the base case that we talked above? Check if the largest number starts with cero?
		// If your input is 0,0, you will return 00. But you should return just 0.
		if(strNums[len-1].charAt(0)=='0')
			return "0";

		// Build string from the end
		StringBuilder sb = new StringBuilder();
		for(int i = len -1; i >= 0; i--)
		{
			sb.append(strNums[i]);
		}

		return sb.toString();
	}

}
