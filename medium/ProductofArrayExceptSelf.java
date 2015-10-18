package medium;

public class ProductofArrayExceptSelf {

	// http://stackoverflow.com/questions/2680548/given-an-array-of-numbers-return-array-of-products-of-all-other-numbers-no-div
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

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

}
