package Leetcode.Easy;

public class Q88MergeSortedArray {

	public static void main(String[] args) {
        Q88MergeSortedArray obj = new Q88MergeSortedArray();
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        obj.merge(nums1, 3, nums2, 3);

//        int[] nums1 = {0};
//        int[] nums2 = {1};
//        obj.merge(nums1, 0, nums2, 1);


        obj.merge(nums1, 0, nums2, 1);
	}

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) { // i should be >= 0 for the corner case when m=0
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
    }

}
