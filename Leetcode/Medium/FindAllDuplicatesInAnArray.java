package Leetcode.Medium;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray {
    public static void main(String[] args) {

    }

    // https://www.youtube.com/watch?v=aMsSF1Il3IY

    // All the values minus 1 form valid indexes.
    // So we're gonna use this property.
    // We'll set the value at n - 1 index as negative, so that when we see a negative value next time,
    // we know that's our candidate
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i])-1;
            if (nums[index] < 0)
                res.add(Math.abs(index+1));
            nums[index] = -nums[index];
        }

        return res;
    }

}
