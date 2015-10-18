package easy;

public class RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int removeDuplicates(int[] nums) {

		if(nums.length <= 1) return nums.length;
		int newIndex = 1;

		for(int i=1; i < nums.length; i++)
		{
			// If digits are not same, then store it to the beginning
			if(nums[i] != nums[i-1])
			{
				nums[newIndex] = nums[i];
				newIndex++;
			}
			
			// If digits are same, then move ahead. We're tracking the position to write using newIndex
		}
		return newIndex;
	}

}
