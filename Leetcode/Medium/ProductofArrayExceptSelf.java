package Leetcode.Medium;

import java.util.Arrays;

public class ProductofArrayExceptSelf {

	// http://stackoverflow.com/questions/2680548/given-an-array-of-numbers-return-array-of-products-of-all-other-numbers-no-div
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] nums = {2, 3, 4, 5};
        System.out.println(Arrays.toString(productExceptSelf(nums)));

	}

	// From comment here- https://leetcode.com/problems/product-of-array-except-self/discuss/65622/Simple-Java-solution-in-O(n)-without-extra-space
    // First iteration cumulates the 'left' result in the result array, and another iteration multiplies the 'right' elements into the result array. O(n) time and O(1) space!
    public static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];

        for (int i = 0; i < res.length; i++)
            res[i] = 1; // use 1 instead of 0 so it can be multipled


        int left = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] *= left;
            left *= nums[i];
        }

        int right = 1;
        for (int i = nums.length-1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }

        return res;
    }

    // From comment here- https://leetcode.com/problems/product-of-array-except-self/discuss/65627/O(n)-time-and-O(1)-space-C++-solution-with-explanation
    public int[] productExceptSelf_SinglePass(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, 1);
        int fromBegin = 1;
        int fromEnd = 1;

        for (int i = 0; i < nums.length; ++i) {

            res[i] *= fromBegin;
            fromBegin *= nums[i];

            res[nums.length - 1 - i] *= fromEnd;
            fromEnd *= nums[nums.length - 1 - i];
        }

        return res;
    }

}
