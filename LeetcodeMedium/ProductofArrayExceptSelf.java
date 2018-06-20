package LeetcodeMedium;

import java.util.Arrays;

public class ProductofArrayExceptSelf {

	// http://stackoverflow.com/questions/2680548/given-an-array-of-numbers-return-array-of-products-of-all-other-numbers-no-div
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] nums = {2, 3, 4, 5};
        System.out.println(Arrays.toString(productExceptSelf3(nums)));

	}
	
	public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] array1 = new int[length];
        int[] array2 = new int[length];
        
        array1[0] = 1;
        array2[length - 1] = 1;
        
        for(int i=1; i < length; i++)
        {
            array1[i] = array1[i-1] * nums[i-1];
            // array2[n-1-i] = array2[n-i]*nums[n-i];
        }
       
        for(int i=length - 2; i >= 0; i--)
        {
            array2[i] = array2[i+1] * nums[i+1];
        }

        int[] result = new int[length];
        for(int i=0; i < length; i++)
        {
            nums[i] = array1[i] * array2[i];
        }
        
        return nums;
    }

    public static int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        // Calculate lefts and store in res.
        int left = 1;
        for (int i = 0; i < n; i++) {
            if (i > 0)
                left = left * nums[i - 1];
            res[i] = left;
        }

        // Calculate rights and the product from the end of the array.
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1)
                right = right * nums[i + 1];
            res[i] *= right;
        }

        return res;
    }

    // https://leetcode.com/problems/product-of-array-except-self/discuss/65632/my-solution-beats-100-java-solutions/136988?page=1
    public static int[] productExceptSelf3(int[] nums) {
        int leng = nums.length;
        int[] ret = new int[leng];

        if(leng == 0)
            return ret;

        int runningprefix = 1;
        for(int i = 0; i < leng; i++){
            ret[i] = runningprefix;
            runningprefix *= nums[i];
        }

        int runningsufix = 1;
        for(int i = leng -1; i >= 0; i--){
            ret[i] *= runningsufix;
            runningsufix *= nums[i];
        }
        return ret;

    }

}
