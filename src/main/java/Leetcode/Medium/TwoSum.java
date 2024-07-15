package Leetcode.Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {

		int[] nums = {2, 7, 11, 15};
		int[] res = twoSum(nums, 9);
		System.out.println(Arrays.toString(res));
	}

	/*
	2 Solutions- 
	1. Time efficient- Put them in a map.
	2. Space efficient- mergeSort them and start from front and rear.
	 */
	
	// O(n)
    // Algorithm -
	// Ek map maintain karo jis mein key will be the number and value will be the getCellIndex
    // Then walk through the array
    // Jo number abhi mil raha hai, use target mein se minus karoge to agla number mil jayega
    // Ab check karo ki ye dusra number map mein kabhi store kiya tha?
    // If yes, then wohi tumhara number hai and map mein us key se uski getCellIndex value nikaal lo.
    public static int[] twoSum(int[] nums, int target) 
    {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<nums.length; i++) {

            int numberToFind = target - nums[i];

            if(map.containsKey(numberToFind)) {
                result[0] = map.get(numberToFind);
                result[1] = i;
                return result;
            }
            
            map.put(nums[i], i);
        }
        
        return result;
    }
}
