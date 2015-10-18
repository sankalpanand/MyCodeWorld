package easy;

public class MoveZeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// We keep running two pointers from 0th index
    // Whenever a 0 is met, the fast pointer will run ahead leaving 0s in between
    // in this case, whenever a non zero element is met, swap both pointer's values.
    public void moveZeroes(int[] nums) {
        int last=0;
        int curr=0;
        
        while(curr<nums.length)
        {
            if(nums[curr] != 0)
            {
                int temp = nums[curr];
                nums[curr] = nums[last];
                nums[last] = temp;
                
                last++;
            }
            curr++;
        }
    }

}
