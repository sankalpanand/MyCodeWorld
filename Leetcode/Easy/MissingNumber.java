package Leetcode.Easy;

public class MissingNumber {

	// http://www.geeksforgeeks.org/find-the-missing-number/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0,1,2,4};
		System.out.println(missingNumber(nums));

	}
	
	public static int missingNumber(int[] nums) {
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
    public static int missingNumber1(int[] nums) 
    {
        int xor1 = 0;
        for(int num : nums)
        {
            xor1 = xor1 ^ num;
        }
        
        int xor2 = 0;
        for(int i=0; i <= nums.length; i++)
        {
            xor2 = xor2 ^ i;
        }
        
        return xor1 ^ xor2;
        
    }

}
