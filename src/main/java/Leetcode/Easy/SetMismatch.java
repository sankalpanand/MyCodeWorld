package Leetcode.Easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMismatch {

    public static void main(String[] args) {
        SetMismatch obj = new SetMismatch();
        // int[] nums = {2,2};
        int[] nums = {1,2,2,4};
        System.out.println(Arrays.toString(obj.findErrorNums2(nums)));
    }

    public static int[] findErrorNums(int[] nums) {
        int[] res = new int[2];

        for (int i=0; i<nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1] < 0) // Agar wahan pahle se negative value hai, to ye number pakka repeated hai
            {
                res[0] = Math.abs(nums[i]);
            }
            else
                nums[Math.abs(nums[i]) - 1] *= -1;
        }

        for (int i=0; i<nums.length; i++)
        {
            if (nums[i] > 0)
                res[1] = i+1;
        }
        return res;
    }

    // Without modifying the input array
    public int[] findErrorNums2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int duplicate = 0, n = nums.length;
        long sum = (n * (n+1)) / 2;

        for(int i : nums)
        {
            if(set.contains(i))
                duplicate = i;
            sum -= i;
            set.add(i);
        }

        return new int[] { duplicate, (int)sum + duplicate};
    }
}
