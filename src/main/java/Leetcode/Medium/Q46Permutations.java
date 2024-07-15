package Leetcode.Medium;

import java.util.ArrayList;
import java.util.List;

public class Q46Permutations {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Q46Permutations obj = new Q46Permutations();
		int[] nums = {1,2,3};
		System.out.println(obj.permute(nums));
	}

	// https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)?page=2
    /*
                                             () [123]
                 (1)[123]                   (2)[123]                (3)[123]
            (12)[123]   (13)[123]   (21)[123]   (23)[123]       (31)[123]   (32)[123]
            (123)        (132)       (213)          (231)         (312)          (321)


		Decision Tree looks like this-

              1			  2			  3
            2	3		1	3		1	2
            3	2		3	1		2	1



       Time Complexity: O(n*n!)

		backtrack method is called n! times

		e.g. [0,1,2]
		in 1st iteration backtrack is called 3 times ( for 0,1,2 )
		in 2nd iteration ( for 0 ) backtrack is called 2 times ( for 1,2 )
		in 2nd iteration ( for 1 ) backtrack is called 2 times ( for 0,2 )
		in 2nd iteration ( for 2 ) backtrack is called 2 times ( for 0,1 )
		in 3rd iteration ( for 0,1 ) backtrack is called 1 times ( for 2 )
		and so on.

		So no. of times backtrack is called in above example is 3 * 2 * 1, which is 3!
		for n elements, its n!

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

				if(tempList.contains(nums[i]))
					continue; // element already exists, skip

				tempList.add(nums[i]);
                // System.out.println("Sending down to level " + (i+1) + ", list: " + tempList);

				backtrack(result, tempList, nums);
				tempList.remove(tempList.size() - 1); // Remove the last item that was added

				// System.out.println("Going back to level " + (i-1) + ", with list: " + tempList);
			}
		}
	}
}
