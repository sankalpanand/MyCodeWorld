package Leetcode.Medium;

public class Q81SearchInRotatedSortedArray2 {

	public static void main(String[] args) {
		Q81SearchInRotatedSortedArray2 obj = new Q81SearchInRotatedSortedArray2();

	}

	// Neetcode - https://www.youtube.com/watch?v=oUnF7o88_Xc
	// Leetcode - https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
	public boolean search(int[] nums, int target) {
		int l = 0, r = nums.length - 1;

		while (l <= r) {
			int m = (l+r) / 2;
			if (nums[m] == target) {
				return true;
			}

			// Check if the left portion is sorted
			if (nums[l] < nums[m]) {
				if (nums[l] <= target && target < nums[m]) {
					r = m - 1;
				} else {
					l = m + 1;
				}
			}
			// Check if the right portion is sorted
			else if (nums[l] > nums[m]) {
				if (nums[m] < target && target <= nums[r]) {

					l = m + 1;
				} else {
					r = m - 1;
				}
			}
			// Handle duplicates
			else {
				l++;
			}
		}
		return false;
	}

}
