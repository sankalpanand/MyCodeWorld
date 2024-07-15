package Leetcode.Medium;

import java.util.Arrays;
import java.util.Comparator;

public class Q179LargestNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,0};
		System.out.println(largestNumber(nums));

	}

	// Neetcode - https://www.youtube.com/watch?v=WDx6Y4i4xJ8
	// Leetcode - https://leetcode.com/problems/largest-number/

	public static String largestNumber(int[] nums) {

		// Check the base case
		if(nums == null || nums.length == 0)
		    return null;

		// Convert int array to String array, so we can sort later on
		String[] strNums = new String[nums.length];
		for(int i=0; i<nums.length; i++) {
			strNums[i] = String.valueOf(nums[i]);
		}

		// Sort the array as per the new comparator
		Arrays.sort(strNums, (s1, s2) -> {
			String str1 = s1 + s2;
			String str2 = s2 + s1;
			return str1.compareTo(str2);
		});

		// The following case is needed for the input [0,0]
		// Even after the sorting, if the last element starts with 0, then we need to return 0
		if(strNums[nums.length-1].charAt(0)=='0')
			return "0";

		// Build string from the end
		StringBuilder sb = new StringBuilder();
		for(int i = nums.length - 1; i >= 0; i--) {
			sb.append(strNums[i]);
		}

		return sb.toString();
	}

}
