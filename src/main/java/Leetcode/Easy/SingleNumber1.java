package Leetcode.Easy;

public class SingleNumber1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/* Given an array of integers, every element appears twice except for one. Find that single one. */
	// Explanation- https://leetcode.com/discuss/6170/my-o-n-solution-using-xor?show=55172#a55172
	public int singleNumber(int[] nums) {

		int res = 0;
		for(int num : nums)
		{
			res = res ^ num;
		}

		return res;
	}



}
