package Leetcode.Medium;

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
	public List<List<Integer>> permuteUnique2(int[] nums)
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

	// https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)?page=2
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(list, new ArrayList<>(), nums, new boolean[nums.length], 0);
		return list;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, boolean [] used, int depth){
//        System.out.format("depth: %s, tempList: %s\n", depth, tempList);
		if(tempList.size() == nums.length){
			list.add(new ArrayList<>(tempList));
            System.out.format("ADDED! depth: %s, tempList: %s, used: %s\n", depth, tempList, Arrays.toString(used));

		} else{
			for(int i = 0; i < nums.length; i++){
//                System.out.format("i: %s, depth: %s, tempList: %s\n", i, depth, tempList);
                // Skip this number if,
			    // 1) Ye wala number pahle used ho chuka hai
                boolean hasItBeenUsed = used[i];

                // 2) Ye wala number us se pahle wale ke barabar hai and pahle wala consider kiya ja chuka hai
                // the previous number was considered for the current position (which means it's used[i] is already unset.
                // If however, the previous number was picked in a lower depth of backtrack, then it's used[i] flag would not be unset yet.
                boolean secondCondition = (i > 0 && nums[i] == nums[i-1] && !used[i - 1]);
                boolean shouldContinue = hasItBeenUsed || secondCondition;
                System.out.format("depth: %s, i: %s, nums[%s]: %s, skip: %s, tempList: %s, used: %s\n", depth, i, i, nums[i], shouldContinue, tempList, Arrays.toString(used));

                if(secondCondition == true && hasItBeenUsed == false) {
                    System.out.println();
                }

                if(shouldContinue) {
                    continue;
                }
				used[i] = true;
				tempList.add(nums[i]);
				backtrack(list, tempList, nums, used, depth+1);
				used[i] = false;
				tempList.remove(tempList.size() - 1);
			}
		}
	}
}
