package Leetcode.Medium;

import java.util.Arrays;
import java.util.HashSet;

public class SingleNumber3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Integer[] nums = {1403617094,-490450406,-1756388866,-967931676,1878401007,1878401007,-74743538,1403617094,-1756388866,-74743538,-490450406,-1895772685};
		int[] nums = {1,2,1,3,2,5};
		// List<Integer> list = Arrays.asList(nums);
		// Arrays.sort(nums);
		int[] res =  singleNumber(nums);
		System.out.println(Arrays.toString(res));
	}

	/* https://leetcode.com/problems/single-number-iii/description/
	   For explanation, read my comment here-
       https://leetcode.com/discuss/52913/my-java-solution-adapted-from-the-commonest-solution-here
    */
    public static int[] singleNumber(int[] nums) 
    {
        int xorRes = 0;
        
        for(int num : nums)
        {
            xorRes = xorRes ^ num;
        }
        
        // Till this point, we got XOR of the two unique numbers. So, there will be some bits set in the result.
        // For that set bit in the result, one number will have that place as 1 and the other number will have that place as 0.
        // We take the left most bit and make all other bits in the result as 0.
        xorRes = Integer.highestOneBit(xorRes);
        
        int[] result = {0, 0};
        
        // Now we will divide the numbers into two groups - One with that particular bit set and other with that particular bit not set.
        // This will divide our two numbers also in two groups.
        // Then simply apply Single Number I approach.
        for(int num : nums)
        {
            if((num & xorRes) == 0)
            {
                result[0] = result[0] ^ num;
            }
            else
            {
                result[1] = result[1] ^ num;
            }
        }
        
        return result;
        
    }
    
    // Using hash map
    public int[] singleNumber1(int[] nums) {
        int[] ans = new int[2];
        if(nums == null || nums.length <=1){
            return ans;
        }

        HashSet<Integer> record = new HashSet<Integer>();
        for(int i = 0;i<nums.length;i++){
            if(record.contains(nums[i])){
                record.remove(nums[i]);
            }
            else{
                record.add(nums[i]);
            }
        }
        
        Object[] test = record.toArray();
        ans[0]=(int)test[0];
        ans[1]=(int)test[1];
        return ans;
    }

}
