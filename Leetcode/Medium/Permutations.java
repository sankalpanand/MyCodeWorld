package Leetcode.Medium;

import java.util.ArrayList;
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
	public List<List<Integer>> permute2(int[] nums)
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

			// Ek baar swap karne ke baad hum ab next getCellIndex se chaalu karenge
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


	// https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)?page=2
    /*
                                             () [123]
                 (1)[123]                   (2)[123]                (3)[123]
            (12)[123]   (13)[123]   (21)[123]   (23)[123]       (31)[123]   (32)[123]
            (123)        (132)       (213)          (231)         (312)          (321)
     */
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		// Arrays.sort(nums); // not necessary
		backtrack(list, new ArrayList<>(), nums);
		return list;
	}

	private void backtrack(List<List<Integer>> result, List<Integer> tempList, int [] nums){
		if(tempList.size() == nums.length){
            result.add(new ArrayList<>(tempList));
            // System.out.println("Added: " + tempList);
        } else{
			for(int i = 0; i < nums.length; i++){
                // System.out.println("------- i=" + i + " starts --------");
				if(tempList.contains(nums[i])) continue; // element already exists, skip
				tempList.add(nums[i]);
                // System.out.println("Sending down to level " + (i+1) + ", list: " + tempList);
				backtrack(result, tempList, nums);
				tempList.remove(tempList.size() - 1); // Remove the last item that was added
                // System.out.println("Going back to level " + (i-1) + ", with list: " + tempList);
			}
		}
	}
}
