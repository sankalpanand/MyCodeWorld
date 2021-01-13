package Leetcode.Easy;

public class RemoveElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int removeElement(int[] nums, int val) 
	{
		// Jab tak different values aati rahengi, i and m saath saath badhenge
		// Jab same value aa jayegi, m aage nahi badhega because hame wahi pe overwrite karni hongi values
		int writeHere = 0;

		for(int readHere=0; readHere<nums.length; readHere++)
		{
			if(nums[readHere] != val)
				nums[writeHere++] = nums[readHere];
		}

		return writeHere;
	}



}
