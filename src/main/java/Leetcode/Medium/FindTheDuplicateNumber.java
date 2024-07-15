package Leetcode.Medium;

public class FindTheDuplicateNumber {

    public static void main(String[] args) {
        FindTheDuplicateNumber obj = new FindTheDuplicateNumber();
        int[] nums = {1,3,4,2,2};
        int[] nums2 = {3,1,3,4,2};

        System.out.println(obj.findDuplicate(nums2));

    }

    // Leetcode - https://leetcode.com/problems/find-the-duplicate-number/description/
    // Neetcode - https://www.youtube.com/watch?v=wjYnzkAhcNk

    // Floyd's Cycle Detection Algo
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        int finder = 0;

        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];

            if (slow == fast)
                break;
        }

        while (true) {
            slow = nums[slow];
            finder = nums[finder];

            if (slow == finder)
                return slow;
        }
    }
}

