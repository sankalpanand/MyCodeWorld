package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Permutations obj = new Permutations();
		int[] nums = {1,2,3};
		System.out.println(obj.permute(nums));
	}

	// Use this image - http://www.geeksforgeeks.org/wp-content/uploads/NewPermutation.gif
	// http://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/

	/* 
		helper(0)
		swap(0,0)		swap(0,1)		swap(0,2) // First position fixed after this
		helper(1)		helper(1)		helper(1)


		helper(1)
		swap(1,1)		swap(1,2) // These two will emanate from each of the above 3. They will have different arrays.
		helper(2)

		helper(2)
		swap(2,2)
		helper(3)
	 */

	// Time Complexity: O(n*n!)
	List<List<Integer>> result;
	int[] nums;
	public List<List<Integer>> permute(int[] nums) 
	{
		result = new ArrayList<List<Integer>>();
		this.nums = nums;
		helper(nums, 0);
		return result;
	}

	public void helper(int[] nums, int begin)
	{
		// Base case- begin nums.length ke barabar aa chuka hai... matlab ab array ko list mein chadha do
		// Note that ki ye array original nums nahi hai... swap ho ho ke yahan tak pahuchi hai
		// Aisi aur bhi branches aa rahi hongi
		if(begin >= nums.length)
		{
			List<Integer> list = new ArrayList<Integer>();
			for(int i=0; i<nums.length; i++)
			{
				list.add(nums[i]);
			}
			result.add(list);
			return;
		}

		// i = 0, 1, 2
		for(int i=begin; i<nums.length; i++)
		{
			// Ek baar 0, 0 se swap hoga, fir 0, 1 se and finally fir 0, 2 se
			swap(nums, begin, i);

			// Ek baar swap karne ke baad hum ab next index se chaalu karenge
			helper(nums, begin+1);  

			// Wapas swap karo to restore the array for next i'th iteration
			swap(nums, begin, i);
		}
	}

	public void swap(int[] nums, int x, int y)
	{
		int temp = nums[x];
		nums[x] = nums[y];
		nums[y] = temp;
	}
}
