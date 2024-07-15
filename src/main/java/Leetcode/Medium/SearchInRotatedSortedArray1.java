package Leetcode.Medium;

public class SearchInRotatedSortedArray1 {

	public static void main(String[] args) {
		SearchInRotatedSortedArray1 solution = new SearchInRotatedSortedArray1();
		int[] nums = {4, 5, 6, 7, 0, 1, 2};
//		int target = 0;
//		int result = solution.search(nums, target);
//		System.out.println("The index of the target is: " + result); // Output should be 4

		nums = new int[] {95, 99, 9, 11, 22, 26, 37, 54, 59, 73, 79, 92};
		System.out.println(solution.search(nums, 9));
	}

	public int search(int[] nums, int target) {
		int l = 0, r = nums.length - 1;

		while (l <= r) {
			int mid = (l + r) / 2;
			int numMid = nums[mid];

			if (target == numMid) {
				return mid;
			}

			// Check if the left half is sorted
			int numL = nums[l]; int numR = nums[r];

			// If leftmost element is smaller, then it means the pivot is somewhere on the right and left partition will be sorted
			if (numL <= numMid) {
				// Now if the target lies in the partition with the pivot, it can be either before the pivot or after pivot. So we need to OR two conditions as below.
				if (target > numMid
						|| target < numL) {	// left partition is sorted but target is even smaller than the left, so the target should be in the right partition
					l = mid + 1;
				} else {					// left partition is sorted but target is greater than the left, so the target should be in the left partition
					r = mid - 1;
				}
			}
			// If leftmost element is larger, then it means the pivot is somewhere on the left and right partition will be sorted
			else {
				// Check if the target is in the right half
				if (target < numMid			// right partition is sorted but target is smaller than the mid, which means the target should be in the left partition
						|| target > numR) {	// right partition is sorted but target is greater than right element, which means target should be in the left partition
					r = mid - 1;
				} else {
					l = mid + 1;
				}
			}
		}
		return -1;
	}

}
