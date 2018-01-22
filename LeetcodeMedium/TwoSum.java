package LeetcodeMedium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {

		int[] nums = {3,2,4};
		int[] res = twoSum2(nums, 6);
		System.out.println(Arrays.toString(res));
	}

	
	/*
	Given an array of integers, find two numbers such that they add up to a specific target number.
	The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. 
	Please note that your returned answers (both index1 and index2) are not zero-based.
	 */
	
	/*
	2 Solutions- 
	1. Time efficient- Put them in a map.
	2. Space efficient- Sort them and start from front and rear.
	 */
	
	// O(n)
    // We start traversing the array
    // Put the number and its index in the hash map
    // Also, keep on checking whether the remainder (target-num[i]) is there in the map or not.
    // It can be there from the previous terms.
    // If it is there, it means i'th number is 'b' in a+b and the 'a' is there in the map.
    // So, generate the array and return
    public static int[] twoSum(int[] nums, int target) 
    {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i=0; i<nums.length; i++)
        {
            int numberToFind = target - nums[i];
            if(map.containsKey(numberToFind))
            {
                result[0] = map.get(numberToFind);
                result[1] = i;
                return result;
            }
            
            map.put(nums[i], i+1);
        }
        
        return result;
    }
    
    // This is O(n) time and O(1) space but I can not give back indices. Only the numbers.
    public static int[] twoSum2(int A[], int sum)
	{
		int n = A.length;
	    int l=0;
	    int r=n-1;
	    
	    int[] result = new int[2];
	 
	    /* Sort the elements */
	    Arrays.sort(A);
	 
	    /* Now look for the two candidates in the sorted array*/	    
	    while (l < r)
	    {
	         if(A[l] + A[r] == sum)
	         {
	        	 result[0] = A[l];
	        	 result[1] = A[r];
	        	 return result;
	         }
	               
	         else if(A[l] + A[r] < sum)
	              l++;
	         else // A[i] + A[j] > sum
	              r--;
	    }    
	    
	    return result;
	}
}
