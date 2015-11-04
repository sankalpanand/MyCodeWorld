package easy;

public class MoveZeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// Q- Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
	// We keep running two pointers from 0th index
    // Whenever a 0 is met, the fast pointer will run ahead leaving 0s in between
    // in this case, whenever a non zero element is met, swap both pointer's values.
    public void moveZeroes(int[] nums) 
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
            
            readHere++;
        }
    }

}
