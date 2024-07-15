package Leetcode.Medium;

import java.util.*;

public class Q15ThreeSum {
    public static void main(String[] args) {
        Q15ThreeSum obj = new Q15ThreeSum();
        List<List<Integer>> result;

        int[] nums2 = {1, 0, -1, 2, -1, 4};
        result = obj.threeSum(nums2, 2);

        for(List<Integer> set : result) {
            System.out.println(Arrays.asList(set));
        }
    }

    public  List<List<Integer>> threeSum(int[] nums, int target) {
        Set<List<Integer>> res  = new HashSet<>();

        if(nums.length == 0)
            return new ArrayList<>(res);

        Arrays.sort(nums);

        for(int i=0; i<nums.length-2; i++) {
            int j = i+1;
            int k = nums.length-1;

            while(j < k) {
                int sum = nums[i]+nums[j]+nums[k];
                if(sum==target)
                    res.add(Arrays.asList(nums[i],nums[j++],nums[k--]));
                else if (sum > target)
                    k--;
                else if (sum < target)
                    j++;
            }

        }
        return new ArrayList<>(res);

    }
}
