package LeetcodeEasy;

public class RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// This is one case where i will start from 1, because we actually need to check with one element behind it.
	public int removeDuplicates(int[] nums) 
    {
		if(nums.length <= 1) return nums.length;
		int newIndex = 1;
        int i=1;
        
		while(i < nums.length)
		{
			// If digits are different, then newIndex and i will walk together. 
			if(nums[i] != nums[i-1]) nums[newIndex++] = nums[i++];
			
			// They will separate once a duplicate occurs, newIndex will be left behind so that it could be overwritten
			else i++;
			
			// If duplicate digits appear, then move ahead. In this case, newIndex will left behind.
			// This way, duplicate elements will be overwritten when the unique number comes in the next iteration.
		}
		return newIndex;
	}

}
