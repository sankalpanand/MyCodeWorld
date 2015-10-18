package medium;

public class SearchInsertPosition {

	// Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

	// It only works because the input starts from zero - Sum of n elements - sumArray
	public int missingNumber(int[] nums) 
	{
		int sum = 0;
		for(int num: nums)
			sum += num;

		return (nums.length * (nums.length + 1) )/ 2 - sum;
	}

	// Bit manipulation
	/*
    Let's say A = {0,1,2,4}
    XOR1 = {0^1^2^4}
    XOR2 = {0^1^2^3^4}
    XOR1^XOR2 = 3
	 */
	public int missingNumber1(int[] nums) 
	{
		int xor1 = 0;
		for(int num : nums)
		{
			xor1 = xor1 ^ num;
		}

		int xor2 = 0;
		for(int i=1; i <= nums.length; i++)
		{
			xor2 = xor2 ^ i;
		}

		return xor1 ^ xor2;

	}

}
