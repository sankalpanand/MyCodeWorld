package Leetcode.Easy;

import java.util.Arrays;

public class MoveZeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0, 1, 0, 3, 12};
		moveZeroes(nums);
		// System.out.println(Arrays.toString(nums));

	}
	
	// Q- Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
	// We keep running two pointers from 0th getCellIndex
    // Whenever a 0 is met, writeHere will be left behind
    // For non zero, element, swapping has to be done, readHere and writeHere will go together
    public static void moveZeroes(int[] nums) 
    {
        int writeHere = 0;
        int readHere=0;
        
        while(readHere < nums.length)
        {
            if(nums[readHere] != 0)
            {
                int temp = nums[readHere];
                nums[readHere] = nums[writeHere];
                nums[writeHere] = temp;
                
                writeHere++;
            }
            
            System.out.println(Arrays.toString(nums));
            
            readHere++;
        }
    }

}
