package Leetcode.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingRanges {
    public static void main(String[] args) {
        int[] nums1 = {0,1,3,50,75};
        int[] nums2 = {};
        int[] nums3 = {-1};


        MissingRanges missingRanges = new MissingRanges();
        System.out.println(Arrays.toString(missingRanges.findMissingRanges(nums1, 0, 99).toArray()));
        System.out.println(Arrays.toString(missingRanges.findMissingRanges(nums2, 1, 1).toArray()));
        System.out.println(Arrays.toString(missingRanges.findMissingRanges(nums2, -3, -1).toArray()));
        System.out.println(Arrays.toString(missingRanges.findMissingRanges(nums3, -1, -1).toArray()));
        System.out.println(Arrays.toString(missingRanges.findMissingRanges(nums3, -2, -1).toArray()));
    }

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0){
            result.add(formRange(lower,upper));
            return result;
        }

        // Step 1 - Find the range between lower and first element in the array.
        // If lower is lesser than the first element, it means there's a gap.
        if (lower < nums[0]){
            result.add(formRange(lower,nums[0]-1));
        }

        // Step 2 - This is the meat of the problem
        // Find ranges between adjacent elements in the array.
        for (int i = 0; i < nums.length-1; i++) {
            // If two adjacent numbers aren't the same and their diff is more than 1,
            // its a candidate.
            if (nums[i+1] != nums[i] && nums[i+1] > nums[i] +1) {
                result.add(formRange(nums[i]+1, nums[i+1]-1));
            }
        }

        // Step 3 = Find the range between upper and last element in the array.
        if (nums[nums.length-1] < upper){
            result.add(formRange(nums[nums.length-1]+1, upper));
        }
        return result;
    }

    public String formRange(int low, int high){
        return low == high ? String.valueOf(low) : (low + "->" + high);
    }
}

