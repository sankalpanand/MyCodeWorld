package LeetcodeMedium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Permutations2 obj = new Permutations2();
		int[] nums = {1,1,2};
		System.out.println(obj.permuteUnique(nums));
	}

	// Back tracking solution
	// Time Complexity: O(n*n!)
	//  For printing each permutation O(n) time is required.

	// Use this image - http://www.geeksforgeeks.org/wp-content/uploads/NewPermutation.gif
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

	List<List<Integer>> result = null;
	public List<List<Integer>> permuteUnique(int[] nums) 
	{
		result = new ArrayList<>();
		Arrays.sort(nums);
		permutating(nums, 0);
		return result;
	}

	private void permutating(int[] nums, int begin) 
	{
		if (begin >= nums.length) 
		{
			List<Integer> list = new ArrayList<Integer>();

			for (int n : nums) 
			{
				list.add(n);
			}

			result.add(list);
			return;
		}

		for (int i = begin; i < nums.length; i++) 
		{
			if (i != begin && nums[begin] == nums[i]) 
			{
				continue;
			}

			swap(nums, begin, i);
			permutating(Arrays.copyOf(nums, nums.length), begin+1);

			// My previous logic  of backswapping works perfectly fine, however, gives TLE here.
			// So, basically remember this continue block, and you are good to go for the interview.

			// Here we are sending the copy of arrays, so back swaping is not necessary
			// swap(nums, begin, i);
		}
	}

	private void swap(int[] nums, int i, int j) 
	{
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
