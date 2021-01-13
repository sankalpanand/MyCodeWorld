package Leetcode.Medium;

public class FindTheDuplicateNumber {

    public static void main(String[] args) {
        FindTheDuplicateNumber obj = new FindTheDuplicateNumber();
        int[] nums = {1,3,4,2,2};
        int[] nums2 = {3,1,3,4,2};

        System.out.println(obj.findDuplicate(nums2));

    }

    // Several approaches here - https://medium.com/solvingalgo/solving-algorithmic-problems-find-a-duplicate-in-an-array-3d9edad5ad41

    public int findDuplicate(int[] nums) {
        int n=nums.length-1;
        int left=0, right=n;

        while(left<right) {
            int mid = left + (right-left)/2;
            int count = numBelow(nums, mid);

            if(count > mid)
                right=mid;
            else
                left=mid+1;
        }

        return left;
    }

    public int numBelow(int[] nums, int target) {
        int result=0;

        for(int i=0; i<nums.length; i++) {
            if (nums[i] <= target)
                result++;
        }

        return result;
    }

    // Floyd's Cycle Detection Algo
    public int findDuplicate1(int[] nums) {
        int slow = 0;
        int fast = 0;
        int finder = 0;

        while (true)
        {
            slow = nums[slow];
            fast = nums[nums[fast]];

            if (slow == fast)
                break;
        }

        while (true)
        {
            slow = nums[slow];
            finder = nums[finder];

            if (slow == finder)
                return slow;
        }
    }
}

