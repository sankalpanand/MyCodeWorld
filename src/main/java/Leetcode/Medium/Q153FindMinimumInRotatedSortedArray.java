package Leetcode.Medium;

public class Q153FindMinimumInRotatedSortedArray {

	public static void main(String[] args) {
		Q153FindMinimumInRotatedSortedArray obj = new Q153FindMinimumInRotatedSortedArray();
		int[] nums = {3, 4, 5, 1,2};
		System.out.println(obj.findPivot(nums));
		System.out.println(obj.findMin(nums));
	}

	// Neetcode - https://www.youtube.com/watch?v=nIVW4P8b1VA
	// Leetcode - https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
	// This is complicated to remember. The other approach is much simpler to understand.
	public static int findMin1(int[] num) {
		int l = 0;
		int r = num.length - 1;
		int res = num[0];

		while (l <= r) {
			if(num[l] < num[r]) {
				res = Math.min(res, num[l]);
				break;
			}

			int mid = (l + r) / 2;
			res = Math.min(res, num[mid]); // We update the minimum by the mid pointer always

			if (num[mid] >= num[l]) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}

		return res;
	}

	public int findMin(int[] num) {
		int pivotIndex = findPivot(num);
		return num[pivotIndex];
	}

	public int findPivot(int array[]) {
		int left = 0;
		int right = array.length - 1;

		while (left < right) {
			int mid = left + (right - left) / 2;

			if (array[mid] > array[right]) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}

		return left;
	}

}
