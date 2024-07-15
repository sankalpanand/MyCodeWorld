package Leetcode.Medium;

import java.util.Arrays;

public class Q238ProductofArrayExceptSelf {


	public static void main(String[] args) {
        Q238ProductofArrayExceptSelf obj = new Q238ProductofArrayExceptSelf();
        int[] nums = {2, 3, 4, 5};
        System.out.println(Arrays.toString(obj.productExceptSelf(nums)));

	}

	// Neetcode - https://www.youtube.com/watch?v=bNvIQI2wAjk
    // Leetcode - https://leetcode.com/problems/product-of-array-except-self/description/
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        // Initialize the result array with 1s
        for (int i = 0; i < n; i++) {
            res[i] = 1;
        }



        // Calculate prefix products
        int prefix = 1;
        for (int i = 0; i < n; i++) {
            res[i] = prefix;
            prefix *= nums[i];
        }

        System.out.println(Arrays.toString(res));

        // Calculate postfix products and multiply with prefix products
        int postfix = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= postfix;
            postfix *= nums[i];
        }

        System.out.println(Arrays.toString(res));

        return res;
    }

}
