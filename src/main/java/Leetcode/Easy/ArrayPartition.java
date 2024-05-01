package Leetcode.Easy;

import java.util.Arrays;

public class ArrayPartition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println(myAtoi("-2147483648"));

	}

	public int arrayPairSum(int[] nums) {
		Arrays.sort(nums);
		int sum = 0;
		for(int i=0; i<nums.length; i+=2) {
			sum = sum + nums[i];
		}
		return sum;
	}

}
